(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsEditDepartment', cmsEditDepartment);

    cmsEditDepartment.$inject = [];

    function cmsEditDepartment () {
        return {
            restrict: 'AE',
            templateUrl: 'tplEditDepartment',
            replace: true,
            scope: {

            },
            link: function (scope, element, attrs) {

                scope.save = save;
                scope.cancel = cancel;
                scope.$on('EditDepartment.Open', open);

                function open (event, data) {
                    console.log(data);
                    scope.department = data.department;
                    element.modal({backdrop: 'static'});
                    element.on('hidden.bs.modal', _onClose);
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