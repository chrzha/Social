<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>USPTO页面数据抓取</title>

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
	$(document).ready(function() {
		$("#go").on('click', function() {
			alert("请登录");
			$("#username").focus();
		});
		$("#register").on('click', function() {
			 
			
		});
		$("#save").on('click', function() {
			 var username = $("#username").val();
			 var password = $("#password").val();
			 var email = $("#email").val();
			var user={};
			user.userName = username;
			user.password = password;
			user.email = email;
			$.ajax({
				type : "POST",
				url : "/data/user",
				data : user,
				dataType : "json",
				success : function(result) {
					alert(result);
				},
				error : function(result) {
					alert("error");
				}
			});
		});
		$("#cancle").on('click', function() {
			 
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
						<li><a href="/data/user/manage">管理员登录</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right" method="post" action="/data/user/login">
				<div class="form-group">
					<input type="text" placeholder="Username" class="form-control" id ="username" name="userName">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" class="form-control" id="password" name="password">
				</div>
				<button type="submit" class="btn btn-success">登录</button>
				<button type="button" class="btn btn-success" data-toggle="modal"
				href="#responsive" id="register">注册</button>
			</form>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron" id="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational
				website. It includes a large callout called a jumbotron and three
				supporting pieces of content. Use it as a starting point to create
				something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#search" role="button"
					id="go">开始 &raquo;</a>
			</p>
		</div>
	</div>
	
	<!--Add Modal-->
	<div id="responsive" class="modal fade" tabindex="-1" style="margin-top:50px;margin-left:400px;"
		data-width="200">
		 
		<div class="col-md-6">
			<div class="modal-body">
				<form id="fieldContainerForm" role="form" method="post" action="/data/user/add">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 min-modal">
						<ul class="list-group">
							<li class="list-group-item">
								<div class="input-group">
									<strong class="mylabel4">用户名</strong>
									<div id="idCtn" class="form-group myinput6">
										 <input type="text" id="tenantId" class="form-control" name="userName">
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="input-group">
									<strong class="mylabel4">邮箱</strong>
									<div id="codeCtn" class="form-group myinput6"><input type="text" id="tenantCode" name="email"
										class="form-control" placeholder="">
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="input-group">
									<strong class="mylabel4">密码</strong>
									<div id="nameCtn" class="form-group myinput6">
									<input type="password"
										class="form-control" id="tenantName" name="password" placeholder="">
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="input-group">
									<strong class="mylabel4">确认密码</strong>
									<div id="codeCtn" class="form-group myinput6">
									<input type="password" 
										class="form-control" placeholder="">
									</div>
									<div id="codeCtn" class="form-group myinput6">
									<input type="submit" value="注册" class="btn btn-default"/>
									</div>
								</div>
							</li>
							
						</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal-footer">
			<button type="button" id="tenent_cancel" data-dismiss="modal" class="btn">Cancel</button>
			<button type="button" id="tenant_add" class="btn btn-primary">Save</button>
		</div>
	</div>
	
	
	
	
</body>
</html>