(function () {
    angular.module('cms')
        .directive('cmsConfirm', cmsConfirm);

    cmsConfirm.$inject = ['$rootScope', '$timeout'];

    function cmsConfirm ($rootScope, $timeout) {
        return {
            restrict: 'AE',
            templateUrl: 'tplConfirm',
            replace: true,
            scope: {

            },
            link: function (scope, element, attrs) {
                $rootScope.$on('Confirm.Open', openConfirm);

                scope.onConfirm = onConfirm;
                scope.onCancel = onCancel;

                function onConfirm () {
                    scope.cfg && scope.cfg.confirm && scope.cfg.confirm();
                }

                function onCancel() {
                    scope.cfg && scope.cfg.cancel && scope.cfg.cancel();
                }

                function openConfirm (event, cfg) {
                    $timeout(function () {
                        scope.cfg = cfg;
                    }, 0);
                    element.removeClass('confirm alert').addClass(cfg.type);
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