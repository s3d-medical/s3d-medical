(function () {
    'use strict';

    angular.module('cms')
        .controller('AddUserCtrl', AddUserCtrl);

    AddUserCtrl.$inject = [];

    function AddUserCtrl () {
        var vm = this;
        vm.departments = [];
        vm.roles = [];

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.departments = [
                {id: 1, name: '门诊'},
                {id: 2, name: '住院部'},
                {id: 3, name: '精神科'},
                {id: 4, name: '内科'},
                {id: 5, name: '外科'},
                {id: 6, name: '住院部'},
                {id: 7, name: '住院部'},
                {id: 8, name: '住院部'},
                {id: 9, name: '住院部'},
                {id: 10, name: '住院部'}
            ];
            vm.roles = [
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