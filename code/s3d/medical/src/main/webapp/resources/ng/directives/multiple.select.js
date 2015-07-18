(function () {
    'use strict';
    angular.module('mainPage')
        .directive('multipleSelect', multipleSelect);

    function multipleSelect () {
        return {
            restrict: 'AE',
            replace: false,
            scope: {
                collection: '='
            },
            link: function (scope, element, attrs) {
                scope.elStyle = {width: element[0].style.width};
            },
            controller: function ($scope, $element, $attrs, $transclude) {
                
            },
            template:   '<ui-select multiple theme="bootstrap" ng-style="elStyle">' +
                            '<ui-select-match placeholder="">{{$item.id}}</ui-select-match>' +
                            '<ui-select-choices repeat="i.id as i in collection | filter: $select.search">' +
                                '<span ng-bind-html="i.id | highlight: $select.search"></span>' +
                            '</ui-select-choices>' +
                        '</ui-select>'
        }
    }
})();