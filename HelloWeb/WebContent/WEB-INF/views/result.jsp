<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>购票信息</h2>
	<p>购票成功</p>
	<table>
 		<tr>
			<td>Place</td>
			<td>${place}</td>
		</tr>
		<tr>
			<td>Cost</td>
			<td>${cost}</td>
		</tr>
	</table>
	<p>返回${lest}</p>
	<a href="result">return</a> 
</body>
</html>