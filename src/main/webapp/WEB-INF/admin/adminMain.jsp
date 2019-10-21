<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
   <title>后台管理</title>
   <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminCss/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminCss/icon.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminCss/demo.css" type="text/css"/>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/libs/jquery.min.js"></script>
    <!-- 引入EasyUI -->
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/libs/jquery.easyui.min.js"></script>
     <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/libs/easyui-lang-zh_CN.js"></script>
     <script src="${pageContext.request.contextPath}/js/libs/angular.min.js"></script>
  </head>
  <body class="easyui-layout" ng-App="adminMainApp" ng-controller="adminMainCtrl">
	<div data-options="region:'north'" style="height:100px;text-align: center;">
	       <span style="font-size:50px;" >食尚零食管理系统</span>
	      <div style="font-size: 15px;position:absolute; right:0; bottom:0;">
			<span>欢迎:${sessionScope.adminName}</span>|
			<span id="loginOut" style="cursor:pointer">[退出]</span>
		  </div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单栏'" style="width:150px;padding:10px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <c:forEach items="${adminMenu}" var="list">
                <div title="${list.menuName }" data-options="selected:true">
                    <div style="margin: 5px">
                        <ul class="tree easyui-tree" data-options="animate:true,lines:true">
                            <c:forEach items="${adminMenuChild}" var="listChild">
                                <c:if test="${listChild.parentid==list.id}">
                                    <li data-options="iconCls:'icon-group_add'">
                                        <a style="text-decoration:none;" href="${pageContext.request.contextPath}${listChild.childMenuUrl}" target="center">
                                            <span>${listChild.childMenuName}</span></a>
                                    </li>
                                </c:if>
                            </c:forEach>

				    </ul>
				  </div>
				</div>
			</c:forEach>
		</div>
    </div>
	<div data-options="region:'center',title:'内容'"><iframe frameborder="0" height="100%" width="100%" scrolling="no" name="center"></iframe></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/adminMain.js"></script>
</html>
