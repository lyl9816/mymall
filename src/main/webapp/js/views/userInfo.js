/**
 * 
 */
		var uUserflag = false;
		var passflag = false;
		var emailflag = false;
		var uRealflag= false;
		var uPhoneflag=false;
		var sexflag=false;
		var sex;
		var filter  = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		var hm=/^1[3|4|5|7|8][0-9]{9}$/;

$(document).ready(function(){
	
	//查询登录用户
		$.ajax({
			url:"readUserinfo",
			data:{
		    	"uId":$("#uid").val()
		    },
			type:'post',
			dataType:"json",
			success: function(msg){	
				if(msg.tag!=null){
					$("#uUsername").val(msg.tag.uUsername);
					$("#uPassword").val(msg.tag.uPassword);
					$("#uEmail").val(msg.tag.uEmail);
					$("#uAddress").val(msg.tag.uAddress);
					$("#uPhone").val(msg.tag.uPhone);
					$("#uRealname").val(msg.tag.uRealname);
					if(msg.tag.uSex=="男"){
						$("#man").attr("checked",true);
					}else{
						$("#woman").attr("checked",true);
					}
				}
			}
		});
	
	
	
	$("input[name='sex']").bind("click",function(){
		var obj1 = document.getElementsByName("sex");
		 for(var i=0; i<obj1.length; i ++){
		       if(obj1[i].checked){
		    	   sex=obj1[i].value;
		    	   sexflag=true;
		       }
		     }
		 if(sexflag){
			 $("#sexmsg").text("");
		 }else{
			 $("#sexmsg").text("请选择性别");
		 }
	    });


	
	$("#uUsername").blur(function(){	
		if($("#uUsername").val()==null || $("#uUsername").val()==""){						
			$("#msg").text("用户名不能为空");
		}else{
			$.ajax({
				url:"selectUserOne",
				data:{
			    	"uUsername":$("#uUsername").val()
			    },
				type:'post',
				dataType:"json",
				success: function(msg){	
					if(msg.tag==null || msg.tag.uId==$("#uid").val()){
						$("#msg").text("");
						uUserflag = true;
					}else{
						$("#msg").text("用户名已存在！");
						uUserflag = false;
					}
				}
			});
		}																	
    });	
	$("#uPassword").blur(function(){
		if($("#uPassword").val()==null || $("#uPassword").val()==""){
			$("#passmsg").text("密码不能为空");	
			 passflag = false;					
		}else{
			$("#passmsg").text("");	
			 passflag = true;
		}
	});	
	$("#uEmail").blur(function(){
		if($("#uEmail").val()==null || $("#uEmail").val()==""){
			$("#emailmsg").text("邮箱不能为空");		
			emailflag = false;				
		}else if(!filter.test($("#uEmail").val())){
			$("#emailmsg").text("邮箱格式不正确");	
			emailflag = false;
		}else{
			$("#emailmsg").text("");
			emailflag = true;		
		}
	});
	$("#uRealname").blur(function(){
		if($("#uRealname").val()==null || $("#uRealname").val()==""){
			$("#uRealnamemsg").text("姓名不能为空");	
			uRealflag = false;					
		}else{
			$("#uRealnamemsg").text("");	
			uRealflag = true;
		}
	});
	$("#uPhone").blur(function(){
		if($("#uPhone").val()==null || $("#uPhone").val()==""){
			$("#uPhonemsg").text("联系方式不能为空");		
			uPhoneflag = false;				
		}else if(!hm.test($("#uPhone").val())){
			$("#uPhonemsg").text("联系方式格式不正确");	
			uPhoneflag = false;
		}else{
			$("#uPhonemsg").text("");
			uPhoneflag = true;		
		}
	});
	
	
	$("#editbtn").click(function(){
		if($("#uUsername").val()==null || $("#uUsername").val()==""){						
			$("#msg").text("用户名不能为空");
			uUserflag=false;
		}else{
			$.ajax({
				url:"selectUserOne",
				data:{
			    	"uUsername":$("#uUsername").val()
			    },
				type:'post',
				dataType:"json",
				success: function(msg){	
					if(msg.tag==null || msg.tag.uId==$("#uid").val()){
						$("#msg").text("");
						uUserflag = true;
						yz();
					}else{
						$("#msg").text("用户名已存在！");
						uUserflag = false;
					}
				}
			});
		}
	function yz(){
		if($("#uPassword").val()==null || $("#uPassword").val()==""){
			$("#passmsg").text("密码不能为空");	
			 passflag = false;					
		}else{
			$("#passmsg").text("");	
			 passflag = true;
		}
		
		if($("#uEmail").val()==null || $("#uEmail").val()==""){
			$("#emailmsg").text("邮箱不能为空");		
			emailflag = false;				
		}else if(!filter.test($("#uEmail").val())){
			$("#emailmsg").text("邮箱格式不正确");	
			emailflag = false;
		}else{
			$("#emailmsg").text("");
			emailflag = true;		
		}
		
		if($("#uRealname").val()==null || $("#uRealname").val()==""){
			$("#uRealnamemsg").text("姓名不能为空");	
			uRealflag = false;					
		}else{
			$("#uRealnamemsg").text("");	
			uRealflag = true;
		}
		
		if($("#uPhone").val()==null || $("#uPhone").val()==""){
			$("#uPhonemsg").text("联系方式不能为空");		
			uPhoneflag = false;				
		}else if(!hm.test($("#uPhone").val())){
			$("#uPhonemsg").text("联系方式格式不正确");	
			uPhoneflag = false;
		}else{
			$("#uPhonemsg").text("");
			uPhoneflag = true;		
		}
		
		var obj1 = document.getElementsByName("sex");
		 for(var i=0; i<obj1.length; i ++){
		       if(obj1[i].checked){
		    	   sex=obj1[i].value;
		    	   sexflag=true;
		       }
		     }
		 if(sexflag){
			 $("#sexmsg").text("");
		 }else{
			 $("#sexmsg").text("请选择性别");
		 }
		if(uUserflag==true && passflag==true && emailflag==true && uRealflag==true && uPhoneflag==true && sexflag==true){
			$.ajax({
				url:"editUserinfo",
				data:{
					"uId":$("#uid").val(),
			    	"uUsername":$("#uUsername").val(),
			    	"uPassword":$("#uPassword").val(),
			    	"uPhone":$("#uPhone").val(),
			    	"uEmail":$("#uEmail").val(),
			    	"uRealname":$("#uRealname").val(),
			    	"uSex":sex,
			    	"uAddress":$("#uAddress").val()
			    },
				type:'post',
				dataType:"json",
				success: function(msg){	
					if(msg==1){
						swal("修改成功!");
					}else{
						swal("修改失败!");
					}
				}
				});
			}
		}
	});
});
