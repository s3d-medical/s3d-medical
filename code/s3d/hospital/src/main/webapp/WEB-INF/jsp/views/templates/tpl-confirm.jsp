<script type="text/ng-template" id="tplConfirm">
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title normal-weight" ng-bind="cfg.title"></h4>
                </div>
                <div class="modal-body small">
                    <div ng-show="cfg.desc" ng-bind="cfg.desc"></div>
                    <div ng-show="cfg.text" class="text" ng-bind="cfg.text"></div>
                    <div ng-if="cfg.template" ng-include="cfg.template"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default cancel" data-dismiss="modal" ng-if="cfg.type=='confirm'" ng-click="onCancel()">No</button>
                    <button type="button" class="btn btn-primary ok" data-dismiss="modal" ng-if="cfg.type=='confirm'" ng-click="onConfirm()">Yes</button>
                    <button type="button" class="btn btn-primary ok" data-dismiss="modal" ng-if="cfg.type=='alert'" ng-click="onConfirm()">Ok</button>
                </div>
            </div>
        </div>
    </div>
</script>