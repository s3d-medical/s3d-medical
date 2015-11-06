<script type="text/ng-template" id="viewEmployee">
    <div class="department">
        <h4>员工编辑</h4>
        <div class="row">
            <div class="col-xs-2">
                <span>姓名</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="姓名">
            </div>
            <div class="col-xs-2">
                <span>编号</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="编号">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>所在部门</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="所在部门">
            </div>
            <div class="col-xs-2">
                <span>邮件地址</span>
            </div>
            <div class="col-xs-3">
                <input type="email" class="form-control" placeholder="邮件地址">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>手机号码</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="手机号码">
            </div>
            <div class="col-xs-2">
                <span>办公电话</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="办公电话">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>登录名</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="登录名">
            </div>
            <div class="col-xs-2">
                <span>默认语言</span>
            </div>
            <div class="col-xs-3">
                <select class="form-control"></select>
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
        <div class="row">
            <div class="col-xs-2">
                <span>导入数据对应值</span>
            </div>
            <div class="col-xs-8">
                <input type="text" class="form-control" placeholder="导入数据对应值">
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">保存</button>
            <button type="submit" class="btn btn-default" ng-click="ec.cancel()">取消</button>
        </div>
    </div>
</script>