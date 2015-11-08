(function () {
    'use strict';

    angular.module('cms')
        .controller('AddRoleCtrl', AddRoleCtrl);

    AddRoleCtrl.$inject = [];

    function AddRoleCtrl () {
        var vm = this;
        vm.permissions = [];

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.permissions = [
                {id: 1, name: '借阅病案'},
                {id: 2, name: '借阅病案'},
                {id: 3, name: '借阅病案'},
                {id: 4, name: '借阅病案'},
                {id: 5, name: '借阅病案'},
                {id: 6, name: '借阅病案'},
                {id: 7, name: '借阅病案'},
                {id: 8, name: '借阅病案'},
                {id: 9, name: '借阅病案'},
                {id: 10, name: '借阅病案'},
                {id: 11, name: '借阅病案'},
                {id: 12, name: '借阅病案'},
                {id: 13, name: '借阅病案'},
                {id: 14, name: '借阅病案'},
                {id: 15, name: '借阅病案'},
                {id: 16, name: '借阅病案'},
                {id: 17, name: '借阅病案'}
            ];
        }

    }
})();