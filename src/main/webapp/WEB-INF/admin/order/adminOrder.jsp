<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/libs/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libs/jquery.dataTables.css">
<link href="${pageContext.request.contextPath}/css/libs/sweetalert.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/libs/dataTimeCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/js/libs/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/bootbox.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/laydate.js"></script>
<title>后台订单</title>
</head>
<body ng-App="adminOrderApp">
   <div ng-controller="adminOrderCtrl">
        			 订单号:<input class="text-center" id="oId">
                                         操作员:<select id="adUserName">
                            <option value="">全部</option>
                           	<option value="超级管理员">超级管理员</option>  
                           	<option value="普通管理员">普通管理员</option>              
                          </select>
                                         下单日期范围:<input class="text-center" type="text" class="demo-input" id="oTimeStart">
                -<input class="text-center" type="text" class="demo-input" id="oTimeEnd">
                <button id="serchAdminOrder">搜索</button>
   		<table id="table_id_example" class="display" style="text-align: center">
		<thead>
			<tr>
				<th class="text-center">订单号</th>
				<th class="text-center">下单号</th>
				<th class="text-center">收货人</th>
				<th class="text-center">联系方式</th>
				<th class="text-center">地址</th>
				<th class="text-center">下单日期</th>
				<th class="text-center">操作员</th>
				<th class="text-center">状态</th>
				<th class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
		<div class="modal fade" id="orderSnackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 800px; height: 500px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">订单详情</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                        <input type="hidden" id="oldoId">
                        <input type="hidden" id="oldoType">
                        <table id="table_snack_example" class="display" style="width:100%;">
							<thead>
									<tr>
										<th>图片</th>
										<th>商品名</th>
										<th>价格</th>
										<th>数量</th>
										<th>操作</th>
									</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
                        </div>
                    </div>
                 </div>
			 </div>
		</div>
		
		<div class="modal fade" id="orderSnackUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 800px; height: 500px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">订单详情</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                        	<input type="hidden" id="rIdT" >
                        	收  货 人:<input type="text" id="oNameT"><br>
                        	联系方式:<input type="text" id="oPhoneT"><br>
                        	地       址:<input type="text" ID="oAddressT"><br>
                        	<button id='updateReceptinfo'>修改</button>
                        </div>
                    </div>
                 </div>
			 </div>
		</div>
		
		<div class="modal fade" id="orderdetailUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 800px; height: 500px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">商品详情</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                        	<input type="hidden" id="dId" >
                        	图片:<img height='60' width='60' id="picUrl"/><br>
                        	商品名:<input type="text" id="sName" disabled="disabled"><br>
                        	价格:<input type="text" id="oMoney"><br>
                        	数量:<input type="number" ID="oNum"><br>
                        	<button id='updateOrderDetail'>修改</button>
                        </div>
                    </div>
                 </div>
			 </div>
		</div>
	
   </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/adminOrder.js"></script>
</html>