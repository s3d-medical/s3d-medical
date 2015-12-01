<script type="text/ng-template" id="viewRoles">
    <div class="roles">
        <ul class="nav nav-tabs">
            <li class="pull-right">
                <button type="button" class="btn btn-primary">新建</button>
                <button type="button" class="btn btn-danger">删除</button>
            </li>
        </ul>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td><input type="checkbox"></td>
                <td><b>角色名</b></td>
                <td><b>所属分类</b></td>
                <td><b>创建者</b></td>
                <td><b>描述</b></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="i in rs.roles" ui-sref="main.system.role({roleId: i.id})">
                <td><input type="checkbox"></td>
                <td ng-bind="i.name"></td>
                <td ng-bind="i.category"></td>
                <td ng-bind="i.creator"></td>
                <td ng-bind="i.remark"></td>
            </tr>
            </tbody>
        </table>
        <ul class="pagination">
            <li>
                <span aria-hidden="true">&laquo;</span>
            </li>
            <li ng-repeat="p in rs.cfg.pages" ng-class="{'active': rs.cfg.pageNum == p}" ng-click="rs.loadPageData(p)">
                <span ng-bind="p"></span>
            </li>
            <li>
                <span aria-hidden="true">&raquo;</span>
            </li>
        </ul>
        <div>
            <span>共&nbsp;<b>{{rs.cfg.count}}</b>&nbsp;条</span>
            <span>&nbsp;&nbsp;每页</span>
            <b><input type="text" class="page-size" ng-model="rs.cfg.pageSize"></b>
            <span>条&nbsp;&nbsp;</span>
            <button type="button" class="btn btn-primary">刷新</button>
        </div>
    </div>
</script>