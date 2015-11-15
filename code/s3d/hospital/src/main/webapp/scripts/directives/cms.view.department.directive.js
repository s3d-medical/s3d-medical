(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsViewDepartment', cmsViewDepartment);

    cmsViewDepartment.$inject = [];

    function cmsViewDepartment () {
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
                    console.log(data);
                    scope.department = data.department;
                    element.modal({backdrop: 'static'});
                }

                function edit () {
                    scope.onEdit();
                }
            }
        }
    }
})();