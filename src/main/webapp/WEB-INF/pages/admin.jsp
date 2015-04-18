<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员</title>

<script
	src="${pageContext.request.contextPath}/webresource/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/webresource/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/webresource/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/webresource/css/bootstrap.min.css">
</link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/webresource/css/bootstrap-theme.min.css">
</link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/webresource/css/bootstrap-table.min.css">
</link>
<style type="text/css">
.cover {
	position: fixed;
	top: 0px;
	right: 0px;
	bottom: 0px;
	filter: alpha(opacity = 60);
	background-color: #777;
	z-index: 1002;
	left: 0px;
	display: none;
	opacity: 0.5;
	-moz-opacity: 0.5;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
$("#my_table").dataTable({
	
	"bPaginate": true, 
	"bLengthChange": false, 
	"bFilter": true, 
	"bSort": true,
	"bDestroy":true,
	"bRetrieve":true,
	"bInfo": true, 
	"aaSorting": [
      [ 1, "asc" ]
     ],
     "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 2 ] }]
	});
});
</script>
</head>
<body role="document">
	<!-- Fixed navbar -->
	<nav class="navbar  navbar-inverse " role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> USPTO页面数据抓取 </a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="http://www.uspto.gov/">USPTO.GOV</a></li>
				<li class="dropdown active"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">系统菜单 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">

						<li class="divider"></li>
						<li><a href="/data/user/logout">安全退出</a></li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div style="width: 80%; margin-left: 10%;">
		<table class="table table-bordered" id="my_table">
			<thead>
				<tr class="txt-center">
					<th class="txt-center">用户名</th>
					<th class="txt-center">邮箱</th>
					<th class="txt-center">状态</th>
					<th class="txt-center">编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="each" items="${userList}">
					<tr>
						<td>${each.userName}</td>
						<td>${each.email}</td>
						<td>已激活</td>
						<td><a href="/data/user/delete?userid=${each.userId}">删除</td>
					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>


</body>
</html>