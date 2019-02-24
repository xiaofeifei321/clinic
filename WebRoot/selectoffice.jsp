 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hospital.dao.OfficeDao"%>
<%@page import="com.hospital.util.Office"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'show_message.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 700px;
	padding: 0;
	margin: 0;
}

caption {
	padding: 0 0 5px 0;
	width: 700px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: green;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}

/*---------for IE 5.x bug*/
html>body td {
	font-size: 11px;
}

body,td,th {
	font-family: 宋体, Arial;
	font-size: 12px;
}
</style>
	</head>
	<body>
		<h3>&nbsp; 
		专家管理
		</h3>
		<table id="mytable" cellspacing="0">
			<caption>
			</caption>
			<tr>
				<th scope="col">科室名</th>
				<th scope="col">主治医生</th>
				<th scope="col">医生介绍</th>
				<th scope="col">预约费</th>
				<th scope="col">联系方式</th>
				<th scope="col">坐诊时间</th>
				<th scope="col">操作</th>
				
			</tr>
			<%
			OfficeDao mdao= new OfficeDao();
			List<Office> list = mdao.getallte();
			for(Office msg:list){
				
			 %>
			<tr>
				<td class="row"><%=msg.getOname() %></td>
				<td class="row"><%=msg.getDocname()%></td>
				<td class="row"><%=msg.getContent()%></td>
				<td class="row"><%=msg.getNeed()%></td>
				<td class="row"><%=msg.getPhone()%></td>
				<td class="row"><%=msg.getOntime()%></td>
				<td class="row">
					<a href="servlet/DeleteOffice?page_type=2&oid=<%=msg.getOid() %>">删除</a>
					<a href="servlet/UpdateOffice?page_type=2&oid=<%=msg.getOid() %>">更新</a>
				</td>
			</tr>
			<%}%>
		</table>

	</body>
</html>
</body>
</html>
