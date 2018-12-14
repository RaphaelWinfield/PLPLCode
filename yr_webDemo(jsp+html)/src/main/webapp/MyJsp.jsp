<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功!</h1>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%-- 用户名：<%=request.getParameter("name")%> --%>
	用户名：<%out.println("&nbsp&nbsp"+request.getParameter("name"));%>
	
	
	<br/>
	密码：<%=request.getParameter("pwd")%>
</body>
</html>

<!-- <script type="text/javascript">
	function showInfo() {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name + "  " + pwd);
		alert("您要搜索的是:" name + "  " + pwd);
	}
</script> -->