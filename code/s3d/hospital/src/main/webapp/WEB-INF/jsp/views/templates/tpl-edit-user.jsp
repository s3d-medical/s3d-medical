<script type="text/ng-template" id="tplEditUser">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">员工编辑</h3>
                </div>
                <div class="modal-body small">
                    <div class="row">
                        <div class="col-xs-2">
                            <span>姓名</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="姓名" ng-model="user.realName">
                        </div>
                        <div class="col-xs-2">
                            <span>编号</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="编号" ng-model="user.code">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>所在部门</span>
                        </div>
                        <div class="department-wrap col-xs-4">
                            <input type="text" class="form-control" ng-model="parentDepartment.text" readonly>
                            <button type="button" class="btn btn-primary" ng-click="chooseParentDepartment()">选择</button>
                        </div>
                        <div class="col-xs-2">
                            <span>邮件地址</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="邮件地址" ng-model="user.email">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>手机号码</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="手机号码" ng-model="user.phone">
                        </div>
                        <div class="col-xs-2">
                            <span>办公电话</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="办公电话" ng-model="user.tel">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>登录名</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="登录名" ng-model="user.userName">
                        </div>
                        <div class="col-xs-2">
                            <span>默认语言</span>
                        </div>
                        <div class="col-xs-4">
                            <select class="form-control"></select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>备注</span>
                        </div>
                        <div class="col-xs-10">
                            <textarea class="form-control" ng-model="user.remark"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>导入数据对应值</span>
                        </div>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" placeholder="导入数据对应值" ng-model="user.key">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" ng-click="save()">保存</button>
                    <button type="submit" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">取消</button>
                </div>
            </div>
        </div>
        <cms-select-department on-save="changeParentDepartment(departmentId)"></cms-select-department>
    </div>
</script>