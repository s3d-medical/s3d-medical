<script type="text/ng-template" id="viewPermissions">
    <div class="permissions">
        <h4 class="theme-color text-center">角色授权查询</h4>
        <div id="permissionTree" class="menu pull-left">

        </div>
        <table class="pull-left table table-bordered table-striped" ng-if="ps.permission.text">
            <tbody>
                <tr>
                    <td>权限名</td>
                    <td><span ng-bind="ps.permission.text"></span></td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td><span ng-bind="ps.permission.remark"></span></td>
                </tr>
                <tr>
                    <td>相关角色</td>
                    <td><span ng-bind="ps.permission.roles"></span></td>
                </tr>
                <tr>
                    <td>相关组织架构</td>
                    <td><span ng-bind="ps.permission.departments"></span></td>
                </tr>
            </tbody>
        </table>
    </div>
</script>