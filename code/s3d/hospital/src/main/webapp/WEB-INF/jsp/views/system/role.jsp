﻿<script type="text/ng-template" id="viewRole">
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
                <ul>
                    <li ng-repeat="u in rc.role.users">{{u.name}}</li>
                </ul>
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
                        <span ng-bind="c.name + ' (' + 0 + '/' + c.permissions.length + ')'"></span>
                        <label><input type="checkbox">全选</label>
                    </div>
                    <ul ng-show="c.expanded">
                        <li class="col-md-4" ng-repeat="p in c.permissions">
                            <label><input type="checkbox">{{p.name}}</label>
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
            <button type="submit" class="btn btn-default" ng-click="dc.cancel()">取消</button>
        </div>
    </div>
</script>