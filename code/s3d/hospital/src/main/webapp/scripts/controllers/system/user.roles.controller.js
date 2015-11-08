(function () {
    'use strict';

    angular.module('cms')
        .controller('UserRolesCtrl', UserRolesCtrl);

    UserRolesCtrl.$inject = ['$stateParams'];

    function UserRolesCtrl ($stateParams) {
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
                    text: '周志德',
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
                    ],
                    "departments": ["长江证券"],
                    "remark": '备注'
                }
            };
            vm.user = _formatData(resp.user);

        }

        function _formatData (user) {
            if (user && user.permissionCategories) {
                for (var i in user.permissionCategories) {
                    user.permissionCategories[i].expanded = true;
                }
            }
            return user;
        }

    }
})();