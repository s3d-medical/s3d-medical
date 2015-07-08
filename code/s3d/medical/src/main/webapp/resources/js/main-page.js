(function () {
    angular.module("mainPage", ['ui.select', 'ngSanitize'])
        .controller("MainPageController", MainPageController)
        .filter('provinceFilter', provinceFilter)
        .filter('cityFilter', cityFilter)
        .filter('districtFilter', districtFilter);

    MainPageController.$inject = ["$scope", "$http"];

    function MainPageController ($scope, $http) {
        // test data
        $scope.settings = null;
        var defaultPageData = {
            "payType": 1,
            "sex": 1,
            "medicalAllergy": 1,
            "autopsy": 1,
            "bloodType": 1,
            "rh": 1,
            "caseQuality": 1,
            "willReturn": 1
        };

        $scope.getData = function (fdFileNo) {
            $http({method: 'get', url: Com_Parameter.ContextPath + "medicalRecord/homepages/" + fdFileNo})
                .success(function (resp) {
                    var pageData = resp.data;
                    !pageData.payType && $.extend(pageData, defaultPageData);
                    $scope.page = pageData;
                    formatPageData();
                    initHandyOperation();
                })
        };

        $scope.save = function (callback) {
            if (!$scope.page.businessKey) {
                alert("病案号不能为空！");
                return;
            }
            /*console.log($scope.page);
             return;*/
            // todo use angular.toJson to convert page object instead of JSON.stringify because of useless characters created by angular automatic
            //console.log(angular.toJson($scope.page));
            $.ajax({
                type: "post",
                url: Com_Parameter.ContextPath + "medicalRecord/homepages",
                dataType: "json",
                contentType: "application/json",
                data: angular.toJson($scope.page),
                cache: false,
                success: function (result) {
                    if (result.result === 'ok') {
                        //alert("保存成功！");
                        callback && callback();
                    } else {
                        alert("保存失败！");
                    }
                }
            });
        };

        // Add new discharge diagnosis
        $scope.addNewDischargeDiagnosis = function() {
            $scope.page.dischargeDiagnosis.push({});
        };

        // Add new operation history
        $scope.addNewOperationHistory = function () {
            $scope.page.operationHistory.push({});
        };

        // Format page data
        function formatPageData () {

        }

        function setUpWatch () {
            // keep out department same as in department as default
            if (!$scope.page.outDepartment) {
                var watchInDepartment = $scope.$watch('page.inDepartment', function (newVal, oldVal) {
                    if (newVal && !$scope.page.outDepartment) {
                        $scope.page.outDepartment = newVal;
                        watchInDepartment();
                    }
                })
            }
            // keep out sick room same as in sick room as default
            if (!$scope.page.outSickroom) {
                var watchInSickroom = $scope.$watch('page.inSickroom', function (newVal, oldVal) {
                    if (oldVal == $scope.page.outSickroom) {
                        $scope.page.outSickroom = newVal;
                    } else {
                        watchInSickroom();
                    }
                })
            }
            // keep major discharge diagnosis same as outpatient diagnosis first time
            /*if (!$scope.page.dischargeDiagnosis[0].diagnosis) {
             var watchDischargeDiagnosis = $scope.$watch("page.outpatientDiagnosis", function (newVal, oldVal) {
             if (!$scope.page.dischargeDiagnosis[0].diagnosis || ($scope.page.dischargeDiagnosis[0].diagnosis == oldVal)) {
             $scope.page.dischargeDiagnosis[0].diagnosis = newVal;
             } else {
             watchDischargeDiagnosis();
             }
             })
             }*/
        }

        function initHandyOperation() {
            // Set focus to next input when press enter
            var els = $(".sy input[type='text']");
            els.each(function (index,item) {
                $(item).on("keypress", function (event) {
                    if(event.keyCode == 13 && index < els.length - 1) {
                        els[index + 1].focus();
                    }
                })
            });

            setUpWatch();
        }
    }

    function provinceFilter () {
        return function (arr) {
            var outArr = [];
            angular.forEach(arr, function (item, index) {
                if(/^\d+$/.test(item.id)) {
                    outArr.push(item);
                }
            });
            return outArr;
        }
    }

    function cityFilter () {
        return function (arr, p2) {
            var outArr = [];
            angular.forEach(arr, function (item, index) {
                if (p2) {
                    if(/^\d+\.\d+$/.test(item.id) && ~item.id.indexOf(p2 + '.')) {
                        outArr.push(item);
                    }
                }
            });
            return outArr;
        }
    }

    function districtFilter () {
        return function (arr, p2) {
            var outArr = [];
            angular.forEach(arr, function (item, index) {
                if (p2) {
                    if(/^\d+\.\d+\.\d+$/.test(item.id) && ~item.id.indexOf(p2 + '.')) {
                        outArr.push(item);
                    }
                }
            });
            return outArr;
        }
    }
})();