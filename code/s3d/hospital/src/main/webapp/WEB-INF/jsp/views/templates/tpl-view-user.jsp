<script type="text/ng-template" id="tplViewUser">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">员工</h3>
                </div>
                <div class="modal-body small">
                    <table class="pull-left table table-bordered table-striped">
                        <tbody>
                        <tr>
                            <td>姓名</td>
                            <td><span ng-bind="user.realName"></span></td>
                            <td>编号</td>
                            <td><span ng-bind="user.code"></span></td>
                        </tr>
                        <tr>
                            <td>所在部门</td>
                            <td><span ng-bind="user.departmentName"></span></td>
                            <td>邮件地址</td>
                            <td><span ng-bind="user.email"></span></td>
                        </tr>
                        <tr>
                            <td>手机号码</td>
                            <td><span ng-bind="user.phone"></span></td>
                            <td>办公电话</td>
                            <td><span ng-bind="user.tel"></span></td>
                        </tr>
                        <tr>
                            <td>登录名</td>
                            <td><span ng-bind="user.userName"></span></td>
                            <td>默认语言</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>备注</td>
                            <td colspan="3"><span ng-bind="user.remark"></span></td>
                        </tr>
                        <tr>
                            <td>导入数据对应值</td>
                            <td colspan="3"><span ng-bind="user.key"></span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary ok" data-dismiss="modal" ng-click="edit()">编辑</button>
                    <button type="button" class="btn btn-primary ok" data-dismiss="modal" ng-click="resetPassword()">重置密码</button>
                </div>
            </div>
        </div>
    </div>
</script>