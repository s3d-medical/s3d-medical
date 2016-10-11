(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsViewDepartment', cmsViewDepartment);

    cmsViewDepartment.$inject = ['departmentUtils'];

    function cmsViewDepartment (departmentUtils) {
        return {
            restrict: 'AE',
            templateUrl: 'tplViewDepartment',
            replace: true,
            scope: {
                onEdit: '&'
            },
            link: function (scope, element, attrs) {

                scope.edit = edit;
                scope.$on('ViewDepartment.Open', open);

                function open (event, data) {
                    scope.department = data.department;
                    scope.parentDepartment = departmentUtils.getDepartmentById(scope.department.parentId);
                    element.modal({backdrop: 'static'});
                }

                function edit () {
                    scope.onEdit();
                }
            }
        }
    }
})();