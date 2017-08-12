angular.module('hello', []).controller('home', function ($scope, $http) {
    var self = this;


    $scope.loadData = function() {
        $http.get('resource/').then(function (response) {
            self.greeting = response.data;
        })
    }
});
