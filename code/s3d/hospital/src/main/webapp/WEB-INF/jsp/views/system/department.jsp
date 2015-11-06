<script type="text/ng-template" id="viewDepartment">
    <div class="department">
        <h4>部门编辑</h4>
        <div class="row">
            <div class="col-xs-2">
                <span>部门名称</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="部门名称">
            </div>
            <div class="col-xs-2">
                <span>导入数据对应值</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="导入数据对应值">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>上级部门</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="上级部门">
            </div>
            <div class="col-xs-2">
                <span>编号</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="编号">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>排序号</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="排序号">
            </div>
            <div class="col-xs-2">
                <span>是否有效</span>
            </div>
            <div class="col-xs-3">
                <label><input type="radio" name="active">是</label>
                <label><input type="radio" name="active">否</label>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>备注</span>
            </div>
            <div class="col-xs-8">
                <textarea class="form-control"></textarea>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">保存</button>
            <button type="submit" class="btn btn-default" ng-click="dc.cancel()">取消</button>
        </div>
    </div>
</script>