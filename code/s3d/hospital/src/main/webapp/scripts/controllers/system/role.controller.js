(function () {
    'use strict';

    angular.module('cms')
        .controller('RoleCtrl', RoleCtrl);

    RoleCtrl.$inject = ['$scope', '$stateParams'];

    function RoleCtrl ($scope, $stateParams) {
        var vm = this;
        vm.role = {};
        vm.permissionCategories = [];

        vm.openSelectUser = openSelectUser;
        vm.changeUsers = changeUsers;

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.roleId = $stateParams.roleId;
            console.log(vm.roleId);
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
            if (vm.roleId > 0) {
                vm.role = resp1.role;
                vm.permissionCategories = resp2.permissionCategories;
                for (var i in vm.permissionCategories) {
                    vm.permissionCategories[i].expanded = true;
                }
            }
        }

        function openSelectUser () {
            $scope.$broadcast('SelectUser.Open', {targetUsers: angular.copy(vm.role.users)});
        }

        function changeUsers (users) {
            vm.role.users = users;
        }

    }
})();