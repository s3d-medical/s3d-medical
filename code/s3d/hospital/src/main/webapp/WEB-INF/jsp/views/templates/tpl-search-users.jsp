<script type="text/ng-template" id="tplSearchUsers">
    <div class="search-users modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title normal-weight">用户</h4>
                </div>
                <div class="modal-body small">
                    <ul>
                        <li ng-repeat="u in users" ng-class="{'theme-bg-color': user.id == u.id}" ng-click="selectUser(u)">{{::u.realName}}</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal" ng-click="onCancel()">取消</button>
                    <button type="button" class="btn btn-primary ok" ng-disabled="!user" data-dismiss="modal" ng-click="onConfirm()">确定</button>
                </div>
            </div>
        </div>
    </div>
</script>