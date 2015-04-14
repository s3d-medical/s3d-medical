/**
 * @fileOverview 修改过的适应组织架构选择的树列表选择器
 * @ignore
 */

define('bui/extensions/treelistex',['bui/tree/treelist'],function (require) {
	'use strict';
  var TreeList = require('bui/tree/treelist');
  
  var TreeListEx = TreeList.extend({
	  _showChildren : function(node){
		if(!node || !node.children){
			return;
		}
		var _self = this,
		index = _self.indexOfItem(node),
		length = node.children.length,
		subNode,
		i = length - 1,
		elements = [];
		for (i = length - 1; i >= 0; i--) {
			subNode = node.children[i];
			subNode.checked = false;
			var exceptNodeValue = _self.get('exceptNodeValue')
			if(exceptNodeValue!=null && exceptNodeValue.length &&  $.inArray( subNode.id, exceptNodeValue ) > -1){
				subNode.checkable = false;
			}
			
			if(!_self.getItem(subNode)){
				if(_self.get('expandAnimate')){
					el = _self._addNodeAt(subNode,index + 1);
					el.hide();
					el.slideDown();
				}else{
					_self.addItemAt(subNode,index + 1);
				} 
			}
		};
	  },
	  setNodeChecked : function(node,checked,deep){
		deep = deep == null ? true : deep;
		if(!node){
			return;
		}
		var _self = this,parent,multipleCheck = _self.get('multipleCheck'),element;
		if(BUI.isString(node)){
			node = this.findNode(node);
		}
		if(!node){
			return;
		}
		parent = node.parent;
		if(!_self.isCheckable(node)){
			return;
		}
		if(_self.isChecked(node) !== checked || _self.hasStatus(node,'checked') !== checked){
			element =  _self.findElement(node);
			if(element){
				if(!multipleCheck){
					var checkednodes = _self.getCheckedNodes();
					BUI.each(checkednodes,function(otherNode){
						if(otherNode!=node){
							_self.setNodeChecked(otherNode,false);
						}						
					});
				}
				_self.setItemStatus(node,'checked',checked,element);
	        }else if(!_self.isItemDisabled(node)){
	        	_self.setStatusValue(node,'checked',checked);
	        }
			_self.fire('checkedchange',{node : node,element: element,checked : checked});
			
		}
		if(!node.leaf && deep && _self.get('autoSelectChildren')){
			BUI.each(node.children,function(subNode,index){
				if(multipleCheck || !checked || (!multipleCheck && index == 0)){
					_self.setNodeChecked(subNode,checked,deep);
				}
			});
		}
	}
  },{
	  ATTRS : {
		  autoSelectChildren : {
	        value : false
	      },
	      exceptNodeValue : {
	    	  value : []
	      }
	  }
  },{
	 xclass : 'tree-listex'
  });
  return TreeListEx;
});