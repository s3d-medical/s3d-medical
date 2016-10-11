(function () {
    'use strict';

    angular.module('cms')
        .controller('PermissionsCtrl', PermissionsCtrl);

    PermissionsCtrl.$inject = ['$scope', 'dataService'];

    function PermissionsCtrl ($scope, dataService) {
        var vm = this;
        vm.permissions = [];
        vm.permission = {};

        init();

        function init () {
            initData();
        }

        function initData () {
            dataService.get('action-categories')
                .then(function (resp) {
                    vm.permissionCategories = _formatData(resp.permissionCategories);
                    initTree();
                });

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
                    dataService.get('actions/' + permissionId)
                        .then(function (resp) {
                            vm.permission = resp.permission;
                        });
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