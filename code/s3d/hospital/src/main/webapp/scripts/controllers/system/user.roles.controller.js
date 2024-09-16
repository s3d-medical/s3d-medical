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
            dataService.get('users/' + userId + '/actions')
                .then(function (resp) {
                    vm.user = _formatData(resp.user);
                })
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