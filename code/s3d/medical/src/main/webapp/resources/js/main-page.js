angular.module("mainPage", [])
.controller("MainPageController", ["$scope", function ($scope) {

        // test data
        $scope.settings = null;

        $scope.save = function () {
            if (!$scope.page.name) {
                alert("姓名不能为空！");
                return;
            }
            // todo use angular.toJson to convert page object instead of JSON.stringify because of useless characters created by angular automatic
            //console.log(angular.toJson($scope.page));
            console.log($scope.page);

        };
        $scope.getData = function (fdId, isInit) {
            $.ajax({
                type: "get",
                url: Com_Parameter.ResPath + "json/" + fdId + ".json",
                dataType: "json",
                cache: false,
                success: function (data) {
                    $scope.$apply(function () {
                        $scope.page = data;
                        formatPageData();
                        !isInit && $("select").selectator("destroy");
                        setTimeout(function () {
                            $("select").selectator({
                                labels: {
                                    search: '搜索'
                                }
                            });
                        }, 100);
                    });
                }
            });
        };
        function formatPageData () {
            for (var i = $scope.page.dischargeDiagnosis.length; i < 10; i++) {
                $scope.page.dischargeDiagnosis.push({"diagnosis": "", "sickCode": "", "inSickState": ""})
            }
            for (var j = $scope.page.operationHistory.length; j < 10; j++) {
                $scope.page.operationHistory.push({"operateCode": "", "date": "", "grade": "", "operationName": "", "operator": "", "firstAssistant": "", "secondAssistant": "", "cutHealGrade": "", "anaesthesiaType": "", "anaesthetist": ""});
            }
        }
        function setDefaultPage () {
            $scope.page = {
                "dischargeDiagnosis": [],
                "operationHistory": [],
                "country": "",
                "nation": "",
                "payType": 1,
                "healthCard": "",
                "hospitalizedTimes": "",
                "caseNumber": "",
                "name": "",
                "sex": 1,
                "birthdayYear": "",
                "birthdayMonth": "",
                "birthdayDay": "",
                "age": "",
                "babyAge": "",
                "babyBornWeight": "",
                "babyHospitalizedWeight": "",
                "bornState": "",
                "bornCity": "",
                "bornDistrict": "",
                "hometownState": "",
                "hometownCity": "",
                "idCard": "",
                "job": "",
                "marriage": "",
                "addressState": "",
                "addressCity": "",
                "addressDistrict": "",
                "addressPhone": "",
                "addressPostcode": "",
                "residencePostcode": "",
                "residenceDistrict": "",
                "residenceCity": "",
                "residenceState": "",
                "workPlaceAddress": "",
                "workPlacePhone": "",
                "workPlacePostcode": "",
                "contact": "",
                "relationship": "",
                "contactPhone": "",
                "contactAddress": "",
                "inType": "",
                "inYear": "",
                "inMonth": "",
                "inDay": "",
                "inHour": "",
                "inDepartment": "",
                "inSickroom": "",
                "changeDepartment": "",
                "outYear": "",
                "outMonth": "",
                "outDay": "",
                "outHour": "",
                "outDepartment": "",
                "outSickroom": "",
                "daysInHospital": "",
                "outpatientDiagnosis": "",
                "outpatientSickCode": "",
                "outCause": "",
                "outSickCode": "",
                "pathologyDiagnosis": "",
                "pathologySickCode": "",
                "pathologyNumber": "",
                "allergicMedication": "",
                "medicalAllergy": 1,
                "autopsy": 1,
                "bloodType": 1,
                "rh": 1,
                "director": "",
                "primaryNurse": "",
                "refresherDoctor": "",
                "deputyDirector": "",
                "intern": "",
                "attendingDoctor": "",
                "coder": "",
                "residentDoctor": "",
                "caseQuality": 1,
                "qualityDoctor": "",
                "qualityNurse": "",
                "qualityYear": "",
                "qualityMonth": "",
                "qualityDay": "",
                "outType": "",
                "acceptOrganization": "",
                "willReturn": 1,
                "returnPurpose": "",
                "comaDayBeforeHospital": "",
                "comaHourBeforeHospital": "",
                "comaMinuteBeforeHospital": "",
                "comaDayAfterHospital": "",
                "comaHourAfterHospital": "",
                "comaMinuteAfterHospital": "",
                "expenseTotal": "",
                "expensePersonal": "",
                "expenseNormalMedicalService": "",
                "expenseNormalCureOperating": "",
                "expenseNormalNurse": "",
                "expenseNormalOther": "",
                "expenseDiagnosisPathology": "",
                "expenseDiagnosisLab": "",
                "expenseDiagnosisImaging": "",
                "expenseDiagnosisClinical": "",
                "expenseCureNonOperation": "",
                "expenseCureClinicalPhysics": "",
                "expenseCureOperationCure": "",
                "expenseCureAnaesthesia": "",
                "expenseCureOperation": "",
                "expenseRecovery": "",
                "expenseChineseMedicineCure": "",
                "expenseWesternMedicineMedication": "",
                "expenseWesternMedicineAntibiosisMedication": "",
                "expenseChineseMedicinePatentDrag": "",
                "expenseChineseMedicineHerb": "",
                "expenseBlood": "",
                "expenseBloodAlbumin": "",
                "expenseBloodGlobulin": "",
                "expenseBloodCoagulationFactor": "",
                "expenseBloodCellFactor": "",
                "expenseConsumptionExamine": "",
                "expenseConsumptionCure": "",
                "expenseConsumptionOperation": "",
                "expenseOther": ""
            }

            for (var i = 0; i < 10; i++) {
                $scope.page.dischargeDiagnosis.push({
                    "diagnosis": "",
                    "sickCode": "",
                    "inSickState": ""
                });
                $scope.page.operationHistory.push({
                    "operateCode": "",
                    "date": "",
                    "grade": "",
                    "operationName": "",
                    "operator": "",
                    "firstAssistant": "",
                    "secondAssistant": "",
                    "cutHealGrade": "",
                    "anaesthesiaType": "",
                    "anaesthetist": ""
                });
            }
        }
    }]);