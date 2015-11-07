(function () {
    'use strict';

    angular.module('cms')
        .controller('UserUserRoleCtrl', UserRoleCtrl);

    UserRoleCtrl.$inject = ['$stateParams'];

    function UserRoleCtrl ($stateParams) {
        var vm = this;
        vm.user = {};

        init();

        function init () {
            initData();
        }

        function initData () {
            vm.userId = $stateParams.userId;
            var resp = {
                user: {
                    id: 1,
                    name: '周志德',
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
                    ],
                    "departments": ["", "", ""],
                    "remark": '备注'
                }
            };
            vm.user = resp.user;
        }

    }
})();