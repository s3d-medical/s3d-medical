(function () {
    'use strict';

    angular.module('cms')
        .controller('RoleManageCtrl', RoleManageCtrl);

    RoleManageCtrl.$inject = [];

    function RoleManageCtrl () {
        var vm = this;
        vm.roles = [];

        init();

        function init () {
            vm.roles = [
                {id: 1, name: '主任医师'},
                {id: 2, name: '主任医师'},
                {id: 3, name: '主任医师'},
                {id: 4, name: '主任医师'},
                {id: 5, name: '主任医师'},
                {id: 6, name: '主任医师'},
                {id: 7, name: '主任医师'},
                {id: 8, name: '主任医师'},
                {id: 9, name: '主任医师'},
                {id: 10, name: '主任医师'}
            ];
        }

    }
})();