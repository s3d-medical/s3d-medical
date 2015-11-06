(function () {
    'use strict';

    angular.module('cms')
        .controller('HomeCtrl', HomeCtrl);

    HomeCtrl.$inject = [];

    function HomeCtrl () {
        var vm = this;

        vm.searchType = 'caseNum';
        vm.buttons = {
            group1: [
                {key: 'caseNum', value: '病案号'},
                {key: 'sick', value: '疾病名称'},
                {key: 'operation', value: '手术名称'},
                {key: 'outDep', value: '出院科室'},
                {key: 'patient', value: '病人姓名'},
                {key: 'doctor', value: '医生姓名'}
            ],
            group2: [
                {key: 'lendCase', value: '病案借阅'},
                {key: 'printCase', value: '病案打印'},
                {key: 'trackCase', value: '病案示踪'},
                {key: 'main.system', value: '系统管理'}
            ],
            group3: [
                {key: 'research', value: '科研管理'},
                {key: 'visit', value: '随访管理'}
            ]
        }

        vm.changeSearchType = changeSearchType;

        function changeSearchType (searchType) {
            vm.searchType = searchType;
        }
    }
})();