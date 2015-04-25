

define('js/main',['bui/common','bui/module','bui/layout','bui/grid','bui/data','bui/imgview','bui/list','bui/tooltip'],function(r){
  var BUI = r('bui/common'),
    Module = r('bui/module'),
    Layout = r('bui/layout'),
    List = r('bui/list'),
    Imgview = r('bui/imgview'),
    Tooltip = r('bui/tooltip')



  function Main(config){
    Main.superclass.constructor.call(this, config);
  }

  BUI.extend(Main, Module);

  BUI.augment(Main, {
    /**
     * Module执行顺序
     * this._initData();
     * this._initDom();
     * this._initModules();
     * this._initEvent();
     * this.set('hasInit',true);
     */
    _initData: function(){
    },
    _initDom: function(){
      this.__initLayout();
      this.__initViewContent();
      this.__initCenterSize(this);
      this.__initTab();
    },
    _initEvent: function(){
      this.__initResize();
      // Cancel shortcut since it's conflict with other shortcut
      //this.__initKeyMaster();
      this.__initMousewheel();
    },
    __initLayout: function(){
      var _self = this;
      var layout = new Layout.Viewport({
        elCls: 'ext-border-layout',
        children: [{
          layout: {
            region: 'north',
            height: _self.get('northHeight')
          },
          xclass: 'controller',
          content: $(".north")
        },
        {
          layout: {
            region: 'east',
            fit: 'both',
            collapsable: false,
            width: _self.get('eastWidth')
          },
          xclass: 'controller',
          content: $(".east")
        },{
          layout: {
            region: 'center',
            fit: 'both'
          },
          xclass: 'controller',
          content: $(".center")
        }],
        plugins: [Layout.Border],
        autoRender: true
      });
      this.set('layout', layout);
    },
    __initViewContent: function(){
      var _self = this,
        viewContents = _self.get('viewContents'),
        viewContentCfg = _self.get('viewContentCfg'),
        defaultImgs = _self.get('defaultImgs'),
        activeImgView = _self.get('activeImgView'),
        viewWraps = _self.get('viewWraps');
      for(var i = 0 ; i < viewWraps.length ; i ++){

        var viewWrap = viewWraps[i];
        viewContents.push(new Imgview.ViewContent(BUI.mix(viewContentCfg, {
          width: viewWrap.width(),
          height: viewWrap.height()/2,
          render: viewWrap,
          imgSrc: _self.get('imgSrc' + i),
          autoRender: true
        })))
      }

      _self.set('viewContents', viewContents);
    },
    __initCenterSize: function(_self, wrapModel){
      var imgviewWrap = _self.get('imgviewWrap'),
        viewContents = _self.get('viewContents'),
        wrapModel = typeof wrapModel === "number" ? wrapModel: _self.get('wrapModel'),
        centerWrap = $(_self.get('centerWrap')),
        centerWdith = centerWrap.width(),
        centerHeight = centerWrap.height(),
        cls = imgviewWrap.attr("class"),
        viewWraps = _self.get('viewWraps');

      imgviewWrap.height(centerHeight);
      
      for(var i = 0 ; i < viewWraps.length ; i ++){
        var viewWrap = viewWraps[i];
        var viewContent = viewContents[i];
        if(wrapModel==2){
        	viewWrap.show();
        }else{
        	if (wrapModel >= i) {
        		viewWrap.show();
        	} else {
        		viewWrap.hide();
        	}
        }
        
        var viewWrapWidth = parseInt(centerWdith / (wrapModel+1)) - 4;

        var viewWrapHeight = (centerHeight / (wrapModel==2?2:1)) - 4;
        viewWrap.width(viewWrapWidth).height(viewWrapHeight);
        viewContent.set('width', viewWrapWidth);
        viewContent.set('height', viewWrapHeight);
      }
      _self.set('centerWrap', centerWrap);
    },
    __initSimpleList: function(){
      var _self = this,
        list = new List.SimpleList({
          elCls: _self.get('listCls'),
          render: _self.get('previewListWrap'),
          itemTpl: _self.get('itemTpl'),
          autoRender: true
        });

      list.get('el').find("ul").addClass("clearfix");
      _self.set('list', list);
    },
    __initResize: function(){
      var _self = this,
        centerWrap = _self.get('centerWrap');

      centerWrap.resize(function(){
        _self.__initCenterSize(_self);
      });
      if(screenfull.enabled){
        $(window).resize(function(){
          var centerWrap = $(".x-border-center");
          if (!screenfull.isFullscreen) {
            centerWrap.css({
              zIndex: 0,
              width: "",
              height: "",
              left: 0,
              top: 0
            })
          }else{
            centerWrap.css({
              zIndex: 1000,
              width: screen.width,
              height: screen.height + _self.get('previewListHeight'),
              left: -_self.get('westWidth') - 1,
              top: -_self.get('northHeight')
            })
          }
        })
      }
    },
    // 绑定键盘事件
    __initKeyMaster: function(){
      var _self = this,
        keyCommands = _self.get('keyCommands');

      for(keyName in keyCommands){
        (function(keyName, cmd){
          if (typeof cmd === "function") {
            key(keyName,"pic", function(e,o){
              cmd(_self.__getKeyTarget(),_self,e,o);
              return false;
            })
          } else {
            key(keyName,"pic", function(){
              _self.__getKeyTarget()[cmd]();
              return false;
            })
          }
        })(keyName, keyCommands[keyName])
      }
    },
    __initMousewheel: function(){
      var _self = this,
        viewWraps = _self.get('viewWraps'),
        viewContents = _self.get('viewContents');

      for(var i = 0 ; i < viewWraps.length ; i ++){
        var viewWrap = viewWraps[i];
        (function(index, viewWrap, viewContent){
          viewWrap.mousewheel(function(event, delta){
            if(_self.get('canMove')){
              _self.set('canMove', false);
              setTimeout(function(){
                _self.set('canMove', true);
              },300)
              if (delta > 0) {
                viewContent.zoom(function(){
                  _self.set('canMove', true);
                });
              } else if (delta < 0) {
                viewContent.micrify(function(){
                  _self.set('canMove', true);
                });
              }
            }
            event.stopPropagation();
            event.preventDefault();
          })
        })(i, viewWraps[i], viewContents[i])
      }
      /*$(document).mousewheel(function(event, delta){
        viewContent = viewContents[_self.get('activeImgView')];
        if(_self.get('canMove')){
          _self.set('canMove', false);
          setTimeout(function(){
            _self.set('canMove', true);
          },300)
          if (delta > 0) {
            viewContent.zoom(function(){
              _self.set('canMove', true);
            });
          } else if (delta < 0) {
            viewContent.micrify(function(){
              _self.set('canMove', true);
            });
          }
        }
      })*/
    },
    __getKeyTarget: function(){
      var activeImgView = this.get('activeImgView');
      return this.get('viewContents')[activeImgView];
    },
    _paintPrev: function(){
      var _self = this,
        imgListLength = _self.get('imgList').length,
        index = (_self.get('selected') + imgListLength - 1) % imgListLength;

      _self.set('selected', index);
    },
    _paintNext: function(){
      var _self = this,
        index = (_self.get('selected') + 1) % _self.get('imgList').length;

      _self.set('selected', index);
    },
    __initTab: function(){
      var _self = this;
      // 初始化tab点击事件
      _self.get('tabs').on('click',function(ev){
        var index = $(this).index();
        _self.set('tabIndex', index);
        _self.set('wrapModel', index);
        _self.set('activeImgView', 0);
        _self._setImgByWrapModel();  
        
        return false;
      });

      $(".imgview-content").on('click',function(ev){
        ev.preventDefault();
        var self = $(this);
        //_self.set('activeImgView', self.index());
      });

      $(".btn-cmd-group a").on('click',function(ev){
        ev.preventDefault();
        var self = jQuery(this),
          cmd = self.data("cmd");

        if (cmd.substr(0,1) == "_") {
          _self[cmd]();
        } else {
          _self.get('viewContents')[_self.get('activeImgView')][cmd]();
        }
      });

      var tips = new Tooltip.Tips({
        tip: {
          trigger: '.btn-group-item', //出现此样式的元素显示tip
          alignType: 'bottom-left', //默认方向
          elCls: 'tips',
          // titleTpl: '<div class="tips-content">{title}</div>',
          offset: 10 //距离左边的距离
        }
      });
      tips.render();


    },
    _fullScreen: function(){
      screenfull.enabled && screenfull.toggle();
    },
    _setImgByWrapModel: function(imgList,activeImgView,offset){
    	imgList =  imgList || this.get('imgList');
    	var wrapModel =  this.get('wrapModel');
    	offset = offset || 0;
        if(wrapModel>0){
        	var max = wrapModel==2?6:2;
        	for ( var i = 0; i < max; i++) {
        		var item = imgList[i+offset];
        		if(item)
        			this.set('imgSrc' + i, wrapModel==1?item.src:item.miniSrc);
        		else
        			this.set('imgSrc' + i, this.get('defaultImg'));
			}
        }else{
        	var item = imgList[offset];
        	var curImgView = activeImgView || 0;
        	if(item)
        		this.set('imgSrc'+curImgView, item.src);
    		else
    			this.set('imgSrc'+curImgView, this.get('defaultImg'));
        }
     }

  });

  Main.ATTRS = {
    imgviewWrap: {
      value: $("#imgview-wrap")
    },
    keyCommands: {
      value: {
        "q": "leftHand",
        "e": "rightHand",
        "w": "zoom",
        "s": "micrify",
        "r": "reset",
        "c": "fitToggle",
        "f": function(target, _self,e,o){
    		var wrapModel =  _self.get('wrapModel');
    		var offset  = wrapModel==2?6:(wrapModel+1);
    		_self._paintNext(e,o,offset);
    	},
        "a,left,up,backspace": function(target, _self,e,o){
          _self._paintPrev(e,o);
        },
        "d,right,down,enter": function(target, _self,e,o){
          _self._paintNext(e,o);
        },
        "1": function(target, _self){
          _self.get('tabs').eq(0).click();
        },
        "2": function(target, _self){
          _self.get('tabs').eq(1).click();
        },
        "3": function(target, _self){
          _self.get('tabs').eq(2).click();
        }
      }
    },
    centerWrap: {
      value: ".x-border-center"
    },
    tabs: {
      value: $(".btn-group .btn-tabs")
    },
    viewWraps: {
      value: [$("#imgview-content-1"), $("#imgview-content-2"), $("#imgview-content-3"),
              $("#imgview-content-4"), $("#imgview-content-5"), $("#imgview-content-6")]
    },
    viewContents: {
      value: []
    },
    tabIndex: {
      value: 0,
      setter: function(v){
        var tabs = this.get('tabs');
        tabs.removeClass("btn-group-active");
        tabs.eq(v).addClass("btn-group-active");
        return v;
      }
    },
    cookieReg: {
      value: "FinderCookie"
    },
    wrapModel: {
      value: 0,
      setter: function(v){
        if(this.get('hasInit')){
          this.__initCenterSize(this, v);
        }
        this.set('tabIndex', v);
        $.cookie("wrapModel" + this.get('cookieReg'), v);
        return v;
      }
    },
    activeImgView: {
      value: 0,
      setter: function(v){
        var _self = this,
          viewWraps = _self.get('viewWraps');
        $(".imgview-content-inner").removeClass("imgview-content-active");
        viewWraps[v].addClass("imgview-content-active");

        return v;
      }
    },
    // 北部的高度
    northHeight: {
      value: 30
    },
    // 左边的宽度
    eastWidth: {
      value: 250
    },
    previewListHeight: {
      value: 120,
      setter: function(v){
        $(".preview-list-wrap").height(v);
        return v;
      }
    },
    viewContentCfg: {
      value: {
        // 以下属性全部可以set来修改。
        imgSrc: "https://s.tbcdn.cn/g/fi/act/finder/img/hello.png",
        rotateTime: 300, // 旋转时间,默认300
        scaleTime: 300, // 缩放时间,默认300
        overflowSize: 100, // 边界回弹像素,默认100,实际上是取Math.min(overflowSize,imgNowWidth,imgNowHeight)
        drag: true //是否可以拖动，默认为true
      }
    },
    previewList: {
      value: $(".previewList")
    },
    // previewList渲染参数
    previewListWrap: {
      value: $("#preview-list-wrap")
    },
    listCls:{
      value: "previewList"
    },
    itemWidth: {
      value: 114
    },
    itemHeight: {
      value: 86
    },
    itemTpl: {
      value: '<li class="preview-item"></li>'
    },
    imgList: {
      value: [],
      setter: function(imgList){
        if(imgList.length){
          var _self = this,
            previewList = _self.get('previewList'),
            activeImgView = _self.get('activeImgView'),
            itemWidth = _self.get('itemWidth'),
            itemHeight = _self.get('itemHeight'),
            selected = _self.get('selected'),
            list = _self.get('list');

          if (!_self.get('hasInit')) {
            _self.__initSimpleList();
            list = _self.get('list');
          }
          list.set('items', imgList);
          list.get('el').find("ul").width(imgList.length * itemWidth)
          list.get('el').find("li").each(function(i){
            $(this).width(itemWidth - 4).height(itemHeight - 4).loadCenterImg(imgList[i].miniSrc);
          }).on('click',function(ev){
            ev.preventDefault();
            _self.set('selected', $(this).index());
          });

          var delayTimeout;
          list.get('el').find("li").hover(function(){
            if(_self.get('previewTrigger') === "hover"){
              var self = $(this);
              clearInterval(delayTimeout);
              delayTimeout = setTimeout(function(){
                var index = self.index();
                _self.set('selected', index);
              }, _self.get('hoverDelay'));
            }
          });

          // 初始化进来是读取cookie的信息
          if (!_self.get('hasInit')) {
            list.setSelected(imgList[_self.get('selected')]);
          } else {
            list.setSelected(imgList[0]);  
            _self._setImgByWrapModel(imgList,activeImgView)            
          }
        }
        return imgList;
      }
    },
    selected: {
      value: 0,
      setter: function(v){
        if (this.get('hasInit')) {
          var _self = this,
            list = _self.get('list'),
            imgList = _self.get('imgList'),
            activeImgView = _self.get('activeImgView');

          list.setSelected(imgList[v]);
          
          _self._setImgByWrapModel(imgList,activeImgView);
        }
        $.cookie("selected" + this.get('cookieReg'), v);
        return v;
      }
    },
    canMove: {
      value: true
    },
    defaultImg : {
    	value:"",
    	setter: function(v){
        	return v;
      	}
    },
    currFileNo : {
    	value:""
    },
    imgSrc0: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[0].set('imgSrc', v);
        }
        return v;
      }
    },
    imgSrc1: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[1].set('imgSrc', v);
        }
        return v;
      }
    },
    imgSrc2: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[2].set('imgSrc', v);
        }
        return v;
      }
    },
    imgSrc3: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[3].set('imgSrc', v);
        }
        return v;
      }
    },
    imgSrc4: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[4].set('imgSrc', v);
        }
        return v;
      }
    },
    imgSrc5: {
      value: "",
      setter: function(v){
        if (this.get('hasInit')) {
          this.get('viewContents')[5].set('imgSrc', v);
        }
        return v;
      }
    },
    previewTrigger:{
      value: "click"
    },
    hoverDelay: {
      value: 0
    }
  }


  return Main;

})
