<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Crawler</title>

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
$(document).ready(function(){
	
	$('#my_submit').on('click',function(){
		var _url = "/data/catch/url";
		var para={};
		var my_url = $("#myUrl").val();
		para.url = my_url;
		 console.log(my_url);
		$.ajax({
					type : "GET",
					url : _url,
					data:para,
					dataType : "json",
					success : function(result) {
						createTable(result);
					},
					error : function(result) {
						alert("error");
					}
				});
		});

	function createTable(result){
       var tb =  $("#my_table tbody");
       tb.empty();
       var len = result.length;
		for(var i=0;i<len;i++){
			var tr = $("<tr></tr>");
			tr.append($("<td></td>").text(result[i]["patentNumber"]));
			tr.append($("<td></td>").text(result[i]["patentName"]));
			tr.append($("<td></td>").text(result[i]["ownerName"]));
			tr.append($("<td></td>").text(result[i]["fieldName"]));
			tr.append($("<td></td>").text(result[i]["abstractContent"]));
			tr.append($("<td></td>").text(result[i]["patentUrl"]));
			tb.append(tr);
		}
	}

	
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
			<a class="navbar-brand" href="#"> 页面数据抓取 </a>
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

	<div id="my-carousel">
		<div style="margin-left:30%;margin-top:40px;margin-right:30%;">
			<form class="form-inline" role="form">
			   <div class="form-group">
			      <label for="name">URL</label>
			      <input type="text" class="form-control" id="myUrl"
			         placeholder="请输入URL">
			   </div>
			   <button type="button" class="btn btn-default" id="my_submit">提交</button>
			   <button type="button" class="btn btn-default" id="advance_catch">高级爬取</button>
			</form>
		</div>
		<div style="margin-left:10%;margin-top:40px;margin-right:10%;">
		 <table class="table table-bordered table-striped" id="my_table">
				<thead>
					<tr class="txt-center">
						<th>PAT . NO</th>
						<th>Title</th>
						<th>Owner</th>
						<th>Field Name</th>
						<th>Abstract</th>
						<th>URL</th>
					</tr>
				</thead>
				<tbody>
					 
				</tbody>
			</table>
		
		</div>
	</div>

</body>
</html>