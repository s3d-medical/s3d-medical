;(function(){

  //from seajs
  function getScriptAbsoluteSrc(node) {
    return node.hasAttribute ? // non-IE6/7
        node.src :
      // see http://msdn.microsoft.com/en-us/library/ms536429(VS.85).aspx
        node.getAttribute("src", 4);
  }

  //根据当前config.js的引用路径来获取myloan的use路径
  var scripts = document.getElementsByTagName('script'),
    src = getScriptAbsoluteSrc(scripts[scripts.length - 1]),
    loaderPath = src.substring(0, src.lastIndexOf('/'));

  //项目路径的配置
  seajs.config({
    paths: {
      'js': loaderPath
    }
  });




  (function(){
    $.extend({
      stringify  : function stringify(obj) {
        if ("JSON" in window) {
          return JSON.stringify(obj);
        }
        var t = typeof (obj);
        if (t != "object" || obj === null) {
          // simple data type
          if (t == "string") obj = '"' + obj + '"';
          return String(obj);
        } else {
          // recurse array or object
          var n, v, json = [], arr = (obj && obj.constructor == Array);
          for (n in obj) {
            v = obj[n];
            t = typeof(v);
            if (obj.hasOwnProperty(n)) {
              if (t == "string") {
                v = '"' + v + '"';
              } else if (t == "object" && v !== null){
                v = $.stringify(v);
              }
              json.push((arr ? "" : '"' + n + '":') + String(v));
            }
          }
          return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
        }
      }
    });
    $.fn.loadCenterImg = function(src){
      var self = jQuery(this),
        w = self.width(),
        h = self.height(),
        targetImg = new Image(),
        imgObj = jQuery("<img>");

      targetImg.onload = function(){
        var tw = targetImg.width,
          th = targetImg.height;
        if((tw/th)>(w/h)){
          var ih = w/tw*th;
          imgObj.css({
            "width":w,
            "height":ih,
            "marginTop":(h-ih)/2
          });
        }else{
          var iw = h/th*tw;
          imgObj.css({
            "width":iw,
            "height":h,
            "marginLeft":(w-iw)/2
          });
        }
        imgObj[0].src = src;
        self.html(imgObj);
      }
      targetImg.src = src;
      return targetImg;
    }
  })(jQuery)



})();
