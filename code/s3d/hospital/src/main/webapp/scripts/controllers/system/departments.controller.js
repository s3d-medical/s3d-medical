﻿(function () {
    'use strict';

    angular.module('cms')
        .controller('DepartmentsCtrl', DepartmentsCtrl);

    DepartmentsCtrl.$inject = ['$scope', '$stateParams', 'dataService'];

    function DepartmentsCtrl ($scope, $stateParams, dataService) {
        var vm = this;
        vm.cfg = {
            parentId: 0,
            type: '',
            count: 0,
            pageSize: 10,
            pageNum: 1,
            pages: []
        };
        vm.selectedDepartment = {};
        vm.selectedUser = {};

        vm.changeType = changeType;
        vm.loadPageData = loadPageData;
        vm.refresh = refresh;
        vm.viewItem = viewItem;
        vm.editItem = editItem;
        vm.createItem = createItem;
        vm.deleteItems = deleteItems;
        vm.resetPassword = resetPassword;

        init();

        function init () {
            vm.cfg.parentId = $stateParams.departmentId;
            vm.cfg.type = $stateParams.type;
            loadPageData(1);
        }

        function changeType (type) {
            vm.cfg.type = type;
            loadPageData(1);
        }

        function refresh () {
            loadPageData(vm.cfg.pageNum);
        }

        function loadPageData (pageNum) {
            if (pageNum < 1) {
                vm.cfg.pageNum = 1;
            } else if (vm.cfg.pages.length > 0 && pageNum > vm.cfg.pages.length) {
                vm.cfg.pageNum = vm.cfg.pages.length
            } else {
                vm.cfg.pageNum = pageNum;
            }
            // todo just for test
            dataService.get(vm.cfg.type + vm.cfg.pageNum + '.json')
                .then(function (resp) {
                    vm[vm.cfg.type] = resp.result;
                    vm.cfg.count = resp.count;
                    vm.cfg.pages = [];
                    for (var i = 1; i <= resp.count / vm.cfg.pageSize; i++ ) {
                        vm.cfg.pages.push(i);
                    }
                });
        }

        function viewItem (id) {
            // get department or user
            if (vm.cfg.type == 'departments') {
                vm.selectedDepartment = {
                    "id": 1,
                    "name": "部门2",
                    "parent": "部门1",
                    "code": "qsqw",
                    "key": "121231",
                    "order": 32,
                    "active": true,
                    "remark": "备注"
                };
                $scope.$broadcast('ViewDepartment.Open', {department: vm.selectedDepartment});
            } else if (vm.cfg.type == 'users') {
                vm.selectedUser = {
                    "id": 1,
                    "realName": "高欢",
                    "code": "123",
                    "departmentId": 1,
                    "departmentName" : "部门2",
                    "email": "xx@xx.com",
                    "phone": "1234565",
                    "tel": "2323424",
                    "userName": "host1",
                    "languageId": 2,
                    "language": "",
                    "key": "111111111",
                    "remark": "说明"
                };
                $scope.$broadcast('ViewUser.Open', {user: vm.selectedUser});
            }

        }

        function editItem () {
            if (vm.cfg.type == 'departments') {
                $scope.$broadcast('EditDepartment.Open', {department: vm.selectedDepartment});
            } else if (vm.cfg.type == 'users') {
                $scope.$broadcast('EditUser.Open', {user: vm.selectedUser});
            }
        }

        function createItem () {
            if (vm.cfg.type == 'departments') {
                $scope.$broadcast('EditDepartment.Open', {department: {}});
            } else if (vm.cfg.type == 'users') {
                $scope.$broadcast('EditUser.Open', {user: {}});
            }
        }

        function deleteItems () {

        }

        function resetPassword () {
            $scope.$broadcast('ResetPassword.Open', {userId: vm.selectedUser.id});
        }
    }
})();