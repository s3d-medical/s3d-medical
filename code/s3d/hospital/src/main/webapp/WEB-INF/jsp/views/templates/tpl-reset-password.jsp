<script type="text/ng-template" id="tplResetPassword">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">重置密码</h3>
                </div>
                <div class="modal-body small">
                    <div class="row">
                        <div class="col-xs-3"></div>
                        <div class="col-xs-2">
                            <span>新密码</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="password" class="form-control" placeholder="新密码">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3"></div>
                        <div class="col-xs-2">
                            <span>确认密码</span>
                        </div>
                        <div class="col-xs-4">
                            <input type="password" class="form-control" placeholder="确认密码">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" ng-click="save()">提交</button>
                    <button type="submit" class="btn btn-default" ng-click="cancel()">取消</button>
                </div>
            </div>
        </div>
    </div>
</script>