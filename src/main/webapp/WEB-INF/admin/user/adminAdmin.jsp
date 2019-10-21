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
<body ng-App="adminAdminApp">
		<div ng-controller="adminAdminCtrl">
		                             用户名:<input class="text-center" id="adUsername">
                                             角色名:<select id="roleName">
                               <option value="">全部</option>   
                               <option value="超级管理员">
								   超级管理员</option>
                               <option value="普通管理员">普通管理员</option>
                               <option value="小角色">小角色</option>               
                             </select>
                             <button id="serchAdmin">搜索</button>
                             <button id="newAdmin">新建</button>
			<table id="table_id_example" class="display">
				<thead>
					<tr>
						<th>用户名</th>
						<th>密码</th>
						<th>角色名</th>
						<th>角色备注</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
			
			 <div class="modal fade" id="newAdminModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 500px; height: 300px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">管理新建</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                            <form id="adminForm">
                            	<table>
                            		<tr>
                            			<td>用户名:</td>
                            			<td><input class="text-center" id="adUsernameOne"></td>
                            		</tr>
                            		<tr>
                            			<td>密码:</td>
                            			<td><input class="text-center" id="adPasswordOne"></td>
                            		</tr>
                            		<tr>
                            			<td>角色选择:</td>
                            			<td>
	                            			<select id="roleIdOne">
				                                <option value="2">普通管理员</option>
				                                <option value="3">小角色</option>                
	                            			</select>
                            			</td>
                            		</tr>
                            	</table>
                            </form>
                        </div>
                        <button id="addAdmin">新建</button>
                    </div>
                 </div>
			 </div>
		</div>
		
		<div class="modal fade" id="updateAdminModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 500px; height: 300px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">管理修改</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                            <form id="adminForm">
                            	<table>
                            		<tr>
                            			<td>用户名:<input type="hidden" id="adIdTwo"></td>
                            			<td><input class="text-center" id="adUsernameTwo"></td>
                            		</tr>
                            		<tr>
                            			<td>密码:</td>
                            			<td><input class="text-center" id="adPasswordTwo" ></td>
                            		</tr>
                            		<tr>
                            			<td>角色选择:</td>
                            			<td>
	                            			<select id="roleIdTwo" class="selector">
				                                <option value="2">普通管理员</option>
				                                <option value="3">小角色</option>  
	                            			</select>
                            			</td>
                            		</tr>
                            	</table>
                            </form>
                        </div>
                        <button id="updateAdmin">修改</button>
                    </div>
                 </div>
			 
			 </div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/adminAdmin.js"></script>
</html>