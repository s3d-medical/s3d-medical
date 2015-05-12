angular.module("mainPage", [])
.controller("MainPageController", ["$scope", function ($scope) {

        // test data
        $scope.settings = {
            countries: [{id: "1", name: "中国", shortcut: "ZG"},{id: "2", name: "美国", shortcut: "MG"}],
            nations: [{id: "1", name: "汉族", shortcut: "HZ"},{id: "2", name: "满族", shortcut: "MZ"}],
            locations: [{id: "1", name: "江苏省", shortcut: "JS"}, {id: "2", name: "湖南省", shortcut: "HN"}, {id: "3", name: "苏州市", shortcut: "SZ"}, {id: "4", name: "长沙", shortcut: "CS"}],
            marriages: [{id: "1", name: "未婚", shortcut: "WH"}, {id: "2", name: "已婚", shortcut: "YH"}, {id: "3", name: "丧偶", shortcut: "SO"}, {id: "4", name: "离异", shortcut: "LY"}, {id: "5", name: "其他", shortcut: "QT"}],
            jobs: [{id: "1", name: "工人", shortcut: "GR"}, {id: "2", name: "农民", shortcut: "NM"}, {id: "3", name: "自由职业", shortcut: "ZYZY"}, {id: "4", name: "公务员", shortcut: "GWY"}, {id: "5", name: "其他", shortcut: "QT"}],
            relationships: [{id: "1", name: "父子", shortcut: "FZ"}, {id: "2", name: "父女", shortcut: "FN"}, {id: "3", name: "母子", shortcut: "MZ"}, {id: "4", name: "母女", shortcut: "MV"}],
            sickCodes: [{id: "E10-E14", name: "E10-E14(糖尿病)", shortcut: "TNB"}, {id: "I10.X02", name: "I10.X02(高血压)", shortcut: "GXY"}, {id: "I11.901", name: "I11.901(高血压性心脏病 NOS)", shortcut: "XZB"}, {id: "X59.952", name: "X59.952(骨折)", shortcut: "GZ"}],
            inTypes: [{id: "1", name: "门诊", shortcut: "MZ"}, {id: "2", name: "急诊", shortcut: "JZ"}, {id: "3", name: "其他医疗机构转入", shortcut: "QTYLJJZR"}, {id: "4", name: "其他", shortcut: "QT"}],
            inSickStates: [{id: "1", name: "有", shortcut: "Y"}, {id: "2", name: "临床未确定", shortcut: "LCWQD"}, {id: "3", name: "情况不明", shortcut: "QKBM"}, {id: "4", name: "无", shortcut: "W"}],
            outTypes: [{id: "1", name: "医嘱离院", shortcut: "YZLY"}, {id: "2", name: "医嘱转院", shortcut: "YZZY"}, {id: "3", name: "医嘱转社区卫生服务机构/乡镇卫生院", shortcut: "YZZSQ"}, {id: "4", name: "非医嘱离院", shortcut: "FYZLY"}, {id: "5", name: "死亡", shortcut: "SW"}, {id: "6", name: "其他", shortcut: "QT"}],
            departments: [{id: "1", name: "内科", shortcut: "NK"},{id: "2", name: "外科", shortcut: "WK"}]

        };

        setDefaultPage();





        $scope.save = function () {
            // todo use angular.toJson to convert page object instead of JSON.stringify because of useless characters created by angular automatic
            //console.log(angular.toJson($scope.page));
            console.log($scope.page);

        };
        $scope.cancel = function () {
            console.log("cancel...");
        };

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