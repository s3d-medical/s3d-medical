﻿(function () {
    'use strict';

    angular.module('cms')
        .controller('DepartmentsCtrl', DepartmentsCtrl);

    DepartmentsCtrl.$inject = ['$rootScope', '$scope', '$stateParams', 'dataService'];

    function DepartmentsCtrl ($rootScope, $scope, $stateParams, dataService) {
        var vm = this;
        vm.cfg = {
            parentId: 0,
            type: '',
            count: 0,
            pageSize: 10,
            pageNum: 1,
            pages: [1],
            checkAll: false
        };
        vm.selectedDepartment = {};
        vm.selectedUser = {};

        vm.changeType = changeType;
        vm.checkAllItems = checkAllItems;
        vm.checkItem = checkItem;
        vm.loadPageData = loadPageData;
        vm.refresh = refresh;
        vm.viewItem = viewItem;
        vm.editItem = editItem;
        vm.createItem = createItem;
        vm.deleteItems = deleteItems;
        vm.resetPassword = resetPassword;

        !function init () {
            vm.cfg.parentId = $stateParams.departmentId;
            vm.cfg.type = $stateParams.type;
            loadPageData(1);
            $scope.$on('Departments.Refresh', refresh);
        }();

        function changeType (type) {
            vm.cfg.type = type;
            vm.cfg.checkAll = false;
            loadPageData(1);
        }

        function checkAllItems (event) {
            _.map(vm[vm.cfg.type], function (item) {
                item.checked = event.target.checked;
            });
        }

        function checkItem (event) {
            event.stopPropagation();
            var count = _.countBy(vm[vm.cfg.type], function (item) {
                return item.checked;
            });
            if (count.true == vm[vm.cfg.type].length) {
                vm.cfg.checkAll = true;
            } else {
                vm.cfg.checkAll = false;
            }
        }

        function refresh () {
            loadPageData(vm.cfg.pageNum);
        }

        function loadPageData (pageNum) {
            if (pageNum < 1) {
                vm.cfg.pageNum = 1;
                return;
            } else if (vm.cfg.pages.length > 0 && pageNum > vm.cfg.pages.length) {
                vm.cfg.pageNum = vm.cfg.pages.length;
                return;
            } else {
                vm.cfg.pageNum = pageNum;
            }
            dataService.get('departments/' + vm.cfg.parentId + '/' + vm.cfg.type + '?page=' + vm.cfg.pageNum + '&pageSize=' + vm.cfg.pageSize)
                .then(function (resp) {
                    vm[vm.cfg.type] = resp.result;
                    _.map(vm[vm.cfg.type], function (item) {
                        item.checked = false;
                    });
                    vm.cfg.count = resp.count;
                    vm.cfg.pages = [];
                    var pageCount = resp.count / vm.cfg.pageSize;
                    if (resp.count % vm.cfg.pageSize) {
                        pageCount++;
                    }
                    for (var i = 1; i <= pageCount; i++ ) {
                        vm.cfg.pages.push(i);
                    }
                    if (vm.cfg.pages.length == 0) {
                        vm.cfg.pages.push(1);
                    }
                });
        }

        function viewItem (id) {
            // get department or user
            if (vm.cfg.type == 'departments') {
                dataService.get('departments/' + id)
                    .then(function (resp) {
                        vm.selectedDepartment = resp.department;
                        $scope.$broadcast('ViewDepartment.Open', {department: vm.selectedDepartment});
                    });
            } else if (vm.cfg.type == 'users') {
                dataService.get('users/' + id)
                    .then(function (resp) {
                        vm.selectedUser = resp.user;
                        $scope.$broadcast('ViewUser.Open', {user: vm.selectedUser});
                    })
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
                $scope.$broadcast('EditDepartment.Open', {department: {id: -1, parentId: $stateParams.departmentId}});
            } else if (vm.cfg.type == 'users') {
                $scope.$broadcast('EditUser.Open', {user: {id: -1, departmentId: $stateParams.departmentId}});
            }
        }

        function deleteItems () {
            var ids = [];
            for (var i in vm[vm.cfg.type]) {
                if (vm[vm.cfg.type][i].checked) {
                    ids.push(vm[vm.cfg.type][i].id);
                }
            }
            if (!ids.length) {
                $rootScope.$broadcast('Confirm.Open', {
                    type: 'alert',
                    title: '提醒',
                    text: '请至少选择一条记录。'
                });
                return;
            }
            $rootScope.$broadcast('Confirm.Open', {
                type: 'confirm',
                title: '确认',
                text: '确定要删除所选记录吗？',
                confirm: function () {
                    dataService.del(vm.cfg.type, {ids: ids})
                        .then(function (resp) {
                            refresh();
                            vm.cfg.checkAll = false;
                        })
                }
            });
        }

        function resetPassword () {
            $scope.$broadcast('ResetPassword.Open', {userId: vm.selectedUser.id});
        }
    }
})();