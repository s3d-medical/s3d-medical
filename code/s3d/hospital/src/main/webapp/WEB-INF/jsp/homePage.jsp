<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="cms" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="cms" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="cms" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="cms" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>病案管理系统</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="vendor/html5-boilerplate/dist/css/normalize.css">
    <link rel="stylesheet" href="vendor/html5-boilerplate/dist/css/main.css">
    <link rel="stylesheet" href="vendor/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/css/common.css">
    <link rel="stylesheet" href="styles/css/style.css">
    <script src="vendor/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<%--<body ng-controller="RootCtrl as rt" ng-class="{'style-blue': options.style == 'blue', 'style-green': options.style == 'green', 'bg': options.currentState == 'home'}">--%>
<body ng-controller="RootCtrl as rt" ng-class="[options.themeClass, options.currentState == 'home' ? 'bg' : '']">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div ui-view class="container"></div>

<div id="mask" class="mask"></div>

<cms-confirm></cms-confirm>
<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->
<script type="text/javascript">
    !function(a,b){"object"==typeof exports?module.exports=b():"function"==typeof define&&define.amd?define(b):a.Spinner=b()}(this,function(){"use strict";function a(a,b){var c,d=document.createElement(a||"div");for(c in b)d[c]=b[c];return d}function b(a){for(var b=1,c=arguments.length;c>b;b++)a.appendChild(arguments[b]);return a}function c(a,b,c,d){var e=["opacity",b,~~(100*a),c,d].join("-"),f=.01+c/d*100,g=Math.max(1-(1-a)/b*(100-f),a),h=j.substring(0,j.indexOf("Animation")).toLowerCase(),i=h&&"-"+h+"-"||"";return m[e]||(k.insertRule("@"+i+"keyframes "+e+"{0%{opacity:"+g+"}"+f+"%{opacity:"+a+"}"+(f+.01)+"%{opacity:1}"+(f+b)%100+"%{opacity:"+a+"}100%{opacity:"+g+"}}",k.cssRules.length),m[e]=1),e}function d(a,b){var c,d,e=a.style;if(b=b.charAt(0).toUpperCase()+b.slice(1),void 0!==e[b])return b;for(d=0;d<l.length;d++)if(c=l[d]+b,void 0!==e[c])return c}function e(a,b){for(var c in b)a.style[d(a,c)||c]=b[c];return a}function f(a){for(var b=1;b<arguments.length;b++){var c=arguments[b];for(var d in c)void 0===a[d]&&(a[d]=c[d])}return a}function g(a,b){return"string"==typeof a?a:a[b%a.length]}function h(a){this.opts=f(a||{},h.defaults,n)}function i(){function c(b,c){return a("<"+b+' xmlns="urn:schemas-microsoft.com:vml" class="spin-vml">',c)}k.addRule(".spin-vml","behavior:url(#default#VML)"),h.prototype.lines=function(a,d){function f(){return e(c("group",{coordsize:k+" "+k,coordorigin:-j+" "+-j}),{width:k,height:k})}function h(a,h,i){b(m,b(e(f(),{rotation:360/d.lines*a+"deg",left:~~h}),b(e(c("roundrect",{arcsize:d.corners}),{width:j,height:d.scale*d.width,left:d.scale*d.radius,top:-d.scale*d.width>>1,filter:i}),c("fill",{color:g(d.color,a),opacity:d.opacity}),c("stroke",{opacity:0}))))}var i,j=d.scale*(d.length+d.width),k=2*d.scale*j,l=-(d.width+d.length)*d.scale*2+"px",m=e(f(),{position:"absolute",top:l,left:l});if(d.shadow)for(i=1;i<=d.lines;i++)h(i,-2,"progid:DXImageTransform.Microsoft.Blur(pixelradius=2,makeshadow=1,shadowopacity=.3)");for(i=1;i<=d.lines;i++)h(i);return b(a,m)},h.prototype.opacity=function(a,b,c,d){var e=a.firstChild;d=d.shadow&&d.lines||0,e&&b+d<e.childNodes.length&&(e=e.childNodes[b+d],e=e&&e.firstChild,e=e&&e.firstChild,e&&(e.opacity=c))}}var j,k,l=["webkit","Moz","ms","O"],m={},n={lines:12,length:7,width:5,radius:10,scale:1,corners:1,color:"#000",opacity:.25,rotate:0,direction:1,speed:1,trail:100,fps:20,zIndex:2e9,className:"spinner",top:"50%",left:"50%",shadow:!1,hwaccel:!1,position:"absolute"};if(h.defaults={},f(h.prototype,{spin:function(b){this.stop();var c=this,d=c.opts,f=c.el=a(null,{className:d.className});if(e(f,{position:d.position,width:0,zIndex:d.zIndex,left:d.left,top:d.top}),b&&b.insertBefore(f,b.firstChild||null),f.setAttribute("role","progressbar"),c.lines(f,c.opts),!j){var g,h=0,i=(d.lines-1)*(1-d.direction)/2,k=d.fps,l=k/d.speed,m=(1-d.opacity)/(l*d.trail/100),n=l/d.lines;!function o(){h++;for(var a=0;a<d.lines;a++)g=Math.max(1-(h+(d.lines-a)*n)%l*m,d.opacity),c.opacity(f,a*d.direction+i,g,d);c.timeout=c.el&&setTimeout(o,~~(1e3/k))}()}return c},stop:function(){var a=this.el;return a&&(clearTimeout(this.timeout),a.parentNode&&a.parentNode.removeChild(a),this.el=void 0),this},lines:function(d,f){function h(b,c){return e(a(),{position:"absolute",width:f.scale*(f.length+f.width)+"px",height:f.scale*f.width+"px",background:b,boxShadow:c,transformOrigin:"left",transform:"rotate("+~~(360/f.lines*k+f.rotate)+"deg) translate("+f.scale*f.radius+"px,0)",borderRadius:(f.corners*f.scale*f.width>>1)+"px"})}for(var i,k=0,l=(f.lines-1)*(1-f.direction)/2;k<f.lines;k++)i=e(a(),{position:"absolute",top:1+~(f.scale*f.width/2)+"px",transform:f.hwaccel?"translate3d(0,0,0)":"",opacity:f.opacity,animation:j&&c(f.opacity,f.trail,l+k*f.direction,f.lines)+" "+1/f.speed+"s linear infinite"}),f.shadow&&b(i,e(h("#000","0 0 4px #000"),{top:"2px"})),b(d,b(i,h(g(f.color,k),"0 0 1px rgba(0,0,0,.1)")));return d},opacity:function(a,b,c){b<a.childNodes.length&&(a.childNodes[b].style.opacity=c)}}),"undefined"!=typeof document){k=function(){var c=a("style",{type:"text/css"});return b(document.getElementsByTagName("head")[0],c),c.sheet||c.styleSheet}();var o=e(a("group"),{behavior:"url(#default#VML)"});!d(o,"transform")&&o.adj?i():j=d(o,"animation")}return h});
    var spinnerConfig = {
        lines: 11,
        length: 6,
        width: 3,
        radius: 8,
        corners: 1,
        rotate: 0,
        color: '#666',
        speed: 0.9,
        trail: 60,
        shadow: false,
        hwaccel: false,
        className: 'spinner',
        top: '50%',
        left: '50%'
    };
    var fullScreenSpinner, mask = document.getElementById('mask');
    function showLoading () {
        if (fullScreenSpinner) {
            mask.style.backgroundColor = '#000';
            mask.style.opacity = 0.2;
        } else {
            fullScreenSpinner = new Spinner(spinnerConfig);
            mask.style.backgroundColor = '#fff';
            mask.style.opacity = 1;
        }
        mask.style.display = 'block';
        fullScreenSpinner.spin(mask);
    }
    function hideLoading () {
        mask.style.display = 'none';
        fullScreenSpinner.stop();
    }
    showLoading();
    // todo just for test
    hideLoading();
</script>

<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="vendor/angular/angular.min.js"></script>
<script src="vendor/lodash/lodash.min.js"></script>
<script src="vendor/ui-router/release/angular-ui-router.min.js"></script>
<script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="vendor/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>

<script src="scripts/app.js"></script>
<script src="scripts/app.route.js"></script>

<script src="scripts/controllers/root.controller.js"></script>
<script src="scripts/controllers/home.controller.js"></script>
<script src="scripts/controllers/main.controller.js"></script>
<script src="scripts/controllers/system/system.controller.js"></script>
<script src="scripts/controllers/system/departments.controller.js"></script>
<script src="scripts/controllers/system/roles.controller.js"></script>
<script src="scripts/controllers/system/role.controller.js"></script>
<script src="scripts/controllers/system/user.roles.controller.js"></script>
<script src="scripts/controllers/system/permissions.controller.js"></script>

<script src="scripts/directives/cms.view.department.directive.js"></script>
<script src="scripts/directives/cms.edit.department.directive.js"></script>
<script src="scripts/directives/cms.view.user.directive.js"></script>
<script src="scripts/directives/cms.edit.user.directive.js"></script>
<script src="scripts/directives/cms.reset.password.directive.js"></script>
<script src="scripts/directives/cms.select.department.directive.js"></script>
<script src="scripts/directives/cms.select.user.directive.js"></script>
<script src="scripts/directives/cms.confirm.directive.js"></script>

<script src="scripts/utils/constants.js"></script>
<script src="scripts/utils/department.utils.js"></script>

<script src="scripts/services/data.service.js"></script>
<script src="scripts/services/local.data.service.js"></script>

<%@ include file="views/home.jsp"%>
<%@ include file="views/main.jsp"%>
<%@ include file="views/system/system.jsp"%>
<%@ include file="views/system/departments.jsp"%>
<%@ include file="views/system/roles.jsp"%>
<%@ include file="views/system/role.jsp"%>
<%@ include file="views/system/user-roles.jsp"%>
<%@ include file="views/system/permissions.jsp"%>

<%@ include file="views/templates/tpl-view-department.jsp"%>
<%@ include file="views/templates/tpl-edit-department.jsp"%>
<%@ include file="views/templates/tpl-view-user.jsp"%>
<%@ include file="views/templates/tpl-edit-user.jsp"%>
<%@ include file="views/templates/tpl-reset-password.jsp"%>
<%@ include file="views/templates/tpl-select-department.jsp"%>
<%@ include file="views/templates/tpl-select-user.jsp"%>
<%@ include file="views/templates/tpl-confirm.jsp"%>

</body>
</html>
