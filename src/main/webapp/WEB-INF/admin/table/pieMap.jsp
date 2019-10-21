<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/libs/dataTimeCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/libs/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/laydate.js"></script>
<script src="${pageContext.request.contextPath}/js/libs/angular.min.js"></script>
<title>饼图</title>
</head>
<body ng-App="adminPieMapApp"  ng-controller="adminPieMapCtrl"  style="height:100%; margin: 0">
     搜索日期范围:<input class="text-center" type="text" class="demo-input" id="startDate">
                                        -<input class="text-center" type="text" class="demo-input" id="endDate">
                          <button id="serchAdminPieMap">搜索</button>
  		<div id="container" style="height:500px"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/adminPieMap.js"></script>
</html>