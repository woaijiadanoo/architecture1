<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#query_submit").click(
			function(){
				var queryJson = '{"customerId":"'+$("#customerId").val()+'"'+
					',"pwd":"'+$("#pwd").val()+'"'+
					',"showName":"'+$("#showName").val()+'"'+
					',"trueName":"'+$("#trueName").val()+'"'+
					'}';
				window.location.href = "${pageContext.request.contextPath}/customer/toList?queryJsonStr="+queryJson+"";
			}				
		)
	})

</script>
</head>
<body>
	<fieldset>
		<legend>用户信息查询</legend>
			<table>
				<tr>
					<td>客户ID</td>
					<td><input type="text" id="customerId" name="customerId" class="input"></td>
					<td>客户密码</td>
					<td><input type="text" id="pwd" name="pwd" class="input"></td>
				</tr>
				<tr>
					<td>客户昵称</td>
					<td><input type="text" id="showName" name="showName" class="input"></td>
					<td>真实姓名</td>
					<td><input type="text" id="trueName" name="trueName" class="input"></td>
				</tr>
			</table>
			<input type="button" id="query_submit" value="查询">
	</fieldset>
</body>
</html>