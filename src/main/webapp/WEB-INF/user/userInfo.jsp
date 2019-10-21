<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/libs/sweetalert.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/sweetalert.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery.min.js"></script>
<style type="text/css">
     #editbtn { 
        padding:8px;  
        color: #428bca;  
        text-align: center; 
        vertical-align: middle;  
        font-weight: 900; 
        font-size:125% 
      }
     #editbtn{
        background: gold;
        border: none;
        border-radius: 40px 10px; 
        width: 85px;
        height: 37px;
    }
</style>
</head>
<body>
       <div>
	    		<%-- <table>
						<tbody>
							<tr>
								<th>
									<span class="requiredField">*</span>用户名:
								</th>
								<td>
									<input type="text" id="uid" name="uid" value="${sessionScope.frontuserId}" style="display: none;">
									<input type="text" id="uUsername" name="uUsername" class="text" maxlength="20" value="${userOne.uUsername}">
									<span style="color:red" id="msg"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="text" id="uPassword" name="uPassword" class="text" maxlength="20" autocomplete="off">
                                    <span style="color:red" id="passmsg"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>E-mail:
								</th>
								<td>
									<input type="text" id="uEmail" name="uEmail" class="text" maxlength="200">
									 <span style="color:red" id="emailmsg"></span>
								</td>
							</tr>
									<tr>
										<th>
											<span class="requiredField">*</span>姓名:
										</th>
										<td>
											<input type="text" id="uRealname" name="uRealname" class="text" maxlength="200">
											<span style="color:red" id="uRealnamemsg"></span>
										</td>
									</tr>
									
									<tr>
										<th>
											<span class="requiredField">*</span>性别:
										</th>
										<td>
											<input type="radio" id="man" name="sex" value="男"><label for="man">男</label>
											<input type="radio" id="woman" name="sex" value="女"><label for="woman">女</label>
											<span style="color:red" id="sexmsg"></span>
										</td>
									</tr>
									<tr>
										<th>
											<span class="requiredField">*</span>联系方式:
										</th>
										<td>
											<input type="text" id="uPhone" name="uPhone" class="text" maxlength="200">
											<span style="color:red" id="uPhonemsg"></span>
										</td>
									</tr>
									
									<tr>
										<th>
											<span class="requiredField">*</span>地址:
										</th>
										<td>
											<input type="text" id="uAddress" name="uAddress" class="text" maxlength="200" value="${userOne.uAddress} ">
										</td>
									</tr>
							<tr>
								<th>&nbsp;
								</th>
								<td>
									<input type="button" id="editbtn" value="确认修改" id="button">
								</td>
							</tr>
						</tbody>
					</table> --%>
					
					<table>
						<tr>
							<td>用户名:</td>
							<td><input type="text" id="uid" name="uid" value="${sessionScope.frontuserId}" style="display: none;">
									<input type="text" id="uUsername" name="uUsername" class="text" maxlength="20" value="${userOne.uUsername}">
									<span style="color:red" id="msg"></span></td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;码:</td>
							<td><input type="text" id="uPassword" name="uPassword" class="text" maxlength="20" autocomplete="off">
                                    <span style="color:red" id="passmsg"></span></td>
						</tr>
						<tr>
							<td>E-mail:</td>
							<td><input type="text" id="uEmail" name="uEmail" class="text" maxlength="200">
									 <span style="color:red" id="emailmsg"></span></td>
						</tr>
							<tr>
							<td>姓名:</td>
							<td><input type="text" id="uRealname" name="uRealname" class="text" maxlength="200">
											<span style="color:red" id="uRealnamemsg"></span></td>
						</tr>	
						<tr>
							<td>性别:</td>
							<td><input type="radio" id="man" name="sex" value="男"><label for="man">男</label>
											<input type="radio" id="woman" name="sex" value="女"><label for="woman">女</label>
											<span style="color:red" id="sexmsg"></span></td>
						</tr>
						<tr>
							<td>联系方式:</td>
							<td><input type="text" id="uPhone" name="uPhone" class="text" maxlength="200">
											<span style="color:red" id="uPhonemsg"></span></td>
						</tr>
					  <tr>
					  	<td>地址:</td>
					  	<td><input type="text" id="uAddress" name="uAddress" class="text" maxlength="200" value="${userOne.uAddress} "></td>
					  </tr>
					  <tr>
					  	<td colspan="2" align="center"><button style="margin-top: 10px" id="editbtn">确认修改</button></td>
					  </tr>
					</table>
				</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/userInfo.js"></script>
</html>