	var integralModule = angular.module("adminSnackinfoApp",[]);
			integralModule.controller("adminSnackinfoCtrl",function($http,$scope){
				createTable();
				initBind($http, $scope);
				//初始化时间
				lay('#version').html('-v'+ laydate.v);
				//执行一个laydate实例
				laydate.render({
				  elem: '#startDate'//指定元素
				});
				laydate.render({
				  elem: '#endDate'//指定元素
				});
				laydate.render({
					elem: '#sPdate'//指定元素
				});
				laydate.render({
					elem: '#sPdateU'//指定元素
				});
			});
			function initBind($http, $scope) {
				//搜索
				$('#serchAdminSnackinfo').on('click', function () {
					createTable();
				})
				//新建
				$('#newAdminSnackinfo').on('click', function () {
					showModal($('#newAdminSnackinfoModal'));
				})
				//添加
				$('#addAdminSnackinfo').on('click', function () {
					var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
					if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
						swal("请选择图片!","warning");
						return;
					}
					var formFile = new FormData();
						formFile.append("file",fileObj); //加入文件对象
		                formFile.append("fileName",fileObj.name);  
		                formFile.append("sName",$("#sNameT").val()); 
		                formFile.append("sPrice",$("#sPrice").val()); 
		                formFile.append("sDiscount",$("#sDiscount").val()); 
		                formFile.append("sPlace",$("#sPlace").val()); 
		                formFile.append("sBrand",$("#sBrand").val()); 
		                formFile.append("sImported",$("#sImported").val()); 
		                formFile.append("sPdate",$("#sPdate").val()); 
		                formFile.append("sQdate",$("#sQdate").val()); 
		                formFile.append("sNumber",$("#sNumber").val()); 
		                formFile.append("sDese",$("#sDese").val()); 
		                formFile.append("sType",$("#sType").val());
		            var data = formFile;
		            $.ajax({
	   	 				url:'/mymall'+'/admin/snackinfo/addAdminSnack',
	   	 				data:data,
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				cache: false,//上传文件无需缓存
	                    processData: false,//用于对data参数进行序列化处理 这里必须false
	                    contentType: false, //必须
	   	 				success: function (result) {
	   	 					result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		swal("添加成功!","success");
	   			        		document.getElementById("adminSnackinfForm").reset();
	   			        		$('#newAdminSnackinfoModal').modal('hide');
	   			        		createTable();
		   			        }else{
		   			        	swal("添加失败!","error");
		   			        	document.getElementById("adminSnackinfForm").reset();
		   			        	$('#newAdminSnackinfoModal').modal('hide');
		   			        	createTable();
		   			        }
		   			    },
		   	 			error:function(){
		   	 				swal("没有权限!","error");
		 				}
	   	 			});
				})
				
				
				//加载修改
				$('#table_id_example').on('click', '.update', function () {
					var params=$(this).attr('data-id');

					$.ajax({
	   	 				url:'/mymall'+'/admin/snackinfo/selectAdminUserinfoBysId',
	   	 				data:{
	   	 			    	"sId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function (result) {
							result = $.parseJSON(result);
							//alert(result.errCode)
	   			        	if(result.errCode='000000'){
	   			        		$("#sIdU").val(result.data.sId);
	   			        		$("#picUrlU").attr('src',"/mymall/image/"+result.data.sPictureurl);
	   			        		$("#sNameU").val(result.data.sName);
	   			        		$("#sPriceU").val(result.data.sPrice);
	   			        		$("#sDiscountU").val(result.data.sDiscount);
	   			        		$("#sPlaceU").val(result.data.sPlace);
	   			        		$("#sBrandU").val(result.data.sBrand);
	   			        		$("#sImportedU").val(result.data.sImported);
	   			        		$("#sPdateU").val(result.data.sPdate);
	   			        		$("#sQdateU").val(result.data.sQdate);
	   			        		$("#sNumberU").val(result.data.sNumber);
	   			        		$("#sDeseU").val(result.data.sDese);
	   			        		$("#sTypeU").val(result.data.sType);
	   			        		showModal($('#updateAdminSnackinfoModal'));
	   			        	}
	   			        },
		   	 			error:function(){
		   	 				swal("没有权限!","error");
		 				}
	   	 			});
				})
				
				
				//更新
				$('#updateAdminSnackinfo').on('click', function () {
					//alert("aaaaaaaaaaaaaa")
					var fileObj = document.getElementById("fileU").files[0]; // js 获取文件对象
					var formFile = new FormData();
						if (typeof (fileObj) != "undefined") {
							formFile.append("file",fileObj); //加入文件对象
							formFile.append("fileName",fileObj.name); 
						}else{
							formFile.append("file","");
							formFile.append("fileName",""); 
						}
		                formFile.append("sId",$("#sIdU").val()); 
		                formFile.append("sName",$("#sNameU").val()); 
		                formFile.append("sPrice",$("#sPriceU").val()); 
		                formFile.append("sDiscount",$("#sDiscountU").val()); 
		                formFile.append("sPlace",$("#sPlaceU").val()); 
		                formFile.append("sBrand",$("#sBrandU").val()); 
		                formFile.append("sImported",$("#sImportedU").val()); 
		                formFile.append("sPdate",$("#sPdateU").val()); 
		                formFile.append("sQdate",$("#sQdateU").val()); 
		                formFile.append("sNumber",$("#sNumberU").val()); 
		                formFile.append("sDese",$("#sDeseU").val()); 
		                formFile.append("sType",$("#sTypeU").val()); 
		            var data = formFile;
		            $.ajax({
	   	 				url:'/mymall'+'/admin/snackinfo/updateAdminSnack',
	   	 				data:data,
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				cache: false,//上传文件无需缓存
	                    processData: false,//用于对data参数进行序列化处理 这里必须false
	                    contentType: false, //必须
	   	 				success: function (result) {
	   	 					//alert("bbbbbbbbbbbbbb")
	   	 				    $("#fileU").val("");
	   	 					result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		swal("修改成功!","success");
	   			        		$('#updateAdminSnackinfoModal').modal('hide');
	   			        		createTable();
		   			        }else{
		   			        	swal("修改失败!","error");
		   			        	$('#updateAdminSnackinfoModal').modal('hide');
		   			        	createTable();
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
	   	 				url:'/mymall'+'/admin/snackinfo/delAdminUserinfo',
	   	 				data:{
	   	 			    	"sId":params
	   	 			    },
	   	 				type:'post',
	   	 				dataType:"json",
	   	 				success: function(result){
		   	 				result = $.parseJSON(result);
	   			        	if(result.errCode='000000'){
	   			        		swal("删除成功!","success");
	   			        		createTable();
	   			        	}else{
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
					    "aLengthMenu":[5],
					    serverSide: true,
					    ajax:{
					    url:"/mymall"+"/admin/snackinfo/adminSnackinfoLimit",
					    dataSrc:"data",
					    data: {
					    	"sType":$("#sType").val(),
					    	"sName":$("#sName").val(),
					    	"startDate":$("#startDate").val(),
					    	"endDate":$("#endDate").val(),
					    },
					    type:"post"
					    },
					    columns:[
							{ data:'sPictureurl',render: function ( data, type, row ) {
							    return "<img height='60' width='60' src='/mymall/image/"+data+"'/>";
							}},
					    	{ data:'sBatch'},
					    	{ data:'sName'},
					    	{ data:'sPrice'},
					    	{ data:'sDiscount'},
					    	{ data:'sPlace'},
					    	{ data:'sNumber'},
					    	{ data:'sCreatedate'},
					    	{ data:'sPdate'},
					    	{ data:'sQdate'},
					    	{ data:'sType'},
					    	{ data:'sQdate',render: function ( data, type, row ) {
					    		return "<span style='cursor:pointer' class='delete' data-id='"+ row.sId +"'>删除</span>   "
					    			  +"<span style='cursor:pointer' class='update' data-id='"+ row.sId +"'>修改</span>";
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