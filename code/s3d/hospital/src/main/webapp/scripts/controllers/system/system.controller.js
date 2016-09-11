(function () {
    'use strict';

    angular.module('cms')
        .controller('SystemCtrl', SystemCtrl);

    SystemCtrl.$inject = ['$rootScope', 'dataService', 'localDataService'];

    function SystemCtrl ($rootScope, dataService, localDataService) {
        var vm = this;

        (function () {
            initBreadcrumb();
            initData();
            $rootScope.hasMenus = true;
        })();

        function initBreadcrumb () {
            $rootScope.breadcrumbs = [
                {text: "首页", href: '#home', active: false},
                {text: "系统管理", active: true}
            ]
        }

        function initData () {
            dataService.get('departments')
                .then(function (resp) {
                    _cleanEmptyNodes(resp);
                    localDataService.setDepartments(_.cloneDeep(resp));
                    var departments = _formatData(resp);
                    $rootScope.menus = [
                        {
                            text: '组织架构与账号管理',
                            hash: '#system',
                            state: {
                                expanded: false
                            },
                            nodes: [
                                {
                                    text: '层级架构',
                                    hash: '#system',
                                    nodes: departments
                                },
                                {
                                    text: '常用群组',
                                    hash: '#system'
                                    //nodes: []
                                },
                                {
                                    text: '所有架构',
                                    hash: '#system'
                                    //nodes: []
                                }
                            ]
                        },
                        {
                            text: '权限管理',
                            hash: '#system',
                            state: {
                                expanded: false
                            },
                            nodes: [
                                {
                                    text: '导入系统权限',
                                    hash: '#system'
                                },
                                {
                                    text: '角色分配',
                                    hash: '#system/roles',
                                    nodes: [
                                        {
                                            text: '员工授权查询',
                                            hash: '#system/user-roles'
                                        },
                                        {
                                            text: '角色授权查询',
                                            hash: '#system/permissions'
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
                enableLinks: false,
                onNodeSelected: _selectNode
            });
        }

        function _selectNode (event, data) {
            if (data.hash) {
                location.href = data.hash;
            }
        }

        function _cleanEmptyNodes (data) {
            for (var i in data) {
                //data[i] && data[i].nodes && !data[i].nodes.length && (delete data[i].nodes);
                if (data[i] && data[i].nodes && data[i].nodes.length) {
                    _cleanEmptyNodes(data[i].nodes);
                } else {
                    delete data[i].nodes;
                }
            }
        }

        function _formatData (data) {
            for (var i in data) {
                data[i].hash = '#system/departments/' + data[i].id + '/departments';
                if (data[i].nodes && data[i].nodes.length) {
                    _formatData(data[i].nodes);
                }
            }
            return data;
        }
    }
})();