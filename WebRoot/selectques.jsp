<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hospital.dao.LianxiDao"%>
<%@page import="com.hospital.util.ValueBean"%>
<%@page import="com.hospital.util.Lianxi"%><%@page import="com.hospital.dao.TousuDao"%><%@page import="com.hospital.util.Tousu"%><%@page import="com.hospital.dao.QuesDao"%><%@page import="com.hospital.util.Ques"%>





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
			所有问题
		</h3>
		<table id="mytable" cellspacing="0">
			<caption>
			</caption>
			<tr>
				<th scope="col">用户</th>
				<th scope="col">问题名称</th>
				<th scope="col">问题描述</th>
				<th scope="col">答复</th>
				<th scope="col">操作</th>
				
			</tr>
			<%
			QuesDao dao=new QuesDao();
			List<Ques> list=dao.getall();
			for(Ques msg:list){
			 %>
			<tr>
				<td class="row"><%=ValueBean.UserName(msg.getUid()+"") %></td>
				<td class="row"><%=msg.getName()%></td>
				<td class="row"><%=msg.getContent()%></td>
				<td class="row"><%=msg.getReply()%></td>
				<td class="row">
					<a href="servlet/DeleteQuesforjsp?page_type=2&lid=<%=msg.getLid() %>">删除</a>
					<a href="servlet/UpdateQues?page_type=2&lid=<%=msg.getLid() %>">答复</a>
				</td>
			
			</tr>
			<%}%>
		</table>

	</body>
</html>
