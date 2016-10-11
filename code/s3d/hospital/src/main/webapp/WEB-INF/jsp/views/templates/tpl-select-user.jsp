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
                            <li ng-repeat="u in sourceUsers" ng-click="clickSourceUser($event, u)">{{::u.realName}}</li>
                        </ul>
                        <ul class="btn-wrap">
                            <li><button type="button" class="btn btn-primary" ng-disabled="!selectedSourceUsers.length" ng-click="addUser()">添加-></button></li>
                            <li><button type="button" class="btn btn-primary" ng-disabled="!selectedTargetUsers.length" ng-click="removeUser()"><-删除</button></li>
                            <li><button type="button" class="btn btn-primary" ng-disabled="!sourceUsers.length" ng-click="addAllUsers()">全部添加-></button></li>
                            <li><button type="button" class="btn btn-primary" ng-disabled="!targetUsers.length" ng-click="removeAllUsers()"><-全部删除</button></li>
                        </ul>
                        <ul>
                            <li ng-repeat="u in targetUsers" ng-click="clickTargetUser($event, u)">{{::u.realName}}</li>
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