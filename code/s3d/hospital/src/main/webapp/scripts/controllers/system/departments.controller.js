(function () {
    'use strict';

    angular.module('cms')
        .controller('DepartmentsCtrl', DepartmentsCtrl);

    DepartmentsCtrl.$inject = ['$stateParams'];

    function DepartmentsCtrl ($stateParams) {
        var vm = this;
        vm.cfg = {
            parentId: 0,
            type: '',
            count: 0,
            pageSize: 10,
            pageNum: 1,
            pages: []
        };

        vm.changeType = changeType;
        vm.loadPageData = loadPageData;

        init();

        function init () {
            vm.cfg.parentId = $stateParams.departmentId;
            vm.cfg.type = $stateParams.type;
            loadPageData();
        }

        function changeType (type) {
            vm.cfg.type = type;
            vm.cfg.pageNum = 1;
            loadPageData(vm.cfg.pageNum);
        }

        function loadPageData (pageNum) {
            console.log(pageNum);
            // todo get data from server
            var resp = {
                count: 100,
                /*result: [
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'},
                    {id: 1, order: 3, text: '1111', parent: '11111', remark: '11111'}
                ],*/
                result: [
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'},
                    {id: 1, order: 3, realName: '1111', userName: '11111', department: '11111', email: '1111', phone: '11111'}
                ]
            };
            vm[vm.cfg.type] = resp.result;
            vm.cfg.count = resp.count;
            vm.cfg.pages = [];
            for (var i = 1; i <= resp.count / vm.cfg.pageSize; i++ ) {
                vm.cfg.pages.push(i);
            }
        }
    }
})();