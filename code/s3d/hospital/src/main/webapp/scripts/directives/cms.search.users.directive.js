(function () {
    angular.module('cms')
        .directive('cmsSearchUsers', cmsSearchUsers);

    cmsSearchUsers.$inject = ['$rootScope', '$timeout'];

    function cmsSearchUsers ($rootScope, $timeout) {
        return {
            restrict: 'AE',
            templateUrl: 'tplSearchUsers',
            replace: true,
            scope: {
                users: '=',
                onChooseUser: '&'
            },
            link: function (scope, element, attrs) {
                scope.user = undefined;

                scope.$on('SearchUsers.Open', open);

                scope.selectUser = selectUser;
                scope.onConfirm = onConfirm;
                scope.onCancel = onCancel;

                function selectUser (user) {
                    scope.user = user;
                }

                function onConfirm () {
                    scope.onChooseUser({userId: scope.user.id});
                    scope.user = undefined;
                }

                function onCancel() {
                    scope.cfg && scope.cfg.cancel && scope.cfg.cancel();
                }

                function open (event, cfg) {
                    element.modal({backdrop: 'static'});
                    element.on('hidden.bs.modal', _onClose);
                }

                function _onClose (e) {
                    $rootScope.$broadcast('Modal.Close');
                }
            }
        }
    }
})();