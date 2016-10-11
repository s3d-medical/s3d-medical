(function () {
    'use strict';

    angular.module('cms')
        .controller('RootCtrl', RootCtrl);

    RootCtrl.$inject = ['$rootScope'];

    function RootCtrl ($rootScope) {

        init();

        function init () {
            $rootScope.options.themeClass = localStorage.getItem('themeClass') || 'style-blue';
        }
    }
})();