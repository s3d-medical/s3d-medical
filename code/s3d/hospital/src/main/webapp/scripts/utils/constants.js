(function () {
    'use strict';

    var serverUrl;
    initConstants();

    angular.module('cms')
        .constant('serverUrl', serverUrl);

    /**
     * Init constants
     */
    function initConstants () {
        //service Url
        serverUrl = 'scripts/mock/';
        //serverUrl = 'http://lingchao.wicp.net';

    }

})();