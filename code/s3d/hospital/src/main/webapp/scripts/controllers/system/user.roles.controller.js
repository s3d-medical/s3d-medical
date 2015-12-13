(function () {
    'use strict';

    angular.module('cms')
        .controller('UserRolesCtrl', UserRolesCtrl);

    UserRolesCtrl.$inject = ['$rootScope', '$scope', '$stateParams', 'dataService'];

    function UserRolesCtrl ($rootScope, $scope, $stateParams, dataService) {
        var vm = this;
        vm.user = {};

        vm.search = search;
        vm.getUserInfo = getUserInfo;

        !function init () {
            initData();
        }();

        function initData () {

        }

        function search () {
            if (_.trim(vm.user.name)) {
                dataService.post('users/search', {realName: _.trim(vm.user.name)})
                    .then(function (resp) {
                        if (resp.result && resp.result.length > 1) {
                            vm.users = resp.result;
                            $scope.$broadcast('SearchUsers.Open');
                        } else if (resp.result && resp.result.length == 1) {
                            getUserInfo(resp.result[0].id);
                        }
                    })
            } else {
                $rootScope.$broadcast('Confirm.Open', {
                    type: 'alert',
                    title: '警告',
                    text: '请输入用户名'
                })
            }

        }

        function getUserInfo (userId) {
            // todo just for test
            var resp = {
                user: {
                    id: 1,
                    name: '周志德',
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
            /*dataService.get('users/' + userId + '/roles')
                .then(function (resp) {
                    vm.user = _formatData(resp.user);
                })*/
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