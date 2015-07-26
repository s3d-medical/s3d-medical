(function () {
    'use strict';
    angular.module('mainPage')
        .directive('formatDateInput', formatDateInput);

    function formatDateInput () {
        return {
            restrict: 'AE',
            replace: true,
            scope: {
                fd: '='
            },
            link: function (scope, element, attrs) {
                var arr = scope.fd ? scope.fd.split('-') : [];
                scope.year = arr[0] || '';
                scope.month = arr[1] || '';
                scope.day = arr[2] || '';
                element.find('input').bind('keyup', function () {
                    this.value = this.value.replace(/\D/g, '');
                    scope.fd = [scope.year, scope.month, scope.day].join('-');
                })
            },
            controller: function ($scope, $element, $attrs, $transclude) {

            },
            template:   '<div>' +
                            '<input type="text" maxlength="4" ng-model="year" style="width: 36px;">' + '-' +
                            '<input type="text" maxlength="2" ng-model="month" style="width: 18px;">' + '-' +
                            '<input type="text" maxlength="2" ng-model="day" style="width: 18px;">' +
                        '</div>'
        }
    }
})();