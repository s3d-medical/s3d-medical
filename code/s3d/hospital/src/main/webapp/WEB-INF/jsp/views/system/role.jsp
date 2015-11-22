<script type="text/ng-template" id="viewRole">
    <div class="role">
        <h4 class="theme-color text-center">角色分配</h4>
        <div class="row">
            <div class="col-xs-2">
                <span>角色名</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control theme-color" placeholder="角色名" ng-model="rc.role.name">
            </div>
            <div class="col-xs-2">
                <span>所属分类</span>
            </div>
            <div class="col-xs-3 theme-color">
                <select>
                    <option value="">==请选择==</option>
                </select>
            </div>
        </div>
        <div class="user-wrap row">
            <div class="col-xs-2">
                <span>用户指派</span>
            </div>
            <div class="col-xs-10 theme-color">
                <ul class="col-sm-11">
                    <li ng-repeat="u in rc.role.users">{{u.realName}}</li>
                </ul>
                <span class="col-sm-1" ng-click="rc.openSelectUser()"></span>
            </div>
        </div>
        <div class="permission-wrap row">
            <div class="col-xs-2">
                <span>权限</span>
            </div>
            <div class="col-xs-10">
                <div class="panel panel-default" ng-repeat="c in rc.permissionCategories">
                    <div class="panel-heading">
                        <i class="glyphicon" ng-class="{'glyphicon glyphicon-plus': !c.expanded, 'glyphicon glyphicon-minus': c.expanded}" ng-click="c.expanded = !c.expanded"></i>
                        <span ng-bind="c.text + ' (' + 0 + '/' + c.nodes.length + ')'"></span>
                        <label><input type="checkbox">全选</label>
                    </div>
                    <ul class="permission-list" ng-show="c.expanded">
                        <li class="col-md-4" ng-repeat="p in c.nodes">
                            <label><input type="checkbox">{{p.text}}</label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>描述</span>
            </div>
            <div class="col-xs-10">
                <textarea class="form-control" ng-model="rc.role.remark"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>创建者</span>
            </div>
            <div class="col-xs-10">
                <span ng-bind="rc.role.creator"></span>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">保存</button>
            <button type="submit" class="btn btn-default" ng-click="rc.cancel()">取消</button>
        </div>
        <cms-select-user on-save="rc.changeUsers(users)"></cms-select-user>
    </div>
</script>