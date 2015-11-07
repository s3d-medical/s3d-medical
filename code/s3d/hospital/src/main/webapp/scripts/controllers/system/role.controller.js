(function () {
    'use strict';

    angular.module('cms')
        .controller('RoleCtrl', RoleCtrl);

    RoleCtrl.$inject = ['$stateParams'];

    function RoleCtrl ($stateParams) {
        var vm = this;
        vm.role = {};

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.roleId = $stateParams.roleId;
            vm.role = {

            }
        }

    }
})();