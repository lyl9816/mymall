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
<title>我的积分</title>
</head>
<body ng-app="integralApp">
   <div ng-controller="integralCtrl">
    <table id="table_id_example" class="display">
		<thead>
			<tr>
				<th>积分(分)</th>
				<th>时间</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/integral.js"></script>
</html>