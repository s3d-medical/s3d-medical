<script type="text/ng-template" id="viewMain">
    <div class="main">
        <ol ng-if="breadcrumbs && breadcrumbs.length" class="breadcrumb">
            <li ng-repeat="i in breadcrumbs" ng-class="{'active': i.active}"><a ng-if="!i.active" href="{{i.href}}">{{i.text}}</a><span ng-if="i.active" ng-bind="i.text"></span></li>
            <!--<li><a href="#">首页</a></li>
            <li><a href="#">系统管理</a></li>
            <li class="active">组织架构</li>-->
        </ol>
        <!--<div class="menu-wrap pull-left">-->
            <div id="menu" class="menu pull-left">

            </div>
        <!--</div>-->

        <div ui-view class="content pull-left"></div>
    </div>
</script>