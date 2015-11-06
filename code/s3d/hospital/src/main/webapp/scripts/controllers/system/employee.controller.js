(function () {
    'use strict';

    angular.module('cms')
        .controller('EmployeeCtrl', EmployeeCtrl);

    EmployeeCtrl.$inject = ['$state', '$stateParams'];

    function EmployeeCtrl ($state, $stateParams) {
        var vm = this;
        vm.employee = {

        };

        vm.cancel = cancel;

        init();

        function init () {
            console.log($stateParams.employeeId);
        }

        function cancel () {
            window.history.back();
        }

    }
})();