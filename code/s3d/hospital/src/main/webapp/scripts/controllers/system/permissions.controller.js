(function () {
    'use strict';

    angular.module('cms')
        .controller('PermissionsCtrl', PermissionsCtrl);

    PermissionsCtrl.$inject = ['$scope'];

    function PermissionsCtrl ($scope) {
        var vm = this;
        vm.permissions = [];
        vm.permission = {};

        init();

        function init () {
            initData();
            initTree();
        }

        function initData () {
            var resp = {
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
            vm.permissionCategories = _formatData(resp.permissionCategories);
        }

        function initTree () {
            $('#permissionTree').treeview({
                data: vm.permissionCategories,
                enableLinks: false,
                onNodeSelected: _selectNode
            });
        }

        function _selectNode (event, data) {
            if (data && data.hasOwnProperty('parentId')) {
                $scope.$apply(function () {
                    var permissionId = data.id;
                    var resp = {
                        "permission": {
                            "text": '督办_默认权限',
                            "remark": '访问督办模块的基本信息',
                            "roles": ["角色1", "角色2"],
                            "departments": ["部门1", "部门2"]
                        }
                    };
                    vm.permission = resp.permission;
                })
            } else {
                $scope.$apply(function () {
                    vm.permission = {};
                })
            }
        }

        function _formatData(data) {
            for (var i in data) {
                data[i].href = '#system/permissions';
                if (data[i].nodes && data[i].nodes.length) {
                    _formatData(data[i].nodes);
                }
            }
            return data;
        }
    }
})();