(function () {
    'use strict';

    angular.module('cms')
        .config(route);

    route.$inject = ['$stateProvider', '$urlRouterProvider'];

    function route ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl: 'viewHome',
                controller: 'HomeCtrl as hm'
            })
            .state('main', {
                url: '',
                abstract: true,
                templateUrl: 'viewMain',
                controller: 'MainCtrl as mc'
            })
            .state('main.system', {
                url: '/system',
                templateUrl: 'viewSystem',
                controller: 'SystemCtrl as sm'
            })
            .state('main.system.departments', {
                url: '/departments/:departmentId/:type',
                templateUrl: 'viewDepartments',
                controller: 'DepartmentsCtrl as ds'
            })
            .state('main.system.department', {
                url: '/departments/:departmentId',
                templateUrl: 'viewDepartment',
                controller: 'DepartmentCtrl as dc'
            })
            .state('main.system.employee', {
                url: '/employees/:employeeId',
                templateUrl: 'viewEmployee',
                controller: 'EmployeeCtrl as ec'
            })
            .state('main.system.roles', {
                url: '/roles',
                templateUrl: 'viewRoles',
                controller: 'RolesCtrl as rs'
            })
            .state('main.system.role', {
                url: '/roles/:roleId',
                templateUrl: 'viewRole',
                controller: 'RoleCtrl as rc'
            })
            .state('main.system.userRoles', {
                url: '/user-roles',
                templateUrl: 'viewUserRoles',
                controller: 'UserRolesCtrl as ur'
            })
            .state('main.system.permissions', {
                url: '/permissions',
                templateUrl: 'viewPermissions',
                controller: 'PermissionsCtrl as ps'
            })

        ;
        $urlRouterProvider.otherwise('home');
    }

})();
