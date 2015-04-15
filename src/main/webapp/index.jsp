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
	$(document)
			.ready(
					function() {
						//获取搜索历史的记录下拉框数据
						createSelete();
						function createSelete() {
							$
									.ajax({
										type : "GET",
										url : "/data/version",
										dataType : "json",
										success : function(result) {
											var len = result.length;
											var _slt = $("#version_select");
											$("#version_select").empty();
											for (var i = len - 1; i >= 0; i--) {
												_slt
														.append($("<option val='"+result[i]+"'>"
																+ result[i]
																+ "</option>"));
											}
										},
										error : function(result) {
											alert("error!");
										}
									});
						}

						//页面初始化时，获取最近一次搜索过的数据
						$.ajax({
							type : "GET",
							url : "/data/version",
							dataType : "json",
							success : function(result) {
								var len = result.length;
								var _url = "/data/getAllData";
								if (len > 0) {
									_url = "/data/getDataByVersion?version="
											+ result[len - 1];
								}
								$.ajax({
									type : "GET",
									url : _url,
									dataType : "json",
									success : function(result) {
										createTable(result);
									},
									error : function(result) {
										alert("error!");
									}
								});
							},
							error : function(result) {
								alert("error!");
							}
						});

						$("#go").on('click', function() {
							$("#jumbotron").hide();
							$("#search_data").show();
						});

						function showMask() {
							$("#cover").show();
						}
						function hideMask() {
							$("#cover").hide();
						}
						//高级搜索提交
						$('#advance_submit').on('click', function() {
							var _url = "/data/catch/url";
							var para = {};
							para.url = $("#myUrl").val();
							para.term1 = $("#trm1").val();
							para.field1 = $("#fld1").val();
							para.operator = $("#co1").val();
							para.term2 = $("#trm2").val();
							para.field2 = $("#fld2").val();
							showMask();
							$.ajax({
								type : "GET",
								url : _url,
								data : para,
								dataType : "json",
								success : function(result) {
									createSelete();
									createTable(result);
									hideMask();
								},
								error : function(result) {
									alert("error");
									hideMask();
								}
							});
						});

						//简单查询提交
						$('#my_submit').on('click', function() {
							var _url = "/data/catch/simpleUrl";
							var para = {};
							para.url = $("#myUrl").val();
							showMask();
							$.ajax({
								type : "GET",
								url : _url,
								data : para,
								dataType : "json",
								success : function(result) {
									createSelete();
									createTable(result);
									hideMask();
								},
								error : function(result) {
									hideMask();
									alert("error");
								}
							});
						});

						$("#advance_catch").on(
								'click',
								function() {
									url_Value = $("#myUrl").val();
									$("#my_submit").hide();
									$("#advance_cancle").show();
									$("#advance_table").show();
									$("#myUrl").val("http://patft.uspto.gov")
											.attr("readonly", true);

								});
						$("#advance_cancle").on(
								'click',
								function() {

									$("#advance_cancle").hide();
									$("#my_submit").show();
									$("#advance_table").hide();
									$("#myUrl").val("").attr("readonly", false)
											.attr("placeholder", "请输入URL");

								});

						//切换下拉框，显示不同的结果
						$("#version_select")
								.change(
										function() {
											var version = $(this).children(
													'option:selected').val();
											var _url = "/data/getDataByVersion?version="
													+ version;
											if (version === "所有记录") {
												_url = "/data/allData";
											}
											$.ajax({
												type : "GET",
												url : _url,
												dataType : "json",
												success : function(result) {
													createTable(result);
												},
												error : function(result) {
													alert("error!");
												}
											});

										});
						//下载到excel
						$("#download_btn").click(function() {

							var _url = "/data/download?fileName=patent";
							$.ajax({
								type : "GET",
								url : _url,
								success : function(result) {
									alert("success");
								},
								error : function(result) {
									alert("error!");
								}
							});
						});
						//删除指定的version记录
						$("#delete_btn")
								.click(
										function() {

											var version = $("#version_select")
													.children('option:selected')
													.val()
											var _url = "/data/deleteDataByVersion?version="
													+ version;
											if (version === "所有记录") {
												_url = "/data/deleteAllData";
											}
											if (confirm("确定要删除该组数据吗？")) {
												$.ajax({
													type : "DELETE",
													url : _url,
													success : function(result) {
														alert("success");
													},
													error : function(result) {
														alert("error!");
													}
												});
											}

										});

						//动态生成数据表格
						function createTable(result) {
							var tb = $("#my_table tbody");
							tb.empty();
							var len = result.length;
							for (var i = 0; i < len; i++) {
								var tr = $("<tr></tr>");
								tr.append($("<td></td>").text(i + 1));
								tr.append($("<td></td>").text(
										result[i]["patentNumber"]));
								tr.append($("<td></td>").text(
										result[i]["patentName"]));
								tr.append($("<td></td>").text(
										result[i]["ownerName"]));
								tr
										.append($(
												"<td title='"+result[i]["abstractContent"]+"'></td>")
												.text(
														result[i]["abstractContent"]
																.substring(0,
																		100)
																+ "..."));
								tr.append($("<td></td>").text(
										result[i]["patentUrl"]));
								tb.append(tr);
							}
						}

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
						<li><a href="#">数据备份</a></li>
						<li><a href="#">数据还原</a></li>
						<li class="divider"></li>
						<li><a href="#">清空所有记录</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" placeholder="Username" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">登录</button>
				<button type="button" class="btn btn-success">注册</button>
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

	<div id="search_data" style="display: none">
		<div style="margin-left: 10%; margin-top: 40px; margin-right: 20%;">
			<form class="form-inline" role="form" style="margin-left: 20%;">
				<div class="form-group">
					<label for="name">URL</label> <input type="text"
						class="form-control" id="myUrl" style="width: 400px;"
						placeholder="请输入URL">
				</div>
				<button type="button" class="btn btn-default" id="my_submit">提交</button>
				<button type="button" class="btn btn-default" id="advance_catch">高级爬取</button>
				<button style="display: none" type="button" class="btn btn-default"
					id="advance_cancle">取消</button>
				<button style="display: none" type="button" id="init_btn">init</button>

			</form>
			<table style="margin-top: 20px; margin-left: 15%; display: none;"
				id="advance_table">
				<tr>
					<td><STRONG><LABEL For="trm1">Term 1:</LABEL></STRONG><INPUT
						ID="trm1" TYPE="TEXT" NAME="TERM1" SIZE=25></td>
					<td align=center>in <B><LABEL For="fld1">Field 1:</LABEL></B></td>
					<td><SELECT ID="fld1" NAME="FIELD1">
							<option selected value="">All Fields</option>
							<option value="TI">Title</option>
							<option value="ABTX">Abstract</option>
							<option value="ISD">Issue Date</option>
							<option value="PN">Patent Number</option>
							<option value="APD">Application Date</option>
							<option value="AP">Application Serial Number</option>
							<option value="KD">Application Type</option>
							<option value="AANM">Applicant Name</option>
							<option value="AACI">Applicant City</option>
							<option value="AAST">Applicant State</option>
							<option value="AACO">Applicant Country</option>
							<option value="AAAT">Applicant Type</option>
							<option value="ASNM">Assignee Name</option>
							<option value="ASCI">Assignee City</option>
							<option value="ASST">Assignee State</option>
							<option value="ASCO">Assignee Country</option>
							<option value="CIPC">International Classification</option>
							<option value="CPC">Current CPC Classification</option>
							<option value="CPCL">Current CPC Classification Class</option>
							<option value="ORCL">Current US Classification</option>
							<option value="XP">Primary Examiner</option>
							<option value="XA">Assistant Examiner</option>
							<option value="INNM">Inventor Name</option>
							<option value="INCI">Inventor City</option>
							<option value="INST">Inventor State</option>
							<option value="INCO">Inventor Country</option>
							<option value="GOTX">Government Interest</option>
							<option value="LREP">Attorney or Agent</option>
							<option value="PARN">Parent Case Information</option>
							<option value="PCTA">PCT Information</option>
							<option value="PT3D">PCT 371C124 Date</option>
							<option value="PTAD">PCT Filing Date</option>
							<option value="PRFR">Foreign Priority</option>
							<option value="REIS">Reissue Data</option>
							<option value="RPAF">Reissued Patent Application Filing
								Date</option>
							<option value="RLAP">Related US App. Data</option>
							<option value="RLFD">Related Application Filing Date</option>
							<option value="PRAD">Priority Claims Date</option>
							<option value="PPPD">Prior Published Document Date</option>
							<option value="UREF">Referenced By</option>
							<option value="FREF">Foreign References</option>
							<option value="OREF">Other References</option>
							<option value="ACLM">Claim(s)</option>
							<option value="PPDB">Description/Specification</option>
							<option value="FMID">Patent Family ID</option>
							<option value="AFFF">130(b) Affirmation Flag</option>
							<option value="AFFT">130(b) Affirmation Statement</option>
							<option value="COFC">Certificate of Correction</option>
							<option value="PTC">PTAB Trial Certificate</option>
							<option value="REEX">Re-Examination Certificate</option>
							<option value="SEC">Supplemental Exam Certificate</option>
							<option value="ILRN">International Registration Number</option>
							<option value="ILRD">International Registration Date</option>
							<option value="ILFD">International Filing Date</option>
							<option value="ILPD">International Registration
								Publication Date</option>
					</SELECT></td>
				</tr>
				<tr>
					<td></td>
					<td align=middle><SELECT NAME="co1" ID="co1"
						title="Boolean Operator">
							<OPTION value="AND" SELECTED>AND</option>
							<OPTION value="OR">OR</option>
							<OPTION value="NOT">ANDNOT</option>
					</select></td>
				</tr>
				<tr>
					<td><STRONG><LABEL For="trm2">Term 2:</LABEL></STRONG><INPUT
						ID="trm2" TYPE="TEXT" NAME="TERM2" SIZE=25></td>
					<td align=center>in <B><LABEL For="fld2">Field 2:</LABEL></B></td>
					<td><SELECT ID="fld2" NAME="FIELD2">
							<option selected value="">All Fields</option>
							<option value="TI">Title</option>
							<option value="ABTX">Abstract</option>
							<option value="ISD">Issue Date</option>
							<option value="PN">Patent Number</option>
							<option value="APD">Application Date</option>
							<option value="AP">Application Serial Number</option>
							<option value="KD">Application Type</option>
							<option value="AANM">Applicant Name</option>
							<option value="AACI">Applicant City</option>
							<option value="AAST">Applicant State</option>
							<option value="AACO">Applicant Country</option>
							<option value="AAAT">Applicant Type</option>
							<option value="ASNM">Assignee Name</option>
							<option value="ASCI">Assignee City</option>
							<option value="ASST">Assignee State</option>
							<option value="ASCO">Assignee Country</option>
							<option value="CIPC">International Classification</option>
							<option value="CPC">Current CPC Classification</option>
							<option value="CPCL">Current CPC Classification Class</option>
							<option value="ORCL">Current US Classification</option>
							<option value="XP">Primary Examiner</option>
							<option value="XA">Assistant Examiner</option>
							<option value="INNM">Inventor Name</option>
							<option value="INCI">Inventor City</option>
							<option value="INST">Inventor State</option>
							<option value="INCO">Inventor Country</option>
							<option value="GOTX">Government Interest</option>
							<option value="LREP">Attorney or Agent</option>
							<option value="PARN">Parent Case Information</option>
							<option value="PCTA">PCT Information</option>
							<option value="PT3D">PCT 371C124 Date</option>
							<option value="PTAD">PCT Filing Date</option>
							<option value="PRFR">Foreign Priority</option>
							<option value="REIS">Reissue Data</option>
							<option value="RPAF">Reissued Patent Application Filing
								Date</option>
							<option value="RLAP">Related US App. Data</option>
							<option value="RLFD">Related Application Filing Date</option>
							<option value="PRAD">Priority Claims Date</option>
							<option value="PPPD">Prior Published Document Date</option>
							<option value="UREF">Referenced By</option>
							<option value="FREF">Foreign References</option>
							<option value="OREF">Other References</option>
							<option value="ACLM">Claim(s)</option>
							<option value="PPDB">Description/Specification</option>
							<option value="FMID">Patent Family ID</option>
							<option value="AFFF">130(b) Affirmation Flag</option>
							<option value="AFFT">130(b) Affirmation Statement</option>
							<option value="COFC">Certificate of Correction</option>
							<option value="PTC">PTAB Trial Certificate</option>
							<option value="REEX">Re-Examination Certificate</option>
							<option value="SEC">Supplemental Exam Certificate</option>
							<option value="ILRN">International Registration Number</option>
							<option value="ILRD">International Registration Date</option>
							<option value="ILFD">International Filing Date</option>
							<option value="ILPD">International Registration
								Publication Date</option>
					</SELECT></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td align=right><button type="button" class="btn btn-default"
							id="advance_submit">提交</button></td>
				</tr>
			</table>
		</div>
		<div style="margin-top: 40px; height: 500px;">
			<div id="version">
				<div style="float: right; margin-left: 5px;">
					<button type="button" class="btn btn-danger"
						style="margin-right: 5px;" id="delete_btn">删除该组数据</button>
				</div>
				<div style="float: right; margin-left: 5px;">
					<button type="button" class="btn btn-success"
						style="margin-right: 5px;" id="download_btn">下载到Excel</button>
				</div>
				<div style="width: 200px; float: right;">
					<select id="version_select" class="form-control"
						style="width: 200px;">
					</select>
				</div>
			</div>
			<div>
				<table class="table table-bordered" id="my_table">
					<thead>
						<tr class="txt-center">
							<th class="txt-center">RECORD</th>
							<th class="txt-center">Patent Number</th>
							<th class="txt-center">Title</th>
							<th class="txt-center">Inventor Name</th>
							<th class="txt-center">Abstract</th>
							<th class="txt-center">URL</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<div id="cover" class="cover">
		<h1 style="margin-left: 30%; margin-top: 25%;">正在玩命加载，请稍后......</h1>
		<%-- <img style="margin-top:20%;margin-left:50%;"
			src="${pageContext.request.contextPath}/webresource/img/loading.gif"></img>  --%>
	</div>

</body>
</html>