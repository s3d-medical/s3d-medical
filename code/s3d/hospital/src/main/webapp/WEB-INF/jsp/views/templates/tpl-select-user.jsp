<script type="text/ng-template" id="tplSelectUser">
    <div class="select-user select-department modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" aria-label="Close" ng-click="close()"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title normal-weight text-center">选择用户</h4>
                </div>
                <div class="modal-body small">
                    <div class="user-list menu pull-left"></div>
                    <div class="search-wrap pull-left">
                        <div>
                            <input class="input-search form-control" ng-model="condition">
                            <button type="button" class="btn btn-primary" ng-click="search()">查询</button>
                        </div>
                        <ul>
                            <li ng-repeat="u in users" ng-class="{'theme-bg-color': u.id == user.id}" ng-click="clickUser(u)">{{::u.realName}}</li>
                        </ul>
                        <ul class="btn-wrap">
                            <li><button type="button" class="btn btn-primary" ng-disabled="!user.id" ng-click="addUser()">=></button></li>
                            <li><button type="button" class="btn btn-primary" ng-disabled="!selectedUser.id" ng-click="removeUser()"><=</button></li>
                        </ul>
                        <ul>
                            <li ng-repeat="u in selectedUsers" ng-class="{'theme-bg-color': u.id == selectedUser.id}" ng-click="clickSelectedUser(u)">{{::u.realName}}</li>
                        </ul>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary ok" ng-disabled="selectedId == 0" ng-click="save()">确定</button>
                    <button type="button" class="btn btn-default ok" ng-click="close()">取消</button>
                </div>
            </div>
        </div>
    </div>
</script>