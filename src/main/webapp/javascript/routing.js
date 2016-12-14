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
var myJSON;
recipierApp.controller("analyzeController", function ($scope, $http, $location, $rootScope) {
    console.log("inside the controller");
    $scope.recipeSource = {};
    $scope.address = "";
    $scope.recipe = "";

    $scope.clear = function () {
        $scope.address = "";
        $scope.recipe = "";
    };

    $scope.analyze = function () {
        $scope.recipeSource.urlAddress= $scope.address;
        $scope.recipeSource.recipeText = $scope.recipe;

        var loadingText = document.getElementById("loadingText");
        loadingText.style="";

        $http({
            'url': "http://localhost:8090/analyze",
            'method': 'POST',
            'headers': {'Content-Type': 'application/json'},
            'data': $scope.recipeSource
        }).success(function (data) {
            $rootScope.myJSON = data;
            console.log("success");
            console.log(data);
            $location.path("/validatecomp")
        });
    };
});

recipierApp.controller('validateController', function ($scope, $http, $rootScope, $location) {


    $scope.validate = function () {
        console.log($rootScope.myJSON);

        $http({
            'url': "http://localhost:8090/validate",
            'method': 'PUT',
            'headers': {'Content-Type': 'application/json'},
            'data': $rootScope.myJSON
        }).success(function (data) {
            console.log("success");
            $location.path("/analyzecomp")
        });

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