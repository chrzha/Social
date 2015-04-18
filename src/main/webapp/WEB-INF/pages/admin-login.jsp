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

		<!--/.nav-collapse -->
	</div>
	</nav>

<div style="width:400px;height:300px;margin-top:100px;margin-left:35%;">
	<h2>管理员登录</h2>
	<form class="" method="post"
		action="/data/user/admin/login">
		<div class="form-group">
			<input type="text" placeholder="Username" class="form-control"
				id="username" name="userName">
		</div>
		<div class="form-group">
			<input type="password" placeholder="Password" class="form-control"
				id="password" name="password">
		</div>
		 
				<button type="submit" class="btn btn-success">登录</button>
			 
			 
	</form>
</div>


</body>
</html>