(function () {
    'use strict';

    angular.module('cms')
        .controller('SearchMedicalRecordCtrl', SearchMedicalRecordCtrl);

    SearchMedicalRecordCtrl.$inject = ['$rootScope', '$scope', '$stateParams',  'dataService'];

    function SearchMedicalRecordCtrl ($rootScope, $scope, $stateParams, dataService) {
        var vm = this;
        vm.searchCases = searchCases;
        vm.addToFavorite = addToFavorite;
        vm.borrow = borrow;
        vm.loadPageData = loadPageData;

        (function () {
            $scope.cfg = vm.cfg = {
                count: 0,
                pageSize: 10,
                pageNum: 1,
                pages: [1,2,3,4,5],
                checkAll: false
            };
            initBreadcrumb();
            initData();
        })();

        function initBreadcrumb () {
            $rootScope.breadcrumbs = [
                {text: "首页", href: '#home', active: false},
                {text: "病案检索", active: true}
            ]
        }

        function initData () {
            vm.searchType = $stateParams.type;
            vm.keyword = $stateParams.keyword;
            loadPageData();
            hideLoading();
        }

        function searchCases () {

        }

        function addToFavorite (medicalRecord) {

        }

        function borrow (medicalRecord) {

        }

        function loadPageData () {
            // todo just for test
            vm.medicalRecords = [
                {
                    id: '0310442',
                    name: '患者4',
                    sex: 1,
                    age: 50,
                    sick: '某疾病',
                    inTime: '2014年12月21日',
                    outTime: '2015年01月21日',
                    inDepartment: '神经一科',
                    outDepartment: '神经二科',
                    inType: '急诊',
                    outType: '康复出院',
                    address: '某某省某某市某某县'
                },
                {
                    id: '0310442',
                    name: '患者5',
                    sex: 1,
                    age: 50,
                    sick: '某疾病',
                    inTime: '2014年12月21日',
                    outTime: '2015年01月21日',
                    inDepartment: '神经一科',
                    outDepartment: '神经二科',
                    inType: '急诊',
                    outType: '康复出院',
                    address: '某某省某某市某某县'
                },
                {
                    id: '0310442',
                    name: '患者6',
                    sex: 1,
                    age: 50,
                    sick: '某疾病',
                    inTime: '2014年12月21日',
                    outTime: '2015年01月21日',
                    inDepartment: '神经一科',
                    outDepartment: '神经二科',
                    inType: '急诊',
                    outType: '康复出院',
                    address: '某某省某某市某某县'
                }
            ];
            return;
            // todo just for test
            dataService.post('medical-records',
            {
                searchType: 'id',
                keyword: '',
                page: vm.cfg.pageNum,
                pageSize: vm.cfg.pageSize
            })
                .then(function (resp) {
                    // todo just for test
                    vm.medicalRecords = resp.result;
                    vm.cfg.count = resp.count;
                    vm.cfg.pages = [];
                    var pageCount = resp.count / vm.cfg.pageSize;
                    if (resp.count % vm.cfg.pageSize) {
                        pageCount++;
                    }
                    for (var i = 1; i <= pageCount; i++ ) {
                        vm.cfg.pages.push(i);
                    }
                    if (vm.cfg.pages.length == 0) {
                        vm.cfg.pages.push(1);
                    }
                });
        }
    }
})();