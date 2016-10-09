angular.module("loja").controller("albumCtrl", function ($scope, $http) {
		$scope.novoAlbum = function (album) {
			$http.post("album/novo", album).success(function (resultadoDoResponse) {
				$scope.produto = resultadoDoResponse;
			});
		};		
	});
