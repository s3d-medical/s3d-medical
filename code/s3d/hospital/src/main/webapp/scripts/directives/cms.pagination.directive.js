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
                cfg: '=',
                loadPage: '&'
            },
            link: function (scope, element, attrs) {
                scope.loadPageData = loadPageData;

                function loadPageData (pageNum) {
                    if (pageNum < 1) {
                        scope.cfg.pageNum = 1;
                        return;
                    } else if (scope.cfg.pages.length > 0 && pageNum > scope.cfg.pages.length) {
                        scope.cfg.pageNum = scope.cfg.pages.length;
                        return;
                    } else {
                        scope.cfg.pageNum = pageNum;
                    }
                    scope.loadPage();
                }
            }
        }
    }
})();