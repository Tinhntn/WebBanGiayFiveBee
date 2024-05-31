let myApp = angular.module('myApp',['ngRoute']);

myApp.config(function ($routeProvider){
    $routeProvider
        .when(
            '/home',
            {
                templateUrl:'views/index.jsp',
                controller: 'mainController'
            }
        )
        .when(
            '/hoa-don',
            {
                templateUrl:'views/hoadon.jsp',
                controller: 'HoaDonController'
            }
        );
});
