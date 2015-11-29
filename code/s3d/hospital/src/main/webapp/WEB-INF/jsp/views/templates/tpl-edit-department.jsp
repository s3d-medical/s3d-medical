<script type="text/ng-template" id="tplEditDepartment">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title normal-weight text-center">部门编辑</h4>
                </div>
                <div class="modal-body small">
                    <div class="row">
                        <div class="col-xs-2">
                            <span>部门名称</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="部门名称" ng-model="department.name">
                        </div>
                        <div class="col-xs-2">
                            <span>导入数据对应值</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="导入数据对应值" ng-model="department.key">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>上级部门</span>
                        </div>
                        <div class="department-wrap col-xs-4">
                            <input type="text" class="form-control" ng-model="parentDepartment.text" readonly>
                            <button type="button" class="btn btn-primary" ng-click="chooseParentDepartment()">选择</button>
                        </div>
                        <div class="col-xs-2">
                            <span>编号</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="编号" ng-model="department.code">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>排序号</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder="排序号" ng-model="department.order">
                        </div>
                        <div class="col-xs-2">
                            <span>是否有效</span>
                        </div>
                        <div class="col-xs-4">
                            <label><input type="radio" name="active1" ng-model="department.active" value="true">是</label>
                            <label><input type="radio" name="active1" ng-model="department.active" value="false">否</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>备注</span>
                        </div>
                        <div class="col-xs-10">
                            <textarea class="form-control" ng-model="department.remark"></textarea>
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