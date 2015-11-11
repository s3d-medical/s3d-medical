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
                    scope.department = data.department;
                    element.modal({backdrop: 'static'});
                }

                function save () {
                    // todo
                }

                function cancel () {
                    // todo
                }
            }
        }

    }
})();