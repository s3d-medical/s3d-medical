<script type="text/ng-template" id="viewHome">
    <div class="home">
        <div class="text-center"><h1><b>三明市二医院</b></h1></div>
        <div class="text-center"><h2><b>病案管理系统</b></h2></div>
        <ul class="theme-wrap">
            <li class="bg-blue" ng-click="hm.changeTheme('style-blue')" title="切换主题"></li>
            <li class="bg-green" ng-click="hm.changeTheme('style-green')" title="切换主题"></li>
        </ul>
        <%--<div class="btn-group1 form-group text-center">
            <button ng-repeat="i in hm.buttons.group1" class="btn" ng-class="{'btn-primary': i.key == hm.searchType, 'btn-default': i.key != hm.searchType}" ng-click="hm.changeSearchType(i.key)">
                <span ng-bind="i.value"></span>
            </button>
        </div>
        <div class="form-group text-center">
            <input type="text" class="search form-control">
            <button class="btn btn-primary">查询</button>
        </div>--%>
        <cms-search-cases search-type="hm.searchType" on-search-cases="hm.searchCases()"></cms-search-cases>
        <div class="btn-group2 form-group text-center">
            <button class="btn btn-primary" ng-repeat="i in hm.buttons.group2" ui-sref="{{i.key}}">
                <span ng-bind="i.value"></span>
            </button>
        </div>
        <div class="btn-group3 form-group text-center">
            <button class="btn btn-default" ng-repeat="i in hm.buttons.group3">
                <span ng-bind="i.value"></span>
            </button>
            <!--<button class="btn btn-default">科研管理</button>
            <button class="btn btn-default">随访管理</button>-->
        </div>
        <!--<div class="form-group">Copyright: xxx</div>-->
    </div>
</script>