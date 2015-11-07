(function () {
    'use strict';

    angular.module('cms')
        .controller('RolesCtrl', RolesCtrl);

    RolesCtrl.$inject = ['$stateParams'];

    function RolesCtrl ($stateParams) {
        var vm = this;
        vm.cfg = {
            count: 0,
            pageSize: 10,
            pageNum: 1,
            pages: []
        };
        vm.roles = [];

        vm.loadPageData = loadPageData;

        init();

        function init () {
            loadPageData();
        }

        function loadPageData (pageNum) {
            console.log(pageNum);
            // todo get data from server
            var resp = {
                count: 100,
                result: [
                    {id: 1, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                    {id: 2, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                    {id: 3, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                    {id: 4, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                    {id: 5, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                    {id: 6, name: '1111', category: '11111', creator: '11111', remark: '1111'},
                ]
            };
            vm.roles = resp.result;
            vm.cfg.count = resp.count;
            vm.cfg.pages = [];
            for (var i = 1; i <= resp.count / vm.cfg.pageSize; i++ ) {
                vm.cfg.pages.push(i);
            }
        }
    }
})();