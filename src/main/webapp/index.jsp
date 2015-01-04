<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>

<script
	src="${pageContext.request.contextPath}/webresource/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/webresource/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/webresource/css/bootstrap.min.css">
</link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/webresource/css/bootstrap-theme.min.css">
</link>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var url = "/social/images/getAll";
						$
								.ajax({
									url : url,
									dataType : "json",
									success : function(result) {
										var len = result.length;
											var active;
											var ol_active;
										for (var i = 0; i < len; i++) {
											console.log(result[0].title);
											if(i==0){
												ol_active = "active";
											}else{
												ol_active = "";
											}
											var my_ol = $("<li class='"+ol_active+"' data-slide-to='"+i+"' data-target='#my-carousel'></li>");
											my_ol.appendTo($(".carousel-indicators"));
											if(i==0){
												active = "item active";
											}else{
												active = "item";
											}
											var img = $("<div class='"+active+"'><img src='${pageContext.request.contextPath}/webresource/img/"+result[i].path+"'/><div class='carousel-caption' contenteditable='true'><h4>"
													+ result[i].title
													+ "</h4><p>"
													+ result[i].content
													+ "</p></div></div>");
											img.appendTo($(".carousel-inner"));
											
										}
									},
									error : function(result) {
										alert(result);
									}
								});

					});
</script>
</head>
<body role="document">
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WEB SITE NAME</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="carousel slide" id="my-carousel">
		<ol class="carousel-indicators"><!-- auto generate --></ol>
		<div class="carousel-inner"><!-- load from db --></div>
		<a data-slide="prev" href="#my-carousel" class="left carousel-control">‹</a>
		<a data-slide="next" href="#my-carousel"
			class="right carousel-control">›</a>
	</div>

</body>
</html>