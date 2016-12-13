var recipierApp = angular.module("recipierApp", ["ngRoute"]);
recipierApp.config(function ($routeProvider) {
    $routeProvider
        .when("/analyzecomp", {
            templateUrl: "components/analyze.html",
            controller: "analyzeController"
        })
        .when("/validatecomp", {
            templateUrl: "components/validate.html",
            controller: "validateController"
        })
});

recipierApp.controller("analyzeController", function ($scope, $http, $location) {
    console.log("inside the controller");
    $scope.recipeSource = {};
    $scope.address = "";
    $scope.recipe = "";

    $scope.clear = function () {
        $scope.address = "";
        $scope.recipe = "";
    };

    $scope.analyze = function () {

        $http({
            'url': "http://localhost:8090/analyze",
            'method': 'POST',
            'headers': {'Content-Type': 'application/json'},
            'data': $scope.recipeSource
        }).success(function (data) {
            $scope.myJSON = data;
            console.log("success");
            console.log(data);
            $location.path("/validatecomp")
        });
    };
});

recipierApp.controller('validateController', function ($scope, $http) {


    $scope.validate = function () {


    };
});

function openNLP(evt, nlpName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(nlpName).style.display = "block";
    evt.currentTarget.className += " active";
}