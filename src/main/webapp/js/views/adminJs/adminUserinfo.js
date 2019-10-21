var integralModule = angular.module("adminUserinfoApp",[]);
			integralModule.controller("adminUserinfoCtrl",function($http,$scope){
				initBind($http, $scope);
				//初始化时间
				lay('#version').html('-v'+ laydate.v);
				//执行一个laydate实例
				laydate.render({
				  elem: '#uResgistdate' //指定元素
				});
 
	            
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
				$('#serchUserinfo').on('click', function () {
					createTable();
				})
				
				//修改
				$('#updateByUserinfo').on('click', function () {
					var params=getDate();
					$http({
   			            method: 'POST',
   			            url:'/mymall'+'/admin/user/updateUserinfoById',
   			            headers: {
   			                'Content-Type': 'application/x-www-form-urlencoded'
   			            },
   			            data: params,
   			            transformRequest: $scope.processParams
   			        }).success(function (result) {
   			        	result = $.parseJSON(result);
   			        	if(result.errCode='000000'){
   			        		swal("修改成功!","success");
   			        		$('#personSubCouponModal').modal('hide');
   			        		createTable();
   			        	}else{
   			        	    swal("修改失败!","error");
   			        	    createTable();
   			        	}
   			        })
				})
				
				//加载修改
				$('#table_id_example').on('click', '.update', function () {
					var uSex = document.getElementsByName("uSex")
					var params=$(this).attr('data-id');
					$.ajax({
	   	 				url:'/mymall'+'/admin/user/updateGoUserinfoById',
	   	 				data:{
	   	 			    	"uId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function (result) {
	   			        	result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		$("#uId").val(result.data.uId);
	   			        		$("#uUsernameTwo").val(result.data.uUsername);
	   			        		$("#uPassword").val(result.data.uPassword);
	   			        		$("#uMoney").val(result.data.uMoney);
	   			        		$("#uPhoneTwo").val(result.data.uPhone);
	   			        		$("#uEmail").val(result.data.uEmail);
	   			        		for(var i=0; i<uSex.length; i ++){
	   						       if(result.data.uSex==uSex[i].value){
	   						    	   uSex[i].checked=true;
	   						       }
	   						     }
	   			        		$("#uAddress").val(result.data.uAddress);
	   			        		$("#uResgistdate").val(result.data.uResgistdate);
	   			        		showModal($('#personSubCouponModal'));
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
	   	 				url:'/mymall'+'/admin/user/delUserinfoById',
	   	 				data:{
	   	 			    	"uId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function(result){
	   	 					//alert(result.errCode=='000000')
		   	 				result = $.parseJSON(result);
	   			        	if(result.errCode=='000000'){
	   			        		swal("删除成功!","success");
	   			        		createTable();
	   			        	}
	   			        	if(result.errCode=='000001'){
	   			        	 swal("没有权限!","error");
				        	    createTable();
	   			        	}
	   	 				},
		   	 			error:function(){
		   	 			    swal("没有权限!","error");
	   	 				}
	   	 			});
	   	            }) 
                });
				
				function getDate(){
					var uSexVal;
					var obj1 = document.getElementsByName("uSex");
					 for(var i=0; i<obj1.length; i ++){
					       if(obj1[i].checked){
					    	   uSexVal=obj1[i].value;
					       }
					     }
		        	return {  
					 		uId:$("#uId").val(),
		        			uUsername:$("#uUsernameTwo").val(),
		        			uPassword:$("#uPassword").val(),
		        			uMoney:$("#uMoney").val(),
		        			uPhone:$("#uPhoneTwo").val(),
		        			uEmail:$("#uEmail").val(),
		        			uSex:uSexVal,
		        			uAddress:$("#uAddress").val(),
		        			uResgistdate:new Date( $("#uResgistdate").val()),
								// $("#uResgistdate").val(),
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
					    url:'/mymall'+"/admin/user/adminUserinfoLimit",
					    dataSrc:"data",
					    data: {
					    	"uUsername":$("#uUsername").val(),
					    	"uPhone":$("#uPhone").val()
					    },
					    type:"post"
					    },
					    columns:[
					    	{ data:'uUsername'},
			 		    	{ data:'uPassword'},
					    	{ data:'uMoney'},
					    	{ data:'uPhone'},
					    	{ data:'uEmail'},
					    	{ data:'uSex'},
					    	{ data:'uAddress'},
					    	{ data:'uResgistdate'},
					    	{ data:'uId',render: function ( data, type, row ) {
			    		        return "<span  style='cursor:pointer' class='delete' data-id='"+ row.uId+ "'>删除&nbsp;&nbsp;</span>" +
									"<span style='cursor:pointer' class='update' data-id='"+ row.uId+ "'>修改</span>";
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
			