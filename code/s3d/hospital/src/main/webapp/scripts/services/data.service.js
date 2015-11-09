(function () {
    'use strict';
    angular.module('cms')
        .service('dataService', dataService);

    dataService.$inject = ['$http', '$q', '$log', 'serviceUrl'];

    function dataService ($http, $q, $log, serviceUrl) {
        this.get = get;
        this.post = post;
        this.put = put;
        this.del = del;

        this.gets = gets;
        this.requests = requests;

        function get (api, header) {
            return request('GET', api, '', header);
        }

        function post (api, requestData, header) {
            return request('POST', api, requestData, header);
        }

        function put (api, requestData, header) {
            return request('PUT', api, requestData, header);
        }

        function del (api, header) {
            return request('DELETE', api, '', header);
        }

        function request (requestType, api, requestData, header) {
            var d = $q.defer();
            var url = serviceUrl + api;
             showLoading();
            if (header) {
                $http.defaults.headers.common = header;
            }
            $http({method: requestType, url: url, data: requestData})
                .success(function (data, status, headers, config) {
                    hideLoading();
                    d.resolve(data);
                })
                .error(function (data, status, headers, config) {
                    hideLoading();
                    $log.error("Error: ", headers);
                    d.reject(data);
                });
            return d.promise;
        }

        function gets(urls) {
            var httpArray = [];
            if(_.isArray(urls)) {
                angular.forEach(urls, function(url) {
                    this.push($http.get(serviceUrl + url));
                }, httpArray);
            } else {
                httpArray.push($http.get(serviceUrl + urls));
            }
            return requests(httpArray);
        }

        function requests(httpArray) {
            var d = $q.defer();
            showLoading();
            $q.all(httpArray).then(function (arrayOfResponses) {
                hideLoading();
                d.resolve(arrayOfResponses);
            }, function (error) {
                hideLoading();
                d.reject(error);
            });
            return d.promise;
        }
    }
})();