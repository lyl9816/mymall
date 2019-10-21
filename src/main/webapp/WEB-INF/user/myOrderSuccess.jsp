<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/libs/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libs/jquery.dataTables.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/js/libs/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/bootbox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/angular.min.js"></script>
<title>历史订单</title>
</head>
<body ng-App="myOrderSuccessApp">
<div ng-controller="myOrderSuccessCtrl">
 <table id="table_id_example" class="display">
		<thead>
			<tr>
				<th class="text-center">订单号</th>
				<th class="text-center">收货人</th>
				<th class="text-center">联系方式</th>
				<th class="text-center">地址</th>
				<th class="text-center">下单日期</th>
				<th class="text-center">状态</th>
				<th class="text-center">操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	
	<div class="modal fade" id="orderSnackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 500px; height: 300px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">用户修改</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                        <table id="table_snack_example" class="display" style="width:100%;">
							<thead>
									<tr>
										<th>图片</th>
										<th>商品名</th>
										<th>价格</th>
										<th>数量</th>
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
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/myOrderSuccess.js"></script>
</html>