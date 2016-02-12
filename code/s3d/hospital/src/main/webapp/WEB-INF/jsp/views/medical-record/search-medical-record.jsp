<script type="text/ng-template" id="viewSearchMedicalRecord">
    <div class="cases">
        <cms-search-cases></cms-search-cases>
        <div ng-repeat="mr in smr.medicalRecords" class="case">
            <div class="title">
                <span>{{::'病案号：' + mr.id}}</span>
                <span>{{::mr.name}}</span>
                <span>{{::(sex == 1 ? '男' : '女')}}</span>
                <span>{{::mr.age + '岁'}}</span>
                <span>{{::mr.sick}}</span>
            </div>
            <div class="case-date pull-left">
                <div>{{::'入院日期：' + mr.inTime}}</div>
                <div>{{::'出院日期：' + mr.outTime}}</div>
            </div>
            <div class="pull-left">
                <div>{{::'入院科别：' + mr.inDepartment}}</div>
                <div>{{::'出院科别：' + mr.outDepartment}}</div>
            </div>
            <div class="pull-left">
                <div>{{::'入院途径：' + mr.inType}}</div>
                <div>{{::'出院方式：' + mr.outType}}</div>
            </div>
            <div class="pull-right">
                <button type="button" class="btn btn-primary" ng-click="smr.addToFavorite(mr)">添加到收藏夹</button>
                <button type="button" class="btn btn-primary" ng-click="smr.borrow(mr)">申请借阅</button>
            </div>
            <div class="address">{{::'地址：' + mr.address}}</div>
        </div>
        <cms-pagination cfg="cfg" load-page="smr.loadPageData()"></cms-pagination>
    </div>
</script>