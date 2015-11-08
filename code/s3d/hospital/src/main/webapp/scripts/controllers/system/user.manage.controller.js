(function () {
    'use strict';

    angular.module('cms')
        .controller('UserManageCtrl', UserManageCtrl);

    UserManageCtrl.$inject = [];

    function UserManageCtrl () {
        var vm = this;
        vm.users = [];

        init();

        function init () {
            vm.users = [
                {id: 1, name: '李文雅'},
                {id: 2, name: '李维哲'},
                {id: 3, name: '李中山'},
                {id: 4, name: '李晨'},
                {id: 5, name: '刘永旭'},
                {id: 6, name: '刘子璇'},
                {id: 7, name: '刘国贤'},
                {id: 8, name: '刘婷婷'},
                {id: 9, name: '刘益冉'},
                {id: 10, name: '李毛儿'}
            ];
        }

    }
})();