(function () {
    'use strict';
    angular.module('cms')
        .service('localDataService', localDataService);

    localDataService.$inject = [];

    function localDataService () {
        this.departments;

        this.setDepartments = setDepartments;
        this.getDepartments = getDepartments;

        function setDepartments (_departments) {
            this.departments = _departments;
        }

        function getDepartments () {
            return this.departments;
        }
    }



})();