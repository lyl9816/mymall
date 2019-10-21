/**
 * 
 */

		var uUserflag = false;
		var passflag = false;
		var rpassflag = false;
		var emailflag = false;
		var uRealflag= false;
		var uPhoneflag=false;
		var sexflag=false;
		var sex;
		$(document).ready(function() {  
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
		});

		 	$(function(){								
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
								if(msg.tag==null){
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
				$("#rpassword").blur(function(){
					if($("#rpassword").val()==null || $("#rpassword").val()==""){
						$("#rpassmsg").text("密码不能为空");		
						rpassflag = false;				
					}else if($("#uPassword").val()!=$("#rpassword").val()){
						$("#rpassmsg").text("两次输入的密码不一致");	
						rpassflag = false;	
					}else if($("#uPassword").val()==$("#rpassword").val()){
						$("#rpassmsg").text("");	
						rpassflag = true;
					}
				});	
				$("#uEmail").blur(function(){
					var filter  = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
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
					var hm=/^1[3|4|5|7|8][0-9]{9}$/;
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
				$("#registerbtn").click(function(){
					if($("#uUsername").val()==null || $("#uUsername").val()==""){						
						$("#msg").text("用户名不能为空");
					}
					
					if($("#uPassword").val()==null || $("#uPassword").val()==""){
						$("#passmsg").text("密码不能为空");	
						 passflag = false;					
					}
					
					if($("#rpassword").val()==null || $("#rpassword").val()==""){
						$("#rpassmsg").text("密码不能为空");		
						rpassflag = false;				
					}
					
					if($("#uEmail").val()==null || $("#uEmail").val()==""){
						$("#emailmsg").text("邮箱不能为空");		
						emailflag = false;				
					}
					
					if($("#uRealname").val()==null || $("#uRealname").val()==""){
						$("#uRealnamemsg").text("姓名不能为空");	
						uRealflag = false;					
					}
					
					if($("#uPhone").val()==null || $("#uPhone").val()==""){
						$("#uPhonemsg").text("联系方式不能为空");		
						emailflag = false;				
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
					if(uUserflag==true && passflag==true && rpassflag==true && emailflag==true && uRealflag==true && uPhoneflag==true){
						$.ajax({
							url:"addUserRegister",
							data:{
						    	"uUsername":$("#uUsername").val(),
						    	"uPassword":$("#rpassword").val(),
						    	"uPhone":$("#uPhone").val(),
						    	"uEmail":$("#uEmail").val(),
						    	"uRealname":$("#uRealname").val(),
						    	"uSex":sex,
						    	"uMoney":"10000",
						    	"uAddress":$("#addr").val()
						    },
							type:'post',
							dataType:"json",
							success: function(msg){	
								if(msg.tag==1){
									alert("注册成功！");
									location.href="/mymall/shop/userLoginGet";
								}else{
									alert("注册失败！");
								}
							}
						});
					}
				});
		});
		//地图
		var map, geolocation;
		    //加载地图，调用浏览器定位服务
		    map = new AMap.Map('', {
		        resizeEnable: true
		    });
		    map.plugin('AMap.Geolocation', function() {
		        geolocation = new AMap.Geolocation({
		            enableHighAccuracy: true,//是否使用高精度定位，默认:true
		            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
		            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
		            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
		            buttonPosition:'RB'
		        });
		        map.addControl(geolocation);
		        geolocation.getCurrentPosition();
		        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
		    });
		    //解析定位结果
		    var lnglatXY;
		    function onComplete(data) {
		    	lnglatXY=[data.position.getLng(),data.position.getLat()];
		    }
		
		    function regeocoder() {  //逆地理编码
		        var geocoder = new AMap.Geocoder({
		            radius: 1000,
		            extensions: "all"
		        });        
		        geocoder.getAddress(lnglatXY, function(status, result) {
		            if (status === 'complete' && result.info === 'OK') {
		                geocoder_CallBack(result);
		            }
		        });        
		    }
		    function geocoder_CallBack(data) {
		        var address = data.regeocode.formattedAddress; //返回地址描述
		        $("#addr").val(address);
		    }