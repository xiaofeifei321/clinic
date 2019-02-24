<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h2 align="center" >用户登录</h2>
    <form action="servlet/Login" method="post">
    <table align="center" width="300" border="0" cellpadding="5" cellspacing="5"  bgcolor=#0000ff>
    	<tr>
    		<td align="right" width:100px;>用户名：</td>
    		<td align="left" width:200px;>
    			<input type="text" name="username" width:150px/>
    		</td>
    	</tr>
    	
    	<tr>
    		<td align="right" width:100px;>密码：</td>
    		<td align="left" width:200px;>
    			<input type="password" name="password" width:150px/>
    		</td>
    	</tr>
    	
    	<tr>
    		
    		
    		<!--<td>
    			<input type="button" value="注册" style="width:50px" onclick="javascript:location.href='register.jsp'"/>
    		</td>
    		--><td  >
    			<input type="submit" value="登录" style="width:50px"/>
    		</td>
    		
    	</tr>
    
    
    </table>
    
    
    </form>
  </body>
</html>
