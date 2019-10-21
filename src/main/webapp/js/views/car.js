var nameflag = false;
var phoneflag = false;
var addressflag = false;
var integralModule = angular.module("carApp",[]);
	integralModule.controller("carCtrl",function($scope,$http){
		 initBind($http, $scope);
		 yanzheng();
		 
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
		
		$('#submit').on('click', function () {
			if($("#headerLogin").text().trim().indexOf("登录") != -1){
				swal({
	                title: "您还未登录",
	                type: "info",
	                showCancelButton: true,
	                cancelButtonText: "取消",
	                confirmButtonText: "登录",
	                closeOnConfirm: false,
	                closeOnCancel: true,
	                showLoaderOnConfirm: true
	            },
	            function(){location.href="/mymall/shop/userLoginGet";});
			}else{
				document.getElementById("subBottom").style.display="none";
				document.getElementById("carinfo").style.display="block";
		}
        });
		
		
		$('#subCarButton').on('click', function () {
			var date=getData();
			if(nameflag && phoneflag && addressflag){
				$.ajax({
   	 				url:'/mymall'+'/sorder/setOrder',
   	 				data:date,
   	 				type:'post',
   	 				dataType:"json",
   	 				success: function(result){
	   	 				result = $.parseJSON(result);
	   	 				result.data=$.parseJSON(result.data);
   			        	if(result.errCode='000000'){
   			        		$("#oName").attr("disabled","disabled");
   			        		$("#oPhone").attr("disabled","disabled");
   			        		$("#oAddress").attr("disabled","disabled");
   			        		document.getElementById('subCarButton').style.display='none';
   			        		$("#payNumber").val(result.data.payMoney);
			        		$("#uMoney").val(result.data.uMoney);
			        		$("#payoId").val(result.data.oId);
			        		document.getElementById('tablePayExample').style.display='block';
   			        	}
   	 				}
   	 			});
			}else{
				swal({
	                title: "请填写收货信息",
	                type: "info",
	                confirmButtonText: "确定",
	                closeOnConfirm: false,
	                closeOnCancel: true,
	                showLoaderOnConfirm: true
	            })
			}
		});

		
		//支付
		$('#comfirPay').on('click', function () {
			if($("#uMoney").val()-$("#payNumber").val()>=0){
			if($("#uPasword").val()!=''){
				$.ajax({
   	 				url:'/mymall'+'/user/userOrderPayMoneyConfirm',
   	 				data:{
   	 			    	"payNumber":$("#payNumber").val(),
   	 			    	"uMoney":$("#uMoney").val(),
   	 			    	"uPasword":$("#uPasword").val(),
   	 			    	"oId":$("#payoId").val()
   	 			    },
   	 				type:'post',
   	 				dataType:"json",
   	 				success: function(result){
	   	 				result = $.parseJSON(result);
   			        	if(result.errCode=='000000'){
   			        		swal("支付成功!","success");
   			        		swal({ 
   			        		  title: "支付成功!", 
   			        		  type: "success",
   			        		  confirmButtonColor: "#DD6B55",
   			        		  confirmButtonText: "确定", 
   			        		  closeOnConfirm: false
   			        		},
   			        		function(){
   			        			location.href="/mymall"+"/shop/index";
   			        		});
   			        	}else if(result.errCode=='000001'){
   			        		swal("请输入正确的密码!");
   			        	}
   	 				}
   	 			});
			}else{
				swal("请输入支付密码!");
			}
			}else{
				swal("您的钱包余额不足!");
			}
		});
			
		
	}
	
	function getData(){
		return {
			oName: $('#oName').val(),
			oPhone: $('#oPhone').val(),
            oAddress:$('#oAddress').val()
		};
	}
	
	function yanzheng(){
		$("#oName").blur(function(e){
			
			if($("#oName").val()==null || $("#oName").val()==""){
				
				$("#namemsg").text("收件人不能为空");	
				nameflag = false;					
				
			}else{
				
				$("#namemsg").text("");	
				nameflag = true;
			}
																		
		});	
		
		$("#oPhone").blur(function(e){
			
			var reg = /^(\d{2,4}[-])?1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/;
			
			if($("#oPhone").val()==null || $("#oPhone").val()==""){
				
				$("#phonemsg").text("电话不能为空");	
				phoneflag = false;					
				
			}else if(!reg.test($("#oPhone").val())){
				
				$("#phonemsg").text("电话格式不正确");
			}else{
				
				$("#phonemsg").text("");	
				phoneflag = true;
			}
																		
		});	
		
		$("#oAddress").blur(function(e){
			
			if($("#oAddress").val()==null || $("#oAddress").val()==""){
				
				$("#addressmsg").text("收货地址不能为空");	
				addressflag = false;					
				
			}else{
				
				$("#addressmsg").text("");	
				addressflag = true;
			}
																		
		});	
	}
	
	
	function showMsg(msg,type) {
        swal({
            title: msg,
            type: type,
            showCancelButton: false,
            confirmButtonColor: "#DD6B55",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            closeOnCancel: true
        })
    }
