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
            console.log(vm.roleId);
            // todo just for test
            var resp1 = {
                role: {
                    id: 1,
                    name: '督办发布员',
                    categoryId: 1,
                    users: [
                        {id: 1, realName: '张悦'},
                        {id: 2, realName: '李阳'},
                        {id: 3, realName: '张国庆'},
                        {id: 4, realName: '王萌'},
                        {id: 5, realName: '刘德华'},
                        {id: 6, realName: '张学友'},
                        {id: 7, realName: '谢霆锋'},
                        {id: 8, realName: '吴彦祖'},
                        {id: 9, realName: '李连杰'},
                        {id: 10, realName: '吴奇隆'},
                        {id: 11, realName: '张国庆'},
                        {id: 12, realName: '王萌'},
                        {id: 13, realName: '刘德华'},
                        {id: 14, realName: '张学友'},
                        {id: 15, realName: '谢霆锋'},
                        {id: 16, realName: '吴彦祖'},
                        {id: 17, realName: '李连杰'},
                        {id: 18, realName: '吴奇隆'}
                    ],
                    permissions: [1,2,3,4,5],
                    remark: '督办',
                    creator: '管理员'
                }
            };
            // todo just for test
            var resp2 = {
                permissionCategories: [
                    {
                        id: 1,
                        text: '督办',
                        nodes: [
                            {
                                id: 1,
                                text: '督办_默认权限'
                            },
                            {
                                id: 2,
                                text: '督办_后台配置'
                            },
                            {
                                id: 3,
                                text: '权限机制_文档搜索配置'
                            },
                            {
                                id: 4,
                                text: '督办_阅读权限'
                            }
                        ]
                    },
                    {
                        id: 2,
                        text: '权限管理',
                        nodes: [
                            {
                                id: 5,
                                text: '督办_默认权限'
                            },
                            {
                                id: 6,
                                text: '督办_后台配置'
                            },
                            {
                                id: 7,
                                text: '权限机制_文档搜索配置'
                            },
                            {
                                id: 8,
                                text: '督办_阅读权限'
                            }
                        ]
                    }
                ]
            };
            // todo just for test
            if (vm.roleId > 0) {
                vm.role = resp1.role;
                vm.users = vm.role.users;
            }
            vm.permissionCategories = resp2.permissionCategories;
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
            vm.role.id = vm.role.id || -1;
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