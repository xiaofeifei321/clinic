 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hospital.dao.EventsDao"%>
<%@page import="com.hospital.util.Events"%>
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
			信息维护
		</h3>
		
		<form name="modify" action="servlet/InsertEvents" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
		<input type="hidden"" name="events.mid"  value="${events.mid}"  />
			<table id="mytable" cellspacing="1">
				
			
				<tr>
					<td class="c1">标题：</td>
					<td><input type="text" name="events.mname"  value="${events.mname}"  style="width:360px;" /></td>
				</tr>
				<tr>
					<td class="c1">发布人：</td>
					<td><input type="text" name="events.username"  value="${events.username}"  style="width:360px;" /></td>
				</tr>
				<tr>
					<td class="c1">内容</td>
					<td><textarea rows="6" cols="100" name="events.mcontent">${events.mcontent }</textarea></td>
				</tr>
				<tr>
					<td class="c1">图片</td>
					<td>	<c:if test="${events.mpic != null}">
								<img alt="图片下载"
									src="${pageContext.request.contextPath}/${events.mpic }"
									width="200px" height="80px"><br />
								</img>
								</c:if>
								
								<input name="file" type="file""></td>
				</tr>
				<tr>
					<td class="c1">类别</td>
					<td>
						<select name="events.mtype">
									    <option value="医院简介">医院简介</option>
									    <option value="最新活动">最新活动</option>
									    <option value="名医课堂">名医课堂</option>
									    <option value="医院地址">医院地址</option>
								
								</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input  type="submit" value=" 保存" /> 
						<input  type="reset" value=" 重置 " />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
