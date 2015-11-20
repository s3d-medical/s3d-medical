(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsEditUser', cmsEditUser);

    cmsEditUser.$inject = ['$timeout', 'departmentUtils'];

    function cmsEditUser ($timeout, departmentUtils) {
        return {
            restrict: 'AE',
            templateUrl: 'tplEditUser',
            replace: true,
            scope: {

            },
            link: function (scope, element, attrs) {

                scope.chooseParentDepartment = chooseParentDepartment;
                scope.changeParentDepartment = changeParentDepartment;
                scope.save = save;
                scope.cancel = cancel;
                scope.$on('EditUser.Open', open);

                function open (event, data) {
                    scope.user = data.user;
                    scope.parentDepartment = departmentUtils.getDepartmentById(scope.user.departmentId);
                    element.modal({backdrop: 'static'});
                }

                function chooseParentDepartment () {
                    scope.$broadcast('SelectDepartment.Open');
                }

                function changeParentDepartment (departmentId) {
                    scope.user.departmentId = departmentId;
                    scope.parentDepartment = departmentUtils.getDepartmentById(departmentId);
                }

                function save () {
                    // todo
                    element.modal('hide');
                }

                function cancel () {
                    // todo
                    element.modal('hide');
                }

                /*function _onClose (e) {
                    $rootScope.$broadcast('Modal.Close');
                }*/
            }
        }
    }
})();