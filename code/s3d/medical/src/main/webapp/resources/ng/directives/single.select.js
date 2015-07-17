(function () {
    'use strict';
    angular.module('mainPage')
        .directive('singleSelect', singleSelect);

    function singleSelect () {
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
            template:   '<ui-select ng-style="elStyle">' +
                            '<ui-select-match placeholder="">{{$select.selected.name}}</ui-select-match>' +
                            '<ui-select-choices repeat="i.id as i in collection | filter: $select.search track by i.shortcut">' +
                                '<span ng-bind-html="i.name"></span>' +
                            '</ui-select-choices>' +
                        '</ui-select>'
        }
    }
})();