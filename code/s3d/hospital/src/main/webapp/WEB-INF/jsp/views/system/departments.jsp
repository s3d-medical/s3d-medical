<script type="text/ng-template" id="viewDepartments">
    <div class="departments">
        <ul class="nav nav-tabs">
            <%--<li role="presentation" ng-class="{'active': ds.cfg.type == 'departments'}" ng-click="ds.changeType('departments')"><a>部门</a></li>
            <li role="presentation" ng-class="{'active': ds.cfg.type == 'employees'}" ng-click="ds.changeType('employees')"><a>员工</a></li>--%>
            <li role="presentation" ng-class="{'active': ds.cfg.type == 'departments'}" ui-sref="main.system.departments({departmentId: ds.cfg.parentId, type: 'departments'})"><a>部门</a></li>
            <li role="presentation" ng-class="{'active': ds.cfg.type == 'employees'}" ui-sref="main.system.departments({departmentId: ds.cfg.parentId, type: 'employees'})"><a>员工</a></li>
            <li class="pull-right">
                <button type="button" class="btn btn-primary">新建{{ds.cfg.type == 'departments' ? '部门' : '员工'}}</button>
                <button type="button" class="btn btn-danger">删除</button>
            </li>
            <!--<li class="glyphicon glyphicon-plus" ng-if="ds.cfg.type == 'employees'" ui-sref="main.system.employee"></li>-->
        </ul>
        <table ng-if="ds.cfg.type == 'departments'" class="table table-bordered table-striped">
            <thead>
            <tr>
                <td><input type="checkbox"></td>
                <td><b>排序号</b></td>
                <td><b>上级部门</b></td>
                <td><b>部门名称</b></td>
                <td><b>备注</b></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="i in ds.departments" ui-sref="main.system.department({departmentId: i.id})">
                <td><input type="checkbox"></td>
                <td ng-bind="i.order"></td>
                <td ng-bind="i.parent"></td>
                <td ng-bind="i.text"></td>
                <td ng-bind="i.remark"></td>
            </tr>
            </tbody>
        </table>
        <table ng-if="ds.cfg.type == 'employees'" class="table table-bordered table-striped">
            <thead>
            <tr>
                <td><input type="checkbox"></td>
                <td><b>排序号</b></td>
                <td><b>所在部门</b></td>
                <td><b>姓名</b></td>
                <td><b>登录名</b></td>
                <td><b>邮件地址</b></td>
                <td><b>手机号码</b></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="i in ds.employees" ui-sref="main.system.employee({employeeId: i.id})">
                <td><input type="checkbox"></td>
                <td ng-bind="i.order"></td>
                <td ng-bind="i.department"></td>
                <td ng-bind="i.realName"></td>
                <td ng-bind="i.userName"></td>
                <td ng-bind="i.email"></td>
                <td ng-bind="i.phone"></td>
            </tr>
            </tbody>
        </table>
        <ul class="pagination">
            <li>
                <span aria-hidden="true">&laquo;</span>
            </li>
            <li ng-repeat="p in ds.cfg.pages" ng-class="{'active': ds.cfg.pageNum == p}" ng-click="ds.loadPageData(p)">
                <span ng-bind="p"></span>
            </li>
            <li>
                <span aria-hidden="true">&raquo;</span>
            </li>
        </ul>
        <div>
            <span>共&nbsp;<b>{{ds.cfg.count}}</b>&nbsp;条</span>
            <span>&nbsp;&nbsp;每页</span>
            <b><input type="text" ng-model="ds.cfg.pageSize"></b>
            <span>条&nbsp;&nbsp;</span>
            <button type="button" class="btn btn-primary">刷新</button>
        </div>
    </div>
</script>