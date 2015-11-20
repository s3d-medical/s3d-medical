(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsSelectDepartment', cmsSelectDepartment);

    cmsSelectDepartment.$inject = ['$timeout', 'localDataService'];

    function cmsSelectDepartment ($timeout, localDataService) {
        return {
            restrict: 'AE',
            templateUrl: 'tplSelectDepartment',
            replace: true,
            scope: {
                onSave: '&'
            },
            link: function (scope, element, attrs) {
                scope.search = search;
                scope.changeItem = changeItem;
                scope.save = save;
                scope.close = close;

                scope.$on('SelectDepartment.Open', open);

                function open (event, data) {
                    scope.departments = localDataService.getDepartments();
                    scope.items = [];
                    scope.selectedId = 0;
                    scope.condition = '';

                    $('.department-list').treeview({
                        data: scope.departments,
                        enableLinks: false,
                        onNodeSelected: _selectNode
                    });
                    element.modal({backdrop: 'static'});
                }

                function search () {
                    if (scope.condition && scope.departments && scope.departments.length) {
                        scope.items = [];
                        _searchDepartment(scope.departments);
                        if (scope.items.length) {
                            scope.selectedId = scope.items[0].id;
                        }
                    }
                }

                function changeItem (departmentId) {
                    scope.selectedId = departmentId;
                }

                function save () {
                    scope.onSave({departmentId: scope.selectedId});
                    close();
                }

                function close () {
                    element.modal('hide');
                }

                function _selectNode (event, data) {
                    $timeout(function () {
                        scope.condition = '';
                        if (data.nodes && data.nodes.length) {
                            scope.items = data.nodes;
                            scope.selectedId = scope.items[0].id;
                        } else {
                            scope.selectedId = 0;
                            scope.items = [];
                        }
                    });
                }

                function _searchDepartment (departments) {
                    for (var i in departments) {
                        if (~departments[i].text.indexOf(scope.condition)) {
                            scope.items.push(departments[i]);
                        }
                        if (departments[i].nodes && departments[i].nodes.length) {
                            _searchDepartment(departments[i].nodes);
                        }
                    }
                }
            }
        }
    }
})();