<script type="text/ng-template" id="tplEditDepartment">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">部门编辑</h3>
                </div>
                <div class="modal-body small">
                    <div class="row">
                        <div class="col-xs-2">
                            <span>部门名称</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="部门名称">
                        </div>
                        <div class="col-xs-2">
                            <span>导入数据对应值</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="导入数据对应值">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>上级部门</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="上级部门">
                        </div>
                        <div class="col-xs-2">
                            <span>编号</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="编号">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>排序号</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" placeholder="排序号">
                        </div>
                        <div class="col-xs-2">
                            <span>是否有效</span>
                        </div>
                        <div class="col-xs-4">
                            <label><input type="radio" name="active">是</label>
                            <label><input type="radio" name="active">否</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <span>备注</span>
                        </div>
                        <div class="col-xs-10">
                            <textarea class="form-control"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" ng-click="save()">保存</button>
                    <button type="submit" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">取消</button>
                </div>
            </div>
        </div>
    </div>
</script>