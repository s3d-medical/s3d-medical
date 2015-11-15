(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsEditUser', cmsEditUser);

    cmsEditUser.$inject = [];

    function cmsEditUser () {
        return {
            restrict: 'AE',
            templateUrl: 'tplEditUser',
            replace: true,
            scope: {

            },
            link: function (scope, element, attrs) {

                scope.save = save;
                scope.cancel = cancel;
                scope.$on('EditUser.Open', open);

                function open (event, data) {
                    scope.user = data.user;
                    element.modal({backdrop: 'static'});
                }

                function save () {
                    // todo
                }

                function cancel () {
                    // todo
                }

                function _onClose (e) {
                    $rootScope.$broadcast('Modal.Close');
                }
            }
        }
    }
})();