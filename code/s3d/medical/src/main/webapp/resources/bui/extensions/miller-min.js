/**
 * @fileOverview 命名空间入口
 * @ignore
 */

define('bui/extensions/miller',['bui/common','bui/data'],function(require){
	var BUI = require('bui/common'), Data = require('bui/data');	
	var miller = BUI.Component.Controller.extend({
		_hasFocus : false,
		_currentAjaxRequest:null,
		_columns:null,
		
		bindUI: function () {
	      var _self = this;
	      var miller = _self.get("el");
	      miller.addClass('miller').focus(function () {
	    	  _self._hasFocus = true;
          }).blur(function () {
        	  _self._hasFocus = false;
          });
	      var path = $('<div>', {
              'class': 'path'
          }).appendTo(miller);

          _self._columns = $('<div>', {
              'class': 'columns'
          }).appendTo(miller);
          
          _self._columns.height(_self.get('columnHeight'));          
          var currentLine = null;

          $(document).keypress(function (event) {
              if (_self._hasFocus && currentLine && event.which != 37 && event.which != 38 && event.which != 39 && event.which != 40) {
                  var newCurrentLine = currentLine.parent().children().filter(function () {
                      return $(this).text().match(new RegExp('^' + String.fromCharCode(event.which)));
                  }).first();
                  if (newCurrentLine.length) {
                      currentLine = newCurrentLine.click();
                  }
              }
          });

          $(document).keydown(function (event) {
              if (_self._hasFocus && currentLine && (event.which == 37 || event.which == 38 || event.which == 39 || event.which == 40)) {
                  var newCurrentLine = [];
                  var scrollTop = currentLine.parent().scrollTop();
                  switch (event.which) {
                  case 37:
                      newCurrentLine = currentLine.parent().prev().prev().find('li.parentSelected');
                      break;
                  case 38:
                      newCurrentLine = currentLine.prev();
                      if (!newCurrentLine.length && _self.get('carroussel')) {
                          newCurrentLine = currentLine.parent().find('li:last');
                          scrollTop = newCurrentLine.position().top;
                      }
                      break;
                  case 39:
                      newCurrentLine = currentLine.parent().next().next().find('li:first');
                      break;
                  case 40:
                      newCurrentLine = currentLine.next();
                      if (!newCurrentLine.length && _self.get('carroussel')) {
                          newCurrentLine = currentLine.parent().find('li:first');
                          scrollTop = 0;
                      }
                      break;
                  }
                  if (newCurrentLine.length && !newCurrentLine.parent().hasClass('pane')) {
                      currentLine = newCurrentLine.click();
                  }
                  return false;
              }
          });
          var fireSelectionChange = function (){
        	  var line = $(this);
        	  _self.fire('selectionChange',{id : line.data("id"),text:line.text()});
          };
          var removeNextColumns = function () {
              var line = $(this);
              var column = line.parent();
              column
                  .nextAll()
                  .slice(1)
                  .remove();
              column
                  .find('li')
                  .removeClass('selected parentSelected');

              line.addClass(line.hasClass('parent') ? 'parentSelected' : 'selected');

              var node = $('<span>', {
                  'text': line.text()
              })
                  .data('id', line.data('id'))
                  .click(function () {
                      _self._columns
                          .children()
                          .slice((($(this).index() * 2) + 4))
                          .remove();
                      _self._columns
                          .children('ul:last')
                          .find('li')
                          .removeClass('parentSelected');
                      path
                          .children()
                          .slice($(this).index() + 1)
                          .remove();
                  })
                  .appendTo(path);

              var child = column.index();

              child -= (child - (child / 2));

              path
                  .scrollLeft(node.position().left)
                  .children()
                  .slice(child, -1)
                  .remove();
          };

          var buildColumn = function (lines) {
        	  var getWidthFromString = function(str){
            	  var w = l = str.length;
            	  for(var i=0;i<l;i++){
            		  if(str.charCodeAt(i)>=255){
            			  w++;
            		  }
            	  }
            	  return w;
              };
              if (lines == null) {
                  $('li.parentLoading').remove();
              } else {
                  if (currentLine) {
                      var currentColumn = currentLine.parent();
                      var scroll = 0;
                      var scrollTop = currentColumn.scrollTop();
                      var topOfCurrentLine = currentLine.position().top;

                      if (topOfCurrentLine < 0) {
                          scroll = topOfCurrentLine;
                      } else {
                          var bottomOfCurrentLine = currentLine.position().top + currentLine.height();
                          var heightOfCurrentColumn = currentColumn.height();

                          if (bottomOfCurrentLine > heightOfCurrentColumn) {
                              scroll = bottomOfCurrentLine - heightOfCurrentColumn;
                          }
                      }
                      currentColumn.scrollTop(scrollTop + scroll);
                  }

                  var width = 0;

                  var lastGrip = _self._columns.children('div.grip:last')[0];

                  if (lastGrip) {
                      lastGrip = $(lastGrip);
                      width = lastGrip.position().left + lastGrip.width() + _self._columns.scrollLeft();
                  }

                  if (lines.length <= 0) {
                      var line = $('li.parentLoading')
                          .removeClass('parent')
                          .addClass('selected');
                  } else {
                      $('li.parentLoading').addClass('parentSelected');

                      var column = $('<ul>')
                          .css({
                              'top': 0,
                              'left': width
                          });

                      $.each(lines, function (id, data) {
                          var nodeHTML = data['text']+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                          if (data['cls']) {
                              nodeHTML = "<i class=" + data['cls'] + "></i>" + nodeHTML;
                          }
                          var line = $('<li>', {
                              'html': nodeHTML
                          }).data('id', data['id'])
                              .click(removeNextColumns)
                              .click(fireSelectionChange)
                              .click(getLines)
                              .appendTo(column);

                          if (data['leaf'] == false || data['parent']) {
                              line.addClass('parent');
                          }
                      });
                      _self._columns
                          .append(column)
                          .scrollLeft(width += column.width())
                          .append(
                              $('<div>', {
                                  'class': 'grip'
                              })
                              .css({
                                  'top': 0,
                                  'left': width
                              }).mousedown(function (event) {
                                  var x = event.pageX;
                                  var cursor = _self._columns.css('cursor');
                                  _self._columns
                                      .css('cursor', 'col-resize')
                                      .mousemove(function (event) {
                                          var delta = event.pageX - x;
                                          var newWidth = column.width() + delta;
                                          if (newWidth > _self.get('minWidth')) {
                                              column
                                                  .width(newWidth)
                                                  .nextAll()
                                                  .each(function () {
                                                      $(this).css('left', $(this).position().left + delta + _self._columns.scrollLeft());
                                                  });
                                          }
                                          x = event.pageX;
                                      }).mouseup(function () {
                                          _self._columns.off('mousemove').css('cursor', cursor);
                                      });
                              })
                      );
                  }
              }
          };
          var getLines = function (event) {
              if (_self._currentAjaxRequest) {
            	  _self._currentAjaxRequest.abort();
              }
              currentLine = $(event.currentTarget)
                  .removeClass('parentSelected')
                  .addClass('parentLoading');
              var url = _self.get("url");
              if($(this).data('id')) url+="&parent="+$(this).data('id');
              _self._currentAjaxRequest = $.getJSON(url, buildColumn)
                  .always(function () {
                      currentLine.removeClass('parentLoading');
                      _self._currentAjaxRequest = null;
                  }).fail(function () {});
          };
          $.getJSON(_self.get("url"), buildColumn);
          //return miller;
	    }
	},{
		ATTRS : {
			url : {
				value : ''
			},
			tabindex : {
				value : 0
		    },
		    columnHeight : {
				value : 129
		    },
		    minWidth : {
		    	value : 100
		    },
		    carroussel : {
		    	value : false
		    }
		}
	},{
		xclass:'miller'
	});

	return miller;
});

