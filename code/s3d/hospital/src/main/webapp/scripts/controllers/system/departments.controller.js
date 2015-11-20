(function () {
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

        init();

        function init () {
            vm.cfg.parentId = $stateParams.departmentId;
            vm.cfg.type = $stateParams.type;
            loadPageData(1);
        }

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
                vm.cfg.pageNum = vm.cfg.pages.length
                return;
            } else {
                vm.cfg.pageNum = pageNum;
            }
            // todo just for test
            dataService.get(vm.cfg.type + vm.cfg.pageNum + '.json')
                .then(function (resp) {
                    vm[vm.cfg.type] = resp.result;
                    _.map(vm[vm.cfg.type], function (item) {
                        item.checked = false;
                    });
                    vm.cfg.count = resp.count;
                    vm.cfg.pages = [];
                    for (var i = 1; i <= resp.count / vm.cfg.pageSize; i++ ) {
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
                dataService.get('department.json')
                    .then(function (resp) {
                        vm.selectedDepartment = resp.department;
                        $scope.$broadcast('ViewDepartment.Open', {department: vm.selectedDepartment});
                    });
            } else if (vm.cfg.type == 'users') {
                dataService.get('user.json')
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