angular.module("mainPage", [])
.controller("MainPageController", ["$scope", function ($scope) {

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
        var sickCodesStr = "", tplChargeDiagnosis = null;

        $scope.getData = function (fdFileNo, isInit) {
            $.ajax({
                type: "get",
                //url: Com_Parameter.ContextPath + "medicalRecord/homepages/" + fdFileNo,
                url: Com_Parameter.ResPath + "/json/186121.json",
                dataType: "json",
                cache: false,
                success: function (result) {
                    var pageData = result;
                    //var pageData = result.data;
                    !pageData.payType && $.extend(pageData, defaultPageData);
                    $scope.$apply(function () {
                        $scope.page = pageData;
                        formatPageData();
                        !isInit && $("select").selectator("destroy");
                        setTimeout(function () {
                            initSelectator(".selectator");
                            initSelectivity(".selectivity");
                            initHandyOperation();
                        }, 100);
                    });
                }
            });
        };

        $scope.save = function (/*fdId, */callback) {
            if (!$scope.page.businessKey) {
                alert("病案号不能为空！");
                return;
            }
            // collect out discharge diagnosis sick codes
            angular.forEach($scope.page.dischargeDiagnosis, function (item, index) {
                if (item.diagnosis) {
                    item.sickCodes = $(".out-diagnosis tbody tr:eq(" + index + ") td:eq(1) select").val();
                }
            });
            console.log($scope.page);
            return;
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

        $scope.addNewDischargeDiagnosis = function() {
            if (!tplChargeDiagnosis) {
                tplChargeDiagnosis = $(".tpl-discharge-diagnosis-row");
            }
            $(tplChargeDiagnosis.prop('outerHTML')).insertBefore(tplChargeDiagnosis).show();
            // todo
            // init sick codes
            // init sick status
            // bind new row to page data
        };

        function formatPageData () {
            for (var i = $scope.page.dischargeDiagnosis.length; i < 3; i++) {
                $scope.page.dischargeDiagnosis.push({"diagnosis": "", "sickCode": "", "inSickState": ""})
            }
            for (var j = $scope.page.operationHistory.length; j < 10; j++) {
                $scope.page.operationHistory.push({"operateCode": "", "date": "", "grade": "", "operationName": "", "operator": "", "firstAssistant": "", "secondAssistant": "", "cutHealGrade": "", "anaesthesiaType": "", "anaesthetist": ""});
            }
        }

        function setUpWatch () {
            // todo need test
            if (!$scope.page.outDepartment) {
                var watchInDepartment = $scope.$watch('page.inDepartment', function (newVal, oldVal) {
                    if (!$scope.page.outDepartment) {
                        $scope.page.outDepartment = newVal;
                        $("#slOutDepartment").val(newVal);
                        initSelectator("#slOutDepartment");
                    }
                    watchInDepartment();
                })
            }
            // keep major discharge diagnosis same as outpatient diagnosis first time
            if (!$scope.page.dischargeDiagnosis[0].diagnosis) {
                var watchDischargeDiagnosis = $scope.$watch("page.outpatientDiagnosis", function (newVal, oldVal) {
                    if (!$scope.page.dischargeDiagnosis[0].diagnosis || ($scope.page.dischargeDiagnosis[0].diagnosis == oldVal)) {
                        $scope.page.dischargeDiagnosis[0].diagnosis = newVal;
                    } else {
                        watchDischargeDiagnosis();
                    }
                })
            }
        }

        function initHandyOperation() {
            // Set focus to next input when press enter
            var els = $(".sy-container input[type='text']");
            els.each(function (index,item) {
                $(item).on("keypress", function (event) {
                    if(event.keyCode == 13 && index < els.length - 1) {
                        els[index + 1].focus();
                    }
                })
            });

            setUpWatch();
        }

        // init selectator
        function initSelectator(el) {
            $(el).selectator({
                labels: {
                    search: '搜索'
                }
            });
        }

        // init selectivity
        function initSelectivity(el) {
            $(el).selectivity({
                multiple: true,
                selectivityBackdrop: ".bui-dialog"
            })
        }

        // generate sick codes select
        /*function getSickCodes() {
            if (!sickCodesStr) {
                sickCodesStr += '<select ng-model="d.sickCodes[1]">';
                angular.forEach($scope.settings.sickCodes, function (item, index) {
                    sickCodesStr += '<option value="' + item.id + '" searchcontent="' + item.id + '">' + item.id + '</option>'
                });
                sickCodesStr += '</select>';
            }
            return sickCodesStr;
        }

        function generateNewDischargeDiagnosis() {
            f (!newChargeDiagnosisStr) {
                newChargeDiagnosisStr += '<tr>'
                newChargeDiagnosisStr += '<td>'
                newChargeDiagnosisStr += '</td>'
                newChargeDiagnosisStr += '<td>'
                newChargeDiagnosisStr += '<tr>'
                newChargeDiagnosisStr += '<tr>'
                newChargeDiagnosisStr += '</tr>'
            }
            return newChargeDiagnosisStr;
        }*/


    }]);