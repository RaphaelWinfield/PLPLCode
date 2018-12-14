<!DOCTYPE html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>	
    <base href="<%=basePath%>">    
    <title>My JSP 'JqueryTest.jsp' starting page</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>   
     
	<script type="text/javascript">
		 
		function upload(){
	        alert("点击");
	        $.ajax({
	            type: "POST",
	            url: "transferTest",
	            data: $('#form').serialize(),
	            success: function(x){
	            	/* var table = document.getElementById("show");
	            	for (var i = 0; i<x.length; i++){
	            		var tr = table.insertRow(table.rows.length);
	            		var obj = x[i];
	            		for (var p in obj){
	            			var td = tr.insertCell(tr.cells.length);
	            			td.innerText = obj[p];
	            		}
	            	} */	            	
	            	
	            	var htmls = new Array();//必须初始化为数组					
					for(var i=0,L=x.length;i<L;i++){
					  htmls.push('<tr>');
					  for(var k in x[i]) htmls.push('<td>'+x[i][k]+'</td>');  //添加上行的id名
					  htmls.push('</tr>');
					}					
					$('#show').after(htmls.join(''));
	            
	            	/* for(var i=0; i<x.length; i++){
	            		alert(x[i].name);
	            		alert(x[i].author);
	            	} */
					           
	            	/* alert(x);            	
	            	alert(x[0].username);   
	            	alert(x[0].password); 
	            	alert(x[1].username); 
	            	alert(x[1].password); 
 	            	$("#name").val("s");
					$("#pwd").val("d");	 */		
	            }
	        })	        
	    }

	</script>	
  </head> 	
  <body>
  	
  	<form id="form" action="transferTest" method="post">
		<input id="name" name="name" type="text">
		<input id="pwd" name="pwd" type="text">
		<input id="submit" name="submit" type="button" value="提交" onclick="upload()">
	</form>
	
	<table id="show">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>author</th>
		</tr>
	</table>
	
  </body>
</html>
