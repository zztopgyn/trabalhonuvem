angular.module("loja").config(function ($routeProvider) {
	$routeProvider.when("/album", {
		templateUrl: "album.html",
		controller: "albumCtrl"
	});
	$routeProvider.when("/artista", {
		templateUrl: "artista.html",
		controller: "artistaCtrl"
	});
	$routeProvider.otherwise({redirectTo: "/album"});
});
