<script type="text/ng-template" id="viewMain">
    <div class="main" ng-class="{'has-menus': hasMenus}">
        <div class="header">
            <ol ng-if="breadcrumbs && breadcrumbs.length" class="breadcrumb pull-left">
                <li ng-repeat="i in breadcrumbs" ng-class="{'active': i.active}"><a ng-if="!i.active" href="{{i.href}}">{{i.text}}</a><span ng-if="i.active" ng-bind="i.text"></span></li>
            </ol>
            <ul class="theme-wrap">
                <li class="bg-blue" ng-click="mc.changeTheme('style-blue')" title="切换主题"></li>
                <li class="bg-green" ng-click="mc.changeTheme('style-green')" title="切换主题"></li>
            </ul>
        </div>
        <div id="menu" class="menu pull-left">

        </div>

        <div ui-view class="content pull-left"></div>
    </div>
</script>