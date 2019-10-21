var integralModule = angular.module("myOrderSuccessApp",[]);
			integralModule.controller("myOrderSuccessCtrl",function($scope,$http){
				createTable();
				initBind($http, $scope);
			});
			
			
			function initBind($http, $scope) {
				$('#Detail').on('click', '.select', function () {
					var params=$(this).attr('data-id');
					createsnackTable(params);
					showModal($('#orderSnackModal'));
				});
			}
			
			var snackDatatable=null;
			function createsnackTable(oId){
				if(snackDatatable!=null){
					snackDatatable.destroy();
				}
				snackDatatable=$('#table_snack_example').DataTable({
						bLengthChange: false,
						searching: false,
					    ordering:  false,
					    language: {
					    	url: '/mymall'+'/js/china.json'
					    },
					    "aLengthMenu":[10],
					    serverSide: true,
					    ajax:{
					    url:"/mymall"+"/shop/selectOrderSnack",
					    dataSrc:"data",
					    data: {
					    	"oId":oId,
					    },
					    type:"post"
					    },
					    columns:[
							{ data:'picUrl',render: function ( data, type, row ) {
							    return "<img height='60' width='60' src='/mymall/image/"+data+"'/>";
							}},
					    	{ data:'sName'},
					    	{ data:'oMoney'},
					    	{ data:'oNum'}
					    ]
					});
			}
			
			
			
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
					    url:"/mymall"+"/user/userSucOrderLimit",
					    dataSrc:"data",
					    type:"post"
					    },
					    columns:[
					    	{ data:'oId',width:'10%'},
					    	{ data:'oName',width:'15%'},
					    	{ data:'oPhone',width:'10%'},
					    	{ data:'oAddress',width:'31%'},
					    	{ data:'oTime',width:'14%'},
					    	{ data:'oType',width:'11%',render: function ( data, type, row ) {
					    		if(data==1){
					    			return "订单完成";
					    		}
			    		    }},
					    	{ data:'id',width:'9%',render: function ( data, type, row ) {
			    		        return "<span class='select' data-id='"+ row.oId+ "'>查看</span>";
			    		    }}
					    ]
					});
			}
			
			function showModal(modal, backdrop) {
		        modal.modal({
		            backdrop: backdrop || true,
		            show: true
		        })
		    };