<script type="text/ng-template" id="viewRole">
    <div class="role">
        <h4>角色分配</h4>
        <div class="row">
            <div class="col-xs-2">
                <span>角色名</span>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" placeholder="角色名">
            </div>
            <div class="col-xs-2">
                <span>所属分类</span>
            </div>
            <div class="col-xs-3">
                <select></select>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>用户指派</span>
            </div>
            <div class="col-xs-8">
                <textarea class="form-control"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">

            </div>
            <div class="col-xs-8">

            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>描述</span>
            </div>
            <div class="col-xs-8">
                <textarea class="form-control"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <span>创建者</span>
            </div>
            <div class="col-xs-8">
                <span></span>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">保存</button>
            <button type="submit" class="btn btn-default" ng-click="dc.cancel()">取消</button>
        </div>
    </div>
</script>