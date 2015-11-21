(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsSelectDepartment', cmsSelectDepartment);

    cmsSelectDepartment.$inject = ['localDataService'];

    function cmsSelectDepartment (localDataService) {
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
                        enableLinks: true,
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

                function _selectNode (data) {
                    console.log(data);
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