<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Insert title here</title>

</head>
<script type="text/javascript">
	
	
	
	function showInfo() {
		
		//var a = <%=request.getAttribute("connection")%>;
		
		//String a = (String)request.getAttribute("connection"); //很关键
		//if ("OK".equals(a)){
			alert(<%=request.getAttribute("connection")%>);
			
			
			alert(<%=basePath%>);
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			
			
		//}
		
		//document.location.reload();//重载当前页面 		
				
		/* String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name + "  " + pwd);
		alert("您要搜索的是:" name + "  " + pwd); */
	}
</script>

<body onload="showInfo()">
	
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<form action="transferTest" method="post">
		<input id="name" name="name" type="text">
		<input id="pwd" name="pwd" type="text">
		<input name="submit" type="submit" value="提交">
	</form>
	<br>
	<%
		/* if ("OK".equals(request.getParameter("connection"))){
			System.out.println(request.getParameter("connection"));
		} else {
			System.out.println(request.getParameter("connection"));
		} */
		
		String a = (String)request.getAttribute("connection"); //很关键
		if ("OK".equals(a)){
			System.out.println(a);
		}
	%>
</body>
</html>


<%-- <%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登陆成功!</h1>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	用户名：<%=request.getParameter("name")%>
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
</script> --> --%>