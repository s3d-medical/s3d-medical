(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsResetPassword', cmsResetPassword);

    cmsResetPassword.$inject = [];

    function cmsResetPassword () {
        return {
            restrict: 'EA',
            replace: true,
            templateUrl: 'tplResetPassword',
            scope: {

            },
            link: function (scope, element, attrs) {
                scope.$on('ResetPassword.Open', open);

                function open (event, data) {
                    var userId = data.userId;
                    element.modal({backdrop: 'static'});
                }
            }
        }
    }
})();