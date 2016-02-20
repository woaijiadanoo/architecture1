<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/application.css"  rel="stylesheet">
<title>添加用户</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/customer/add" method="post"> 
		<fieldset>
			<legend>添加客户页面</legend>
			<table>
				<tr>
					<td>客户ID</td>
					<td><input type="text" id="customerId" /></td>
					<td>客户密码</td>
					<td><input type="text" id="pwd" /></td>
				</tr>
				<tr>
					<td>客户昵称</td>
					<td><input type="text" id="showName" /></td>
					<td>真实姓名</td>
					<td><input type="text" id="trueName" /></td>
				</tr>
			</table>
			<input type="submit" value="提交">
		</fieldset>
		
	</form>
</body>
</html>