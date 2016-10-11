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
                scope.clickSourceUser = clickSourceUser;
                scope.clickTargetUser = clickTargetUser;
                scope.addUser = addUser;
                scope.removeUser = removeUser;
                scope.addAllUsers = addAllUsers;
                scope.removeAllUsers = removeAllUsers;
                scope.save = save;
                scope.close = close;

                scope.$on('SelectUser.Open', open);

                function open (event, data) {
                    scope.departments = localDataService.getDepartments();
                    scope.sourceUsers = [];
                    scope.targetUsers = data.targetUsers || [];
                    scope.selectedSourceUsers = [];
                    scope.selectedTargetUsers = [];
                    scope.condition = '';

                    $('.user-list').treeview({
                        data: scope.departments,
                        enableLinks: false,
                        onNodeSelected: _selectNode
                    });
                    element.modal({backdrop: 'static'});
                }

                function search () {
                    if (_.trim(scope.condition)) {
                        dataService.post('users/search', {realName: _.trim(scope.condition)})
                            .then(function (resp) {
                                scope.sourceUsers = resp.result;
                            });
                        /*var resp = {
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
                        scope.sourceUsers = resp.users;*/
                    }
                }

                function clickSourceUser (event, user) {
                    var $el = $(event.currentTarget);
                    if ($el.hasClass('theme-bg-color')) {
                        _.remove(scope.selectedSourceUsers, function (item) {
                            return item.id == user.id;
                        });
                        $el.removeClass('theme-bg-color');
                    } else {
                        scope.selectedSourceUsers.push(user);
                        $el.addClass('theme-bg-color');
                    }
                }

                function clickTargetUser (event, user) {
                    var $el = $(event.currentTarget);
                    if ($el.hasClass('theme-bg-color')) {
                        _.remove(scope.selectedTargetUsers, function (item) {
                            return item.id == user.id;
                        });
                        $el.removeClass('theme-bg-color');
                    } else {
                        scope.selectedTargetUsers.push(user);
                        $el.addClass('theme-bg-color');
                    }
                }

                function addUser () {
                    if (scope.selectedSourceUsers.length) {
                        for (var i in scope.selectedSourceUsers) {
                            scope.targetUsers.push(scope.selectedSourceUsers[i]);
                            _.remove(scope.sourceUsers, function (item) {
                                return item.id == scope.selectedSourceUsers[i].id;
                            })
                        }
                        scope.selectedSourceUsers.length = 0;
                    }
                }

                function removeUser () {
                    if (scope.selectedTargetUsers.length) {
                        for (var i in scope.selectedTargetUsers) {
                            scope.sourceUsers.push(scope.selectedTargetUsers[i]);
                            _.remove(scope.targetUsers, function (item) {
                                return item.id == scope.selectedTargetUsers[i].id;
                            })
                        }
                        scope.selectedTargetUsers.length = 0;
                    }
                }

                function addAllUsers () {
                    for (var i in scope.sourceUsers) {
                        scope.targetUsers.push(scope.sourceUsers[i]);
                    }
                    scope.sourceUsers.length = 0;
                    scope.selectedSourceUsers.length = 0;
                }

                function removeAllUsers () {
                    for (var i in scope.targetUsers) {
                        scope.sourceUsers.push(scope.targetUsers[i]);
                    }
                    scope.targetUsers.length = 0;
                    scope.selectedTargetUsers.length = 0;
                }

                function save () {
                    scope.onSave({users: scope.targetUsers});
                    close();
                }

                function close () {
                    element.modal('hide');
                }

                function _selectNode (event, data) {
                    dataService.post('users/search', {departmentId: data.id})
                    //dataService.get('departments/' + data.id + '/users?page=0&pageSize=0')
                        .then(function (resp) {
                            $timeout(function () {
                                scope.sourceUsers = resp.result;
                            });
                        });
                    /*var resp = {
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
                        scope.sourceUsers = resp.users;
                    });*/
                }
            }
        }
    }
})();