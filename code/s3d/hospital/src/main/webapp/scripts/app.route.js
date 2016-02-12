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
            // system manage
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
            .state('main.system.roles', {
                url: '/roles',
                templateUrl: 'viewRoles',
                controller: 'RolesCtrl as rs'
            })
            .state('main.system.role', {
                url: '/role',
                templateUrl: 'viewRole',
                controller: 'RoleCtrl as rc',
                params: {
                    roleId: -1
                }
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
            // search cases
            .state('main.medicalRecords', {
                url: '/medical-records',
                templateUrl: 'viewSearchMedicalRecord',
                controller: 'SearchMedicalRecordCtrl as smr',
                params: {
                    type: null,
                    keyword: null
                }
            })

        ;
        $urlRouterProvider.otherwise('home');
    }

})();
