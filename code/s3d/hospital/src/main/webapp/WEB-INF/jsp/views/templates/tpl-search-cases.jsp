<script type="text/ng-template" id="tplSearchCases">
    <div class="search-cases">
        <div class="btn-group">
            <button ng-repeat="i in conditions" class="btn" ng-class="{'btn-primary': i.key == searchType, 'btn-default': i.key != searchType}" ng-click="changeSearchType(i.key)">
                <span ng-bind="i.value"></span>
            </button>
        </div>
        <div>
            <input type="text" class="search form-control" ng-model="keyword">
            <button class="btn btn-primary" ng-click="search()">查询</button>
        </div>
    </div>
</script>