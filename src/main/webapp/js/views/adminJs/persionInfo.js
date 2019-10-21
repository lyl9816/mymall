	

$(document).ready(function(){
	$.ajax({
			url:'/mymall'+'/user/mainSelectAdminuser',
			type:'post',
			dataType:"json",
			success: function (result) {
	        	result = $.parseJSON(result);
	        	if(result.errCode='000000'){
	        		$("#adId").val(result.data.adId);
	        		$("#adUsername").val(result.data.adUsername);
	        		$("#adPassword").val(result.data.adPassword);
	        		$("#roleIdT").val(result.data.roleId);
	        		if(result.data.roleId==1){
	        			$("#roleId").val("超级管理员");
	        		}else if(result.data.roleId==2){
	        			$("#roleId").val("普通管理员");
	        		}else{
	        			$("#roleId").val("小角色");
	        		}
	        	}
	        }
		});
	
	$("#changeAdminUser").on('click',function(){
		$.ajax({
			url:'/mymall'+'/user/mainUpdateAdminuser',
			data:{
				"adId":$("#adId").val(),
				"adUsername":$("#adUsername").val(),
				"adPassword":$("#adPassword").val(),
				"roleId":$("#roleIdT").val()
			},
			type:'post',
			dataType:"json",
			success: function (result) {
	        	result = $.parseJSON(result);
	        	if(result.errCode='000000'){
	        		swal('修改成功','success');
	        		$("#adUsername").val($("#adUsername").val());
	        		$("#adPassword").val($("#adPassword").val());
	        	}
	        }
		});
	})
	
	
	
	})