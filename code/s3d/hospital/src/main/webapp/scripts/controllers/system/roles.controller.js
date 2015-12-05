(function () {
    'use strict';

    angular.module('cms')
        .controller('RolesCtrl', RolesCtrl);

    RolesCtrl.$inject = ['$rootScope', 'dataService'];

    function RolesCtrl ($rootScope, dataService) {
        var vm = this;
        vm.cfg = {
            count: 0,
            pageSize: 10,
            pageNum: 1,
            pages: [],
            checkAll: false
        };
        vm.roles = [];

        vm.refresh = refresh;
        vm.loadPageData = loadPageData;
        vm.checkAllItems = checkAllItems;
        vm.checkItem = checkItem;
        vm.deleteItems = deleteItems;

        init();

        function init () {
            loadPageData(1);
        }

        function refresh () {
            loadPageData(vm.cfg.pageNum);
        }

        function loadPageData (pageNum) {
            if (pageNum < 1) {
                vm.cfg.pageNum = 1;
                return;
            } else if (vm.cfg.pages.length > 0 && pageNum > vm.cfg.pages.length) {
                vm.cfg.pageNum = vm.cfg.pages.length;
                return;
            } else {
                vm.cfg.pageNum = pageNum;
            }
            dataService.get('roles' + '?page=' + vm.cfg.pageNum + '&pageSize=' + vm.cfg.pageSize)
                .then(function (resp) {
                    vm.roles = resp.result;
                    vm.cfg.count = resp.count;
                    vm.cfg.pages = [];
                    var pageCount = resp.count / vm.cfg.pageSize;
                    if (resp.count % vm.cfg.pageSize) {
                        pageCount++;
                    }
                    for (var i = 1; i <= pageCount; i++ ) {
                        vm.cfg.pages.push(i);
                    }
                });
        }

        function checkAllItems (event) {
            _.map(vm.roles, function (item) {
                item.checked = event.target.checked;
            });
        }

        function checkItem (event) {
            event.stopPropagation();
            var count = _.countBy(vm.roles, function (item) {
                return item.checked;
            });
            if (count.true == vm.roles.length) {
                vm.cfg.checkAll = true;
            } else {
                vm.cfg.checkAll = false;
            }
        }

        function deleteItems () {
            var ids = [];
            for (var i in vm.roles) {
                if (vm.roles[i].checked) {
                    ids.push(vm.roles[i].id);
                }
            }
            if (!ids.length) {
                $rootScope.$broadcast('Confirm.Open', {
                    type: 'alert',
                    title: '提醒',
                    text: '请至少选择一条记录。'
                });
                return;
            }
            $rootScope.$broadcast('Confirm.Open', {
                type: 'confirm',
                title: '确认',
                text: '确定要删除所选记录吗？',
                confirm: function () {
                    dataService.del('roles', {ids: ids})
                        .then(function (resp) {
                            refresh();
                            vm.cfg.checkAll = false;
                        })
                }
            });
        }
    }
})();