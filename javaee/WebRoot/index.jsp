<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <!-- 下面三个是控制不缓存 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<!--  -->
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/1.css">
	<script type="text/javascript" src="js/1.js"></script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <!-- 
   		${pageContext.request.contextPath } 这里的 就相当于 javaee这个目录 
    -->
    <form action="${pageContext.request.contextPath}/servlet/ServletDemo1" method="post">
    	<input type="text" name="name" > <input type="submit" value="提交">
    </form>
  </body>
</html>
