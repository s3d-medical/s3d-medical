(function () {
    'use strict';

    angular.module('cms')
        .controller('SystemCtrl', SystemCtrl);

    SystemCtrl.$inject = ['$rootScope'];

    function SystemCtrl ($rootScope) {
        var vm = this;

        init();

        function init () {
            initBreadcrumb();
            initData();
            initTree();
        }

        function initBreadcrumb () {
            $rootScope.breadcrumbs = [
                {text: "首页", href: '#home', active: false},
                {text: "系统管理", active: true}
            ]
        }

        function initData () {
            // todo get department list from server
            var departments = [
                {id: 1, text: '长江证券1'},
                {id: 2, text: '长江证券2', nodes: [{id: 5, text: '长江证券111', nodes: [{id: 6, text: '长江证券22222222222222222'}, {id: 7, text: '长江证券222'}]}, {id: 8, text: '长江证券111'}]},
                {id: 3, text: '长江证券3'},
                {id: 4, text: '长江证券4', nodes: [{id: 6, text: '长江证券555'}, {id: 7, text: '666'}]}
            ];
            departments = _formatData(departments);
            $rootScope.menus = [
                {
                    text: '组织架构与账号管理',
                    href: '#system',
                    state: {
                        expanded: false
                    },
                    nodes: [
                        {
                            text: '层级架构',
                            href: '#system',
                            nodes: departments
                        },
                        {
                            text: '常用群组',
                            href: '#system'
                            //nodes: []
                        },
                        {
                            text: '所有架构',
                            href: '#system'
                            //nodes: []
                        }
                    ]
                },
                {
                    text: '权限管理',
                    href: '#system',
                    state: {
                        expanded: false
                    },
                    nodes: [
                        {
                            text: '导入系统权限',
                            href: '#system'
                        },
                        {
                            text: '角色分配',
                            href: '#system/roles',
                            nodes: [
                                {
                                    text: '员工授权查询',
                                    href: '#system/user-roles'
                                },
                                {
                                    text: '角色授权查询',
                                    href: '#system/permissions'
                                }
                            ]
                        }
                    ]
                }
            ];
        }

        function initTree () {
            $('#menu').treeview({
                data: $rootScope.menus,
                enableLinks: true,
                onNodeSelected: _selectNode
            });
        }

        function _selectNode (event, data) {
            //console.log(data);
        }

        function _formatData(data) {
            for (var i in data) {
                data[i].href = '#system/departments/' + data[i].id + '/departments';
                if (data[i].nodes && data[i].nodes.length) {
                    _formatData(data[i].nodes);
                }
            }
            return data;
        }
    }
})();