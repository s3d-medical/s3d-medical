(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsEditDepartment', cmsEditDepartment);

    cmsEditDepartment.$inject = ['departmentUtils', 'dataService'];

    function cmsEditDepartment (departmentUtils, dataService) {
        return {
            restrict: 'AE',
            templateUrl: 'tplEditDepartment',
            replace: true,
            scope: {

            },
            link: function (scope, element, attrs) {

                scope.chooseParentDepartment = chooseParentDepartment;
                scope.changeParentDepartment = changeParentDepartment;
                scope.save = save;
                scope.cancel = cancel;
                scope.$on('EditDepartment.Open', open);

                function open (event, data) {
                    scope.department = data.department;
                    scope.parentDepartment = departmentUtils.getDepartmentById(scope.department.parentId);
                    element.modal({backdrop: 'static'});
                }

                function chooseParentDepartment () {
                    scope.$broadcast('SelectDepartment.Open');
                }

                function changeParentDepartment (departmentId) {
                    scope.department.parentId = departmentId;
                    scope.parentDepartment = departmentUtils.getDepartmentById(departmentId);
                }

                function save () {
                    dataService.post('departments', scope.department)
                        .then(function (resp) {
                            scope.$emit('Departments.Refresh');
                            element.modal('hide');
                        });
                }

                function cancel () {
                    element.modal('hide');
                }
            }
        }

    }
})();