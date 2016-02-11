(function () {
    'use strict';

    angular.module('cms')
        .controller('SearchCasesCtrl', SearchCasesCtrl);

    SearchCasesCtrl.$inject = ['$rootScope', '$scope'];

    function SearchCasesCtrl ($rootScope, $scope) {
        var vm = this;
        vm.searchCases = searchCases;

        (function () {
            $scope.cfg = vm.cfg = {
                count: 0,
                pageSize: 10,
                pageNum: 1,
                pages: [1],
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
            vm.searchType = 'caseNum';
            vm.cases = [
                {
                    caseNo: '0310442',
                    name: '患者1',
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
                    caseNo: '0310442',
                    name: '患者1',
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
                    caseNo: '0310442',
                    name: '患者1',
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
            hideLoading();
        }

        function searchCases () {

        }
    }
})();