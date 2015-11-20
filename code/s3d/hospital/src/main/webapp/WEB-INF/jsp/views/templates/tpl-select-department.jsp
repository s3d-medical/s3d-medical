<script type="text/ng-template" id="tplSelectDepartment">
    <div class="select-department modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" aria-label="Close" ng-click="close()"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title normal-weight text-center">选择部门</h3>
                </div>
                <div class="modal-body small">
                    <div class="department-list menu pull-left"></div>
                    <div class="search-wrap pull-left">
                        <div>
                            <input class="input-search form-control" ng-model="condition">
                            <button type="button" class="btn btn-primary" ng-click="search()">查询</button>
                        </div>
                        <ul>
                            <li ng-repeat="item in items" ng-class="{'theme-bg-color': item.id == selectedId}" ng-click="changeItem(item.id)">{{::item.text}}</li>
                        </ul>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary ok" ng-disabled="selectedId == 0" ng-click="save()">确定</button>
                    <button type="button" class="btn btn-default ok" ng-click="close()">取消</button>
                </div>
            </div>
        </div>
    </div>
</script>