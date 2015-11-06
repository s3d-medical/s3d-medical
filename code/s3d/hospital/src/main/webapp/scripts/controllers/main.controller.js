(function () {
    'use strict';

    angular.module('cms')
        .controller('MainCtrl', MainCtrl);

    MainCtrl.$inject = ['$rootScope', '$location'];

    function MainCtrl ($rootScope, $location) {
        var vm = this;
        $rootScope.menus = [];

        init();

        function init () {
            //initData();
            //initTree();
            //$('#menu').collapse();
        }

        function initData () {
            /*$rootScope.menus = [
                {
                    href: '#home',
                    text: '首页',
                    icon: 'glyphicon glyphicon-folder-open'
                },
                {
                    href: '',
                    text: '病案借阅',
                    icon: 'glyphicon glyphicon-folder-open'
                },
                {
                    href: '',
                    text: '病案打印',
                    icon: 'glyphicon glyphicon-folder-open'
                },
                {
                    href: '',
                    text: '病案示踪',
                    icon: 'glyphicon glyphicon-folder-open'
                },
                {
                    href: '#system-manage',
                    text: '系统管理',
                    icon: 'glyphicon glyphicon-folder-open',
                    state: {
                        expanded: false
                    },
                    nodes: [
                        {
                            text: '组织架构与账号管理',
                            nodes: [
                                {
                                    text: '层级架构',
                                    nodes: []
                                },
                                {
                                    text: '常用群组',
                                    //nodes: []
                                },
                                {
                                    text: '所有架构',
                                    //nodes: []
                                }
                            ]
                        },
                        {
                            text: '权限管理',
                            //nodes: []
                        }
                    ]
                },
                {
                    href: '',
                    text: '科研管理',
                    icon: 'glyphicon glyphicon-folder-open'
                },
                {
                    href: '',
                    text: '随访管理',
                    icon: 'glyphicon glyphicon-folder-open'
                }
            ]*/
        }

        function initTree () {
            $('#menu').treeview({data: $rootScope.menus, enableLinks: true});
            /*$('#menu li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
            $('#menu li.parent_li > span').on('click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
                } else {
                    children.show('fast');
                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
                }
                e.stopPropagation();
            });*/
        }
    }
})();