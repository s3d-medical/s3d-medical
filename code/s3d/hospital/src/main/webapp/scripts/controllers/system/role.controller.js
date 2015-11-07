(function () {
    'use strict';

    angular.module('cms')
        .controller('RoleCtrl', RoleCtrl);

    RoleCtrl.$inject = ['$stateParams'];

    function RoleCtrl ($stateParams) {
        var vm = this;
        vm.role = {};
        vm.permissionCategories = [];

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.roleId = $stateParams.roleId;
            var resp1 = {
                role: {
                    id: 1,
                    name: '督办发布员',
                    categoryId: 1,
                    users: [
                        {id: 1, name: '张悦'},
                        {id: 2, name: '李阳'},
                        {id: 3, name: '张国庆'},
                        {id: 4, name: '王萌'},
                        {id: 5, name: '刘德华'},
                        {id: 6, name: '张学友'},
                        {id: 7, name: '谢霆锋'},
                        {id: 8, name: '吴彦祖'},
                        {id: 9, name: '李连杰'},
                        {id: 10, name: '吴奇隆'},
                        {id: 11, name: '张国庆'},
                        {id: 12, name: '王萌'},
                        {id: 13, name: '刘德华'},
                        {id: 14, name: '张学友'},
                        {id: 15, name: '谢霆锋'},
                        {id: 16, name: '吴彦祖'},
                        {id: 17, name: '李连杰'},
                        {id: 18, name: '吴奇隆'}
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
                        name: '督办',
                        permissions: [
                            {
                                id: 1,
                                name: '督办_默认权限'
                            },
                            {
                                id: 2,
                                name: '督办_后台配置'
                            },
                            {
                                id: 3,
                                name: '权限机制_文档搜索配置'
                            },
                            {
                                id: 4,
                                name: '督办_阅读权限'
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: '权限管理',
                        permissions: [
                            {
                                id: 5,
                                name: '督办_默认权限'
                            },
                            {
                                id: 6,
                                name: '督办_后台配置'
                            },
                            {
                                id: 7,
                                name: '权限机制_文档搜索配置'
                            },
                            {
                                id: 8,
                                name: '督办_阅读权限'
                            }
                        ]
                    }
                ]
            };
            vm.role = resp1.role;
            vm.permissionCategories = resp2.permissionCategories;
            for (var i in vm.permissionCategories) {
                vm.permissionCategories[i].expanded = true;
            }
        }

    }
})();