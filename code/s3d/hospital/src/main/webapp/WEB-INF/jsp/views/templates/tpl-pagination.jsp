<script type="text/ng-template" id="tplPagination">
    <div>
        <ul class="pagination">
            <li>
                <span aria-hidden="true">&laquo;</span>
            </li>
            <li ng-repeat="p in cfg.pages" ng-class="{'active': cfg.pageNum == p}" ng-click="loadPageData(p)">
                <span ng-bind="p"></span>
            </li>
            <li>
                <span aria-hidden="true">&raquo;</span>
            </li>
        </ul>
        <div>
            <span>共&nbsp;<b>{{cfg.count}}</b>&nbsp;条</span>
            <span>&nbsp;&nbsp;每页</span>
            <b><input type="text" class="page-size" ng-model="cfg.pageSize"></b>
            <span>条&nbsp;&nbsp;</span>
            <button type="button" class="btn btn-primary" ng-click="refresh()">刷新</button>
        </div>
    </div>
</script>