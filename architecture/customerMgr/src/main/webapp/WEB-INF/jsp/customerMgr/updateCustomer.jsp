<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册页面</title>
<link href="${pageContext.request.contextPath}/static/css/application.css"  rel="stylesheet">
</head>
<body>
	<fieldset>
		<legend>用户修改</legend>
		<form action="${pageContext.request.contextPath}/customer/update" method="post">
		<input type="hidden" name="uuid" value="${cm.uuid}" />
		<input type="hidden" name="registerTime" value="${cm.registerTime}" />
			<table>
				<tr>
					<td>客户ID</td>
					<td><input type="text" name="customerId" value="${cm.customerId}" class="input"></td>
					<td>客户密码</td>
					<td><input type="text" name="pwd" value="${cm.pwd}" class="input"></td>
				</tr>
				<tr>
					<td>客户昵称</td>
					<td><input type="text" name="showName" value="${cm.showName}" class="input"></td>
					<td>真实姓名</td>
					<td><input type="text" name="trueName" value="${cm.trueName}" class="input"></td>
				</tr>
			</table>
			<input type="submit" value="修改">
		</form>
	</fieldset>
</body>
</html>