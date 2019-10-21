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
<title>商品信息</title>
</head>
<body ng-App="adminSnackinfoApp">
 <div ng-controller="adminSnackinfoCtrl">
 		商品名:<input class="text-center" id="sName">
 		上架日期范围:<input class="text-center" type="date" class="demo-input" id="startDate">
                   -<input class="text-center" type="date" class="demo-input" id="endDate">
                类别:<select id="sType">
                <option value="">全部</option>
                <option value="膨化类">膨化类</option>
                <option value="肉制类">肉制类</option>
                <option value="饮料类">饮料类</option>
                <option value="其他">其他</option>
            </select>
                   <button id="serchAdminSnackinfo">搜索</button>
                   <button id="newAdminSnackinfo">新建</button>
 		<table id="table_id_example" class="display" style="text-align: center">
			<thead>
				<tr>
				<th class="text-center">图片</th>
				<th class="text-center">批次号</th>
				<th class="text-center">商品名</th>
				<th class="text-center">价格</th>
				<th class="text-center">折扣</th>
				<th class="text-center">生产地</th>
				<th class="text-center">数量</th>
				<th class="text-center">上架日期</th>
				<th class="text-center">生产日期</th>
				<th class="text-center">保质期</th>
				<th class="text-center">类别</th>
				<th class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
		<div class="modal fade" id="newAdminSnackinfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 800px; height: 500px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">商品上架</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
                        <form id="adminSnackinfForm">
	                        <table>
					            <tr>
					                <td>请选择图片:</td>
					                <td><input type="file" id="file"></td>
					           		 </tr>
					            <tr>
					              <td>商品名:</td>
					              <td>
					                <input type="text" id="sNameT">
					              </td>
					            </tr>
					            <tr>
						            <td>价格:</td>
						              <td>
					                	<input type="text" id="sPrice">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>折扣:</td>
						              <td>
					                	<select id="sDiscount">
					                	   <option>1</option>
					                	   <option>2</option>
					                	   <option>3</option>
					                	   <option>4</option>
					                	   <option>5</option>
					                	   <option>6</option>
					                	   <option>7</option>
					                	   <option>8</option>
					                	   <option>9</option>
					                	   <option>10</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>产地:</td>
						              <td>
					                	<input type="text" id="sPlace">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>品牌:</td>
						              <td>
					                	<input type="text" id="sBrand">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>是否进口:</td>
						              <td>
					                	<select id="sImported">
					                		<option value="0">否</option>
					                		<option value="1">是</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>生产日期:</td>
						              <td>
					                	<input type="text" id="sPdate">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>保质期:</td>
						              <td>
					                	<input type="text" id="sQdate">
						              </td>
						            </tr>
					            <tr>
					             <tr>
						            <td>数量:</td>
						              <td>
					                	<input type="text" id="sNumber">
						              </td>
						            </tr>
					            <tr>
					             <tr>
						            <td>详情:</td>
						              <td>
					                	<input type="text" id="sDese">
						              </td>
						            </tr>
						            <tr>
						            <td>是否进口:</td>
						              <td>
					                	<select id="sType">
					                		<option>肉制类</option>
					                		<option>饮料类</option>
					                		<option>膨化类</option>
					                		<option>其他</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					                <td><button id='addAdminSnackinfo'>添加</button></td>
					            </tr>
					        </table>
					        </form>
                        </div>
                    </div>
                 </div>
			 </div>
		</div>
		
		
		<div class="modal fade" id="updateAdminSnackinfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog"  style="width: 800px; height: 500px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">商品修改</h4>
                    </div>
                    <div class="clearfix" style="margin:0px 15px 0px">
                        <div class="margin-top-15">
	                        <table>
	                         <input type="hidden" id="sIdU" >
					            <tr>
					                <td>图片:</td>
					                <td>
					                <img height='60' width='60' id="picUrlU"/><br><input type="file" id="fileU"></td>
					           		 </tr>
					            <tr>
					              <td>商品名:</td>
					              <td>
					                <input type="text" id="sNameU">
					              </td>
					            </tr>
					            <tr>
						            <td>价格:</td>
						              <td>
					                	<input type="text" id="sPriceU">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>折扣:</td>
						              <td>
					                	<select id="sDiscountU">
					                	   <option>1</option>
					                	   <option>2</option>
					                	   <option>3</option>
					                	   <option>4</option>
					                	   <option>5</option>
					                	   <option>6</option>
					                	   <option>7</option>
					                	   <option>8</option>
					                	   <option>9</option>
					                	   <option>10</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>产地:</td>
						              <td>
					                	<input type="text" id="sPlaceU">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>品牌:</td>
						              <td>
					                	<input type="text" id="sBrandU">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>是否进口:</td>
						              <td>
					                	<select id="sImportedU">
					                		<option value="0">否</option>
					                		<option value="1">是</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>生产日期:</td>
						              <td>
					                	<input type="text" id="sPdateU">
						              </td>
						            </tr>
					            <tr>
					            <tr>
						            <td>保质期:</td>
						              <td>
					                	<input type="text" id="sQdateU">
						              </td>
						            </tr>
					            <tr>
					             <tr>
						            <td>数量:</td>
						              <td>
					                	<input type="text" id="sNumberU">
						              </td>
						            </tr>
					            <tr>
					             <tr>
						            <td>详情:</td>
						              <td>
					                	<input type="text" id="sDeseU">
						              </td>
						            </tr>
						            <tr>
						            <td>是否进口:</td>
						              <td>
					                	<select id="sTypeU">
					                		<option>肉制类</option>
					                		<option>饮料类</option>
					                		<option>膨化类</option>
					                		<option>其他</option>
					                	</select>
						              </td>
						            </tr>
					            <tr>
					                <td><button id='updateAdminSnackinfo'>修改</button></td>
					            </tr>
					        </table>
                        </div>
                    </div>
                 </div>
			 </div>
		</div>
 </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/adminJs/adminSnackinfo.js"></script>
</html>