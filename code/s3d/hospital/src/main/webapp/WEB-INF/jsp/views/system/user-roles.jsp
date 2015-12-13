<script type="text/ng-template" id="viewUserRoles">
    <div class="user-role role">
        <h4 class="theme-color text-center">员工授权查询</h4>
        <table class="table table-bordered table-striped">
            <tbody>
                <tr>
                    <td class="vertical-middle">姓名</td>
                    <td>
                        <input type="text" class="user-name form-control theme-color" placeholder="姓名" ng-model="ur.user.name">
                        <button type="button" class="search btn btn-primary" ng-click="ur.search()">查询</button>
                    </td>
                </tr>
                <tr>
                    <td class="vertical-middle">备注</td>
                    <td><span ng-bind="ur.user.remark"></span></td>
                </tr>
                <tr>
                    <td class="vertical-middle">相关组织架构</td>
                    <td>
                        <span ng-repeat="d in ur.user.departments" ng-bind="d"></span>
                    </td>
                </tr>
                <tr>
                    <td class="vertical-middle">相关权限</td>
                    <td>
                        <div class="panel panel-default" ng-repeat="c in ur.user.permissionCategories">
                            <div class="panel-heading">
                                <i class="glyphicon" ng-class="{'glyphicon glyphicon-plus': !c.expanded, 'glyphicon glyphicon-minus': c.expanded}" ng-click="c.expanded = !c.expanded"></i>
                                <span ng-bind="c.text"></span>
                            </div>
                            <ul class="permission-list" ng-show="c.expanded">
                                <li class="col-md-4" ng-repeat="p in c.nodes">
                                    <label>{{::p.text}}</label>
                                </li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
        <%--<div class="text-center">
            <button type="submit" class="btn btn-primary">保存</button>
            <button type="submit" class="btn btn-default" ng-click="dc.cancel()">取消</button>
        </div>--%>
        <cms-search-users users="ur.users" on-choose-user="ur.getUserInfo(userId)"></cms-search-users>
    </div>
</script>