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
			<a class="navbar-brand" href="#">Bootstrap theme</a>
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
		<ol class="carousel-indicators">
			<li class="" data-slide-to="0" data-target="#my-carousel"></li>
			<li data-slide-to="1" data-target="#my-carousel" class=""></li>
			<li data-slide-to="2" data-target="#my-carousel" class="active"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item">
				<img alt="" src="${pageContext.request.contextPath}/webresource/img/1.jpg">
				<div class="carousel-caption" contenteditable="true">
					<h4>棒球</h4>
					<p>棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。</p>
				</div>
			</div>
			<div class="item">
				<img alt="" src="${pageContext.request.contextPath}/webresource/img/2.jpg">
				<div class="carousel-caption" contenteditable="true">
					<h4>冲浪</h4>
					<p>冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。</p>
				</div>
			</div>
			<div class="item active">
				<img alt="" src="${pageContext.request.contextPath}/webresource/img/3.jpg">
				<div class="carousel-caption" contenteditable="true">
					<h4>自行车</h4>
					<p>以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
				</div>
			</div>
		</div>
		<a data-slide="prev" href="#my-carousel"
			class="left carousel-control">‹</a> <a data-slide="next"
			href="#my-carousel" class="right carousel-control">›</a>
	</div>

</body>
</html>