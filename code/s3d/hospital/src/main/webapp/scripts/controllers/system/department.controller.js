(function () {
    'use strict';

    angular.module('cms')
        .controller('DepartmentCtrl', DepartmentCtrl);

    DepartmentCtrl.$inject = ['$state', '$stateParams'];

    function DepartmentCtrl ($state, $stateParams) {
        var vm = this;
        vm.department = {

        };

        vm.cancel = cancel;

        init();

        function init () {
            console.log($stateParams.departmentId);
        }

        function cancel () {
            window.history.back();
        }

    }
})();