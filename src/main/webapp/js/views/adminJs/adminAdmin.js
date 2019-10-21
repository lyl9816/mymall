var integralModule = angular.module("adminAdminApp",[]);
			integralModule.controller("adminAdminCtrl",function($http,$scope){
				initBind($http, $scope);
				$scope.processParams = function (data) {
                    var params = [];
                    for (var p in data) {
                        if (data.hasOwnProperty(p)) {
                            params.push(p + '=' + encodeURIComponent(data[p]));
                        }
                    }
                    return params.join('&');
                };
                
			});
			function initBind($http, $scope) {
				createTable();
				
				//搜索
				$('#serchAdmin').on('click', function () {
					createTable();
				})
				
				//加载新建
				$('#newAdmin').on('click', function () {
					showModal($('#newAdminModal'));
				})
				
				//新建
				$('#addAdmin').on('click', function () {
					var params=getDateNew();
					$.ajax({
	   	 				url:'/mymall'+'/admin/user/addNewAdmin',
	   	 				data:params,
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function (result) {
		   	 				result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		swal("新建成功!","success");
	   			        		$('#newAdminModal').modal('hide');
	   			        		createTable();
	   			        	    document.getElementById("adminForm").reset();
	   			        	}else{
	   			        	    swal("新建失败!","error");
	   			        	    createTable();
	   			        	    document.getElementById("adminForm").reset();
	   			        	}
	   			        },
		   	 			error:function(){
		   	 				swal("没有权限!","error");
		 				}
	   	 			});
				})
				
				//修改
				$('#updateAdmin').on('click', function () {
					var params=getDate();
					$http({
   			            method: 'POST',
   			            url:'/mymall'+'/admin/user/updateAdminById',
   			            headers: {
   			                'Content-Type': 'application/x-www-form-urlencoded'
   			            },
   			            data: params,
   			            transformRequest: $scope.processParams
   			        }).success(function (result) {
   			        	result = $.parseJSON(result);
   			        	if(result.errCode='000000'){
   			        		swal("修改成功!","success");
   			        		$('#updateAdminModal').modal('hide');
   			        		createTable();
   			        	}else{
   			        	    swal("修改失败!","error");
   			        	    createTable();
   			        	}
   			        })
				})
				
				//加载修改
				$('#table_id_example').on('click', '.update', function () {
					var params=$(this).attr('data-id');
					$.ajax({
	   	 				url:'/mymall'+'/admin/user/updateGoAdminById',
	   	 				data:{
	   	 			    	"adId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function (result) {
	   	 				result = $.parseJSON(result);
   			        	if(result.errCode='000000'){
   			        		$("#adIdTwo").val(result.data.adId);
   			        		$("#adPasswordTwo").val(result.data.adPassword);
   			        		$("#adUsernameTwo").val(result.data.adUsername);
   			        		if(result.data.roleId==1){
   			        			$("#roleIdTwo").append("<option value='1'>超级管理员</option>")
   			        			$("#roleIdTwo").attr("disabled",true);
   			        			$(".selector").find("option:contains('超级管理员')").attr("selected",true);
   			        		}else if(result.data.roleId==2){
   			        			$("#roleIdTwo").attr("disabled",false);
   			        			$("#roleIdTwo").find("option:contains('超级管理员')").remove();
   			        			$(".selector").find("option:contains('普通管理员')").attr("selected",true);
   			        		}else{
   			        			$("#roleIdTwo").attr("disabled",false);
   			        			$("#roleIdTwo").find("option:contains('超级管理员')").remove();
   			        			$(".selector").find("option:contains('小角色')").attr("selected",true);
   			        		}
   			        		showModal($('#updateAdminModal'));
   			        		}
	   			        },
		   	 			error:function(){
		   	 				swal("没有权限!","error");
		 				}
	   	 			});
				})
				
				
				//删除
				$('#table_id_example').on('click', '.delete', function () {
					var params=$(this).attr('data-id');
					swal({
	   	                title: "确定删除？",
	   	                type: "warning",
	   	                showCancelButton: true, 
	   	                confirmButtonColor: "#DD6B55",
	   	                confirmButtonText: "确定", 
	   	                cancelButtonText: "取消",
	   	                closeOnConfirm: false,
	   	            },function(){
	   	            	$.ajax({
	   	 				url:'/mymall'+'/admin/user/delAdminById',
	   	 				data:{
	   	 			    	"adId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function(result){
	   	 				result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		swal("删除成功!","success");
	   			        		createTable();
	   			        	}
	   			        	if(result.errCode='000001'){
	   			        	    swal("删除失败!","error");
	   			        	    createTable();
	   			        	}
	   	 				},
		   	 			error:function(){
		   	 			    swal("没有权限!","error");
	   	 				}
	   	 			});
	   	            }) 
                });
				
				function getDateNew(){
		        	return {  
		        			adUsername:$("#adUsernameOne").val(),
		        			adPassword:$("#adPasswordOne").val(),
		        			roleId:$("#roleIdOne").val()
		        		} 
		          }
				
				function getDate(){
		        	return {  
		        			adId:$("#adIdTwo").val(),
		        			adUsername:$("#adUsernameTwo").val(),
		        			adPassword:$("#adPasswordTwo").val(),
		        			roleId:$("#roleIdTwo").val(),
		        			roleName:$scope.roleName,
		        			roleInfo:$scope.roleInfo
		        		} 
		          }
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
					    url:"/mymall"+"/admin/user/adminAdminLimit",
					    dataSrc:"data",
					    data: {
					    	"adUsername":$("#adUsername").val(),
					    	"roleName":$("#roleName").val()
					    },
					    type:"post"
					    },
					    columns:[
					    	{ data:'adUsername'},
			 		    	{ data:'adPassword'},
					    	{ data:'roleName'},
					    	{ data:'roleInfo'},
					    	{ data:'adId',render: function ( data, type, row ) {
			    		        return "<span style='cursor:pointer' class='delete' data-id='"+ row.adId+ "'>删除&nbsp;&nbsp;</span><span  style='cursor:pointer' class='update' data-id='"+ row.adId+ "'>修改</span>";
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
			