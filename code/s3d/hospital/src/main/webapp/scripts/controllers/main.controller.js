(function () {
    'use strict';

    angular.module('cms')
        .controller('MainCtrl', MainCtrl);

    MainCtrl.$inject = ['$rootScope', '$location'];

    function MainCtrl ($rootScope, $location) {
        var vm = this;
        $rootScope.menus = [];

        vm.changeTheme = changeTheme;

        init();

        function init () {

        }

        function changeTheme (themeClass) {
            if ($rootScope.options.themeClass != themeClass) {
                $rootScope.options.themeClass = themeClass;
                localStorage.setItem('themeClass', themeClass);
            }
        }

    }
})();