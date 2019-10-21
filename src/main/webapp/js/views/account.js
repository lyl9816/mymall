

		var integralModule = angular.module("accountApp",[]);
			integralModule.controller("accountCtrl",function($scope,$http){
				createTable();
				getMoney($http,$scope);
			});
		var datatable=null;
		function createTable(){
			if(datatable!=null){
				datatable.destroy();
			}
				datatable=$('#table_id_example').DataTable({
					bLengthChange: false,
					searching: false,
				    ordering:  false,
				    language: {
				    	url: '/mymall'+'/js/china.json'
				    },
				    "aLengthMenu":[10],
				    serverSide: true,
				    ajax:{
				    url:"/mymall"+"/user/userAccountLimit",
				    dataSrc:"data",
				    type:"post"
				    },
				    columns:[
				    	{ data:'mTime'},
				    	{ data:'mType'},
				    	{ data:'mAmoney'}
				    ]
				});
		}
		
		function getMoney($http,$scope){
			 $http({
		            method: 'POST',
		            url:'/mymall'+'/user/getMoneyAcount',
		            headers: {
		                'Content-Type': 'application/x-www-form-urlencoded'
		            },
		        }).success(function (result) {
		        	$scope.momey=result;
		        })
		}