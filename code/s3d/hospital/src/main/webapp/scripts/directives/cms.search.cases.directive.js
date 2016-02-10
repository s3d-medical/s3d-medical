(function () {
    angular.module('cms')
        .directive('cmsSearchCases', cmsSearchCases);

    cmsSearchCases.$inject = ['$rootScope', '$timeout'];

    function cmsSearchCases ($rootScope, $timeout) {
        return {
            restrict: 'E',
            templateUrl: 'tplSearchCases',
            replace: true,
            scope: {
                searchType: '=',
                onSearchCases: '&'
            },
            link: function (scope, element, attrs) {

                (function () {
                    scope.conditions = [
                        {key: 'caseNum', value: '病案号'},
                        {key: 'sick', value: '疾病名称'},
                        {key: 'operation', value: '手术名称'},
                        {key: 'outDep', value: '出院科室'},
                        {key: 'patient', value: '病人姓名'},
                        {key: 'doctor', value: '医生姓名'}
                    ];
                    scope.searchType = scope.searchType || 'caseNum';

                    scope.changeSearchType = changeSearchType;
                    scope.search = search;
                })();

                function changeSearchType (searchType) {
                    scope.searchType = searchType;
                }

                function search () {
                    if (scope.keyword) {
                        console.log('searching...');
                    }
                }
            }
        }
    }
})();