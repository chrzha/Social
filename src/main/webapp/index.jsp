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
	
	$('#advance_submit').on('click',function(){
		var _url = "/data/catch/url";
		var para={};
		
		para.url =  $("#myUrl").val();
		para.term1 =  $("#trm1").val(); 
		para.field1 =  $("#fld1").val(); 
		para.operator =  $("#co1").val(); 
		para.term2 =  $("#trm2").val(); 
		para.field2 =  $("#fld2").val(); 
		 
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

	$('#my_submit').on('click',function(){
		var _url = "/data/catch/simpleUrl";
		var para={};
		para.url =  $("#myUrl").val();
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

	$("#advance_catch").on('click',function(){

		$("#my_submit").hide();
		$("#advance_cancle").show();
		$("#advance_table").show();

    });
	$("#advance_cancle").on('click',function(){

		$("#advance_cancle").hide();
		$("#my_submit").show();
		$("#advance_table").hide();

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
			tr.append($("<td></td>").append($("<textarea rows='4'></textarea>")).text(result[i]["abstractContent"]));
			tr.append($("<td></td>").text(result[i]["patentUrl"]));
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
			<form class="form-inline" role="form" style="margin-left:20%;">
			   <div class="form-group">
			      <label for="name">URL</label>
			      <input type="text" class="form-control" id="myUrl"
			         placeholder="请输入URL">
			   </div>
			   <button type="button" class="btn btn-default" id="my_submit">提交</button>
			   <button type="button" class="btn btn-default" id="advance_catch">高级爬取</button>
			   <button style="display:none" type="button" class="btn btn-default" id="advance_cancle">取消</button>
			</form>
			<table style=" margin-top:20px;display:none;" id="advance_table"> 
<tr><td> <STRONG><LABEL For="trm1">Term 1:</LABEL></STRONG><INPUT ID="trm1" TYPE="TEXT" NAME="TERM1" SIZE=25></td>
<td align=center>in <B><LABEL For="fld1">Field 1:</LABEL></B></td>
<td>
     <SELECT ID="fld1" NAME="FIELD1">
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
		<option value="RPAF">Reissued Patent Application Filing Date</option>
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
		<option value="ILPD">International Registration Publication Date</option>
     </SELECT>
</td></tr>
<tr><td></td><td align=middle>
  <SELECT NAME="co1" ID="co1" title="Boolean Operator">
          <OPTION value="AND" SELECTED>AND</option>
	  <OPTION value="OR">OR</option>
	  <OPTION value="NOT">ANDNOT</option>
          </select>
</td></tr>
<tr><td><STRONG><LABEL For="trm2">Term 2:</LABEL></STRONG><INPUT ID="trm2" TYPE="TEXT" NAME="TERM2" SIZE=25></td><td align=center>in <B><LABEL For="fld2">Field 2:</LABEL></B></td>
<td>
     <SELECT ID="fld2" NAME="FIELD2">
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
		<option value="RPAF">Reissued Patent Application Filing Date</option>
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
		<option value="ILPD">International Registration Publication Date</option>
     </SELECT>
</td></tr>
<tr><td></td><td></td><td align=right><button type="button" class="btn btn-default" id="advance_submit">提交</button></td></tr>
</table>
		</div>
		<div style="margin-left:10%;margin-top:40px;margin-right:10%;">
		 <table class="table table-bordered table-striped" id="my_table">
				<thead>
					<tr class="txt-center">
						<th style="width:30px;">PAT.NO</th>
						<th style="width:100px;">Title</th>
						<th style="width:30px;">Owner</th>
						<th style="width:30px;">Field Name</th>
						<th style="width:200px;">Abstract</th>
						<th style="width:100px;">URL</th>
					</tr>
				</thead>
				<tbody>
					 
				</tbody>
			</table>
		
		</div>
	</div>

</body>
</html>