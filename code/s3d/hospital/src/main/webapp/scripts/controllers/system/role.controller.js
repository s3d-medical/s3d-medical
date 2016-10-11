(function () {
    'use strict';

    angular.module('cms')
        .controller('RoleCtrl', RoleCtrl);

    RoleCtrl.$inject = ['$scope', '$rootScope', '$state', '$stateParams', 'dataService'];

    function RoleCtrl ($scope, $rootScope, $state, $stateParams, dataService) {
        var vm = this;
        vm.role = {};
        vm.users = [];
        vm.permissionCategories = [];

        vm.openSelectUser = openSelectUser;
        vm.changeUsers = changeUsers;
        vm.checkCategory = checkCategory;
        vm.checkPermission = checkPermission;
        vm.save = save;

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.roleId = $stateParams.roleId;
            dataService.get('action-categories')
                .then(function (resp) {
                    vm.permissionCategories = resp.permissionCategories;
                    if (vm.roleId > 0) {
                        dataService.get('/roles/' + vm.roleId)
                            .then(function (resp1) {
                                vm.role = resp1;
                                vm.users = vm.role.users;
                                _formatData();
                            });
                    }
                });
        }

        function openSelectUser () {
            $scope.$broadcast('SelectUser.Open', {targetUsers: angular.copy(vm.role.users)});
        }

        function changeUsers (users) {
            vm.users = users;
        }

        function checkCategory (event, category) {
            category.nodes && category.nodes.forEach(function (item) {
                item.checked = event.target.checked;
            });
        }

        function checkPermission (category) {
            var count = _.countBy(category.nodes, 'checked');
            category.checked = count.true == category.nodes.length;
        }

        function save () {
            vm.role.users = [];
            vm.role.permissions = [];
            vm.users && vm.users.forEach(function (item) {
                vm.role.users.push(item.id);
            });
            vm.permissionCategories && vm.permissionCategories.forEach(function (c) {
                c.nodes && c.nodes.forEach(function (n) {
                    n.checked && vm.role.permissions.push(n.id);
                })
            });
            vm.role.id = vm.role.id || null;
            delete vm.role.creator;
            if (!_validate()) {
                return;
            }
            //console.log(vm.role);
            //$state.go('main.system.roles');
            dataService.post('roles', vm.role)
                .then(function (resp) {
                    $state.go('main.system.roles');
                });
        }

        function _formatData () {
            vm.permissionCategories && vm.permissionCategories.forEach(function (c) {
                c && c.nodes && c.nodes.forEach(function (n) {
                    n.checked = vm.role.permissions && (vm.role.permissions.indexOf(n.id) > -1);
                })
            });
            vm.permissionCategories && vm.permissionCategories.forEach(function (item) {
                item.expanded = true;
                var count = _.countBy(item.nodes, 'checked');
                item.checked = count.true == item.nodes.length;
            });
        }

        function _validate () {
            var items = [];
            if (!vm.role.name) {
                items.push('角色名');
            }
            if (!vm.role.users || !vm.role.users.length) {
                items.push('指派用户');
            }
            if (!vm.role.permissions || !vm.role.permissions.length) {
                items.push('权限');
            }
            if (items.length) {
                $rootScope.$broadcast('Confirm.Open', {
                    type: 'alert',
                    title: '提醒',
                    text: items.join(',') + '不能为空。'
                });
                return false;
            }
            return true;
        }

    }
})();