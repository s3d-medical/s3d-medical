(function () {
    'use strict';

    angular.module('cms.utils', []);
    angular.module('cms.filters', []);
    angular.module('cms.controllers', []);
    angular.module('cms.services', []);
    angular.module('cms.directives', []);

    angular.module('cms', ['ui.router', 'cms.utils', 'cms.filters', 'cms.controllers', 'cms.services', 'cms.directives'])
        .run(run);

    run.$inject = ['$rootScope', '$state'];

    function run ($rootScope, $state) {
        $rootScope.options = {
            style: 'blue',
            currentState: '',
            breadcrumbs: []
        };

        $rootScope.$on('$stateChangeSuccess', onStateChangeSuccess);

        function onStateChangeSuccess (event, toState, toParams, fromState, fromParams) {
            $rootScope.options.currentState = $state.current.name;
            //_handleBreadcrumb(fromState, toState);
        }
    }

    function _handleBreadcrumb (fromState, toState) {
        //_.remove($rootScope.options.breadcrumbs, f)
    }



})();
