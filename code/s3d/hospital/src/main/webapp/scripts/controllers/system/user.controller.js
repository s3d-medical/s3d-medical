(function () {
    'use strict';

    angular.module('cms')
        .controller('UserCtrl', UserCtrl);

    UserCtrl.$inject = ['$state', '$stateParams'];

    function UserCtrl ($state, $stateParams) {
        var vm = this;
        vm.user = {

        };

        vm.cancel = cancel;

        init();

        function init () {
            console.log($stateParams.userId);
        }

        function cancel () {
            window.history.back();
        }

    }
})();