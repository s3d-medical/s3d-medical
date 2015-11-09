<script type="text/ng-template" id="tplViewDepartment">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">部门</h3>
                </div>
                <div class="modal-body small">
                    <table class="pull-left table table-bordered table-striped">
                        <tbody>
                        <tr>
                            <td>姓名</td>
                            <td><span ng-bind="department.name"></span></td>
                            <td>导入数据对应值</td>
                            <td><span ng-bind="department.key"></span></td>
                        </tr>
                        <tr>
                            <td>上级部门</td>
                            <td><span ng-bind="department.parent"></span></td>
                            <td>编号</td>
                            <td><span ng-bind="department.code"></span></td>
                        </tr>
                        <tr>
                            <td>排序号</td>
                            <td><span ng-bind="department.order"></span></td>
                            <td>是否有效</td>
                            <td>
                                <label><input type="radio" name="active" disabled ng-checked="department.active">是</label>
                                <label><input type="radio" name="active" disabled ng-checked="!department.active">否</label>
                            </td>
                        </tr>
                        <tr>
                            <td>备注</td>
                            <td colspan="3"><span ng-bind="department.remark"></span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary ok" data-dismiss="modal" ng-click="edit()">编辑</button>
                </div>
            </div>
        </div>
    </div>
</script>