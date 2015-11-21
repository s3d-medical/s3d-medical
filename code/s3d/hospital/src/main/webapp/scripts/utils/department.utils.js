(function () {
    'use strict';

    angular.module('cms')
        .factory('departmentUtils', departmentUtils);

    departmentUtils.$inject = ['localDataService'];

    function departmentUtils (localDataService) {
        var department;
        return {
            getDepartmentById: function (departmentId) {
                department = undefined;
                var departments = localDataService.getDepartments();
                _searchDepartment(departments, departmentId);
                return department;
            }
        };

        function _searchDepartment (departments, departmentId) {
            for (var i in departments) {
                if (departments[i].id == departmentId) {
                    department = departments[i];
                }
                if (departments[i].nodes && departments[i].nodes.length) {
                    _searchDepartment(departments[i].nodes, departmentId);
                }
            }
        }
    }
})();