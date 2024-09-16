(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsViewUser', cmsViewUser);

    cmsViewUser.$inject = [];

    function cmsViewUser () {
        return {
            restrict: 'AE',
            templateUrl: 'tplViewUser',
            replace: true,
            scope: {
                onEdit: '&',
                onResetPassword: '&'
            },
            link: function (scope, element, attrs) {

                scope.edit = edit;
                scope.resetPassword = resetPassword;
                scope.$on('ViewUser.Open', open);

                function open (event, data) {
                    scope.user = data.user;
                    element.modal({backdrop: 'static'});
                }

                function edit () {
                    scope.onEdit();
                }

                function resetPassword () {
                    scope.onResetPassword();
                }
            }
        }
    }
})();