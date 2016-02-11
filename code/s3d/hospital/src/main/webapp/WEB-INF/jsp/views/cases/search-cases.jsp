<script type="text/ng-template" id="viewSearchCases">
    <div class="cases">
        <cms-search-cases></cms-search-cases>
        <%--<div class="display-table common-table">
            <div class="display-table-head theme-bg-color">
                <div class="display-table-cell">病案号</div>
                <div class="display-table-cell">疾病名称</div>
                <div class="display-table-cell">手术名称</div>
                <div class="display-table-cell">出院科室</div>
                <div class="display-table-cell">病人姓名</div>
                <div class="display-table-cell">医生姓名</div>
            </div>
            <div class="display-table-body">
                <div ng-repeat="r in [1,2]" class="display-table-row">
                    <div class="display-table-cell"></div>
                    <div class="display-table-cell"></div>
                    <div class="display-table-cell"></div>
                    <div class="display-table-cell"></div>
                    <div class="display-table-cell"></div>
                    <div class="display-table-cell"></div>
                </div>
            </div>
        </div>--%>
        <div ng-repeat="case in sc.cases" class="case">
            <div class="title">
                <%--{{::'病案号：' + case.caseNo + ' ' + case.name + ' ' + (sex == 1 ? '男' : '女') + ' ' + case.age + '岁' + ' ' + case.sick}}--%>
                <span>{{::'病案号：' + case.caseNo}}</span>
                <span>{{::case.name}}</span>
                <span>{{::(sex == 1 ? '男' : '女')}}</span>
                <span>{{::case.age + '岁'}}</span>
                <span>{{::case.sick}}</span>
            </div>
            <div class="case-date pull-left">
                <div>{{::'入院日期：' + case.inTime}}</div>
                <div>{{::'出院日期：' + case.outTime}}</div>
            </div>
            <div class="pull-left">
                <div>{{::'入院科别：' + case.inDepartment}}</div>
                <div>{{::'出院科别：' + case.outDepartment}}</div>
            </div>
            <div class="pull-left">
                <div>{{::'入院途径：' + case.inType}}</div>
                <div>{{::'出院方式：' + case.outType}}</div>
            </div>
            <div class="address">{{::'地址：' + case.address}}</div>
        </div>
        <cms-pagination cfg="cfg"></cms-pagination>
    </div>
</script>