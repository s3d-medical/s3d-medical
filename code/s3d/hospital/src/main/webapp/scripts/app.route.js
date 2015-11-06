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
                url: '/departments/:departmentId/list',
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
            /*.state('main.userManage', {
                url: '/user-manage',
                templateUrl: 'views/system/user-manage.html',
                controller: 'UserManageCtrl as um'
            })
            .state('main.addUser', {
                url: '/add-user',
                templateUrl: 'views/system/add-user.html',
                controller: 'AddUserCtrl as au'
            })
            .state('main.departmentManage', {
                url: '/department-manage',
                templateUrl: 'views/system/departments.jsp',
                controller: 'DepartmentManageCtrl as dm'
            })
            .state('main.roleManage', {
                url: '/role-manage',
                templateUrl: 'views/system/role-manage.html',
                controller: 'RoleManageCtrl as rm'
            })
            .state('main.addRole', {
                url: '/add-role',
                templateUrl: 'views/system/add-role.html',
                controller: 'AddRoleCtrl as ar'
            })
            .state('main.permissionManage', {
                url: '/permission-manage',
                templateUrl: 'views/system/permission-manage.html',
                controller: 'PermissionManageCtrl as pm'
            })
            .state('main.addPermission', {
                url: '/add-permission',
                templateUrl: 'views/system/add-permission.html',
                controller: 'AddPermissionCtrl as ap'
            })*/

        ;
        $urlRouterProvider.otherwise('home');
    }

})();
