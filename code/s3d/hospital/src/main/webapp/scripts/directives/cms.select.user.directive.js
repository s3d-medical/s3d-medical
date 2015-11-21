(function () {
    'use strict';

    angular.module('cms')
        .directive('cmsSelectUser', cmsSelectUser);

    cmsSelectUser.$inject = ['$timeout', 'localDataService', 'dataService'];

    function cmsSelectUser ($timeout, localDataService, dataService) {
        return {
            restrict: 'AE',
            templateUrl: 'tplSelectUser',
            replace: true,
            scope: {
                onSave: '&'
            },
            link: function (scope, element, attrs) {
                scope.search = search;
                scope.clickUser = clickUser;
                scope.clickSelectedUser = clickSelectedUser;
                scope.addUser = addUser;
                scope.removeUser = removeUser;
                scope.save = save;
                scope.close = close;

                scope.$on('SelectUser.Open', open);

                function open (event, data) {
                    scope.departments = localDataService.getDepartments();
                    scope.users = [];
                    scope.selectedUsers = data.selectedUsers;
                    scope.user = {};
                    scope.selectedUser = {};
                    scope.condition = '';

                    $('.user-list').treeview({
                        data: scope.departments,
                        enableLinks: false,
                        onNodeSelected: _selectNode
                    });
                    element.modal({backdrop: 'static'});
                }

                function search () {
                    if (scope.condition) {
                        var resp = {
                            users: [
                                {"id": 11, "realName": "用户11"},
                                {"id": 12, "realName": "用户12"},
                                {"id": 13, "realName": "用户13"},
                                {"id": 14, "realName": "用户14"},
                                {"id": 15, "realName": "用户15"},
                                {"id": 16, "realName": "用户16"},
                                {"id": 17, "realName": "用户17"},
                                {"id": 18, "realName": "用户18"},
                                {"id": 19, "realName": "用户19"},
                                {"id": 20, "realName": "用户20"}
                            ]
                        };

                        scope.users = resp.users;
                    }
                }

                function clickUser (user) {
                    scope.user = user;
                }

                function clickSelectedUser (user) {
                    scope.selectedUser = user;
                }

                function addUser () {
                    scope.selectedUsers.push(scope.user);
                    _.remove(scope.users, function (item) {
                        return item.id == scope.user.id;
                    });
                    scope.user = {};
                }

                function removeUser () {
                    scope.users.push(scope.selectedUser);
                    _.remove(scope.selectedUsers, function (item) {
                        return item.id == scope.selectedUser.id;
                    });
                    scope.selectedUser = {};
                }

                function save () {
                    scope.onSave({users: scope.selectedUsers});
                    close();
                }

                function close () {
                    element.modal('hide');
                }

                function _selectNode (event, data) {
                    var resp = {
                        users: [
                            {"id": 1, "realName": "用户1"},
                            {"id": 2, "realName": "用户2"},
                            {"id": 3, "realName": "用户3"},
                            {"id": 4, "realName": "用户4"},
                            {"id": 5, "realName": "用户5"},
                            {"id": 6, "realName": "用户6"},
                            {"id": 7, "realName": "用户7"},
                            {"id": 8, "realName": "用户8"},
                            {"id": 9, "realName": "用户9"},
                            {"id": 10, "realName": "用户10"}
                        ]
                    };

                    $timeout(function () {
                        scope.users = resp.users;
                    });
                }
            }
        }
    }
})();