(function () {
    'use strict';

    angular.module('cms')
        .controller('SystemCtrl', SystemCtrl);

    SystemCtrl.$inject = ['$rootScope', 'dataService'];

    function SystemCtrl ($rootScope, dataService) {
        var vm = this;

        init();

        function init () {
            initBreadcrumb();
            initData();
        }

        function initBreadcrumb () {
            $rootScope.breadcrumbs = [
                {text: "首页", href: '#home', active: false},
                {text: "系统管理", active: true}
            ]
        }

        function initData () {
            dataService.get('departments.json')
                .then(function (resp) {
                    var departments = _formatData(resp.departments);
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
                    initTree();
                });
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