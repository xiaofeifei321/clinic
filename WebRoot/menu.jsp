<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/base.css" type="text/css" />
<link rel="stylesheet" href="css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="js/menu.js"></script>


<base target="main" />
  
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <body target="main">


<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
     <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>用户管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
           <li><a href='Alluser.jsp?id=0' target='frame'>查看所有用户</a></li>
              <li><a href='selectlianxi.jsp?id=0' target='frame'>查看所有联系人</a></li>
            
          </ul>
        </dd>
      </dl> 
	
      <!-- Item 2 Strat -->
        <dl class='bitem' >
        <dt onClick='showHide("items2_1")'><b>医院管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='selectguide.jsp?id=0' target='frame'>查看所有指南</a></li>
            <li><a href='Insertguide.jsp?id=0' target='frame'>添加指南</a></li>
           
              
            <!--
             <li><a href='GetTeacher.jsp?id=0' target='frame'>申请暂停课程</a></li>
             --><!--<li><a href='GetTeacher1.jsp?id=0' target='frame'>申请交换课程</a></li>
             --><!--<li><a href='selectstudent.jsp?id=0' target='frame'>查看师生信息</a></li>
             <li><a href='MyJsp.jsp?id=0' target='frame'>发布重要资讯</a></li>-->
          </ul>
        </dd>
      </dl>
      
      
       <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>专家管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='InsertOffice.jsp?id=0' target='frame'>添加专家</a></li>
             <li><a href='selectoffice.jsp?id=0' target='frame'>查看所有专家</a></li>
            
          </ul>
        </dd>
      </dl> 
       <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>信息管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='InsertEvents.jsp?id=0' target='frame'>添加信息</a></li>
             <li><a href='servlet/EventsList' target='frame'>信息管理</a></li>
            
          </ul>
        </dd>
      </dl> 
       <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>预约管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
             <li><a href='selectsub.jsp?id=0' target='frame'>预约管理</a></li>
            
          </ul>
        </dd>
      </dl> 
       <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>投诉管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
             <li><a href='selecttousu.jsp?id=0' target='frame'>投诉管理</a></li>
            
          </ul>
        </dd>
      </dl> 
       <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>问题管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
             <li><a href='selectques.jsp?id=0' target='frame'>问题管理</a></li>
            
          </ul>
        </dd>
      </dl> 
      <!--
       
     
      
      
    
      
    
     
      --><!-- Item 2 End -->
      
      <!-- Item 3 Strat -->
     
      <!-- Item 3 End --> 
      
     
      <!-- Item 4 End -->      
	  </td>
  </tr>
</table>
</body>
</html>






  