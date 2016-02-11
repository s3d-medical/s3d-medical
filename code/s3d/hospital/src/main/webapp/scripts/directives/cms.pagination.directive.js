(function () {
    angular.module('cms')
        .directive('cmsPagination', cmsPagination);

    cmsPagination.$inject = [];

    function cmsPagination () {
        return {
            restrict: 'E',
            templateUrl: 'tplPagination',
            replace: true,
            scope: {
                cfg: '='
            },
            link: function (scope, element, attrs) {

            }
        }
    }
})();