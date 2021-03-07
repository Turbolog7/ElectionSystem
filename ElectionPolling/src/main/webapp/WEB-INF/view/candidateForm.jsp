<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>candidate add page</title>
</head>
<script type="text/javascript">
	function validateCandidateDetailsl() {
		var userName = document.login.userName.value;
		var password = document.login.password.value;
		if (userName == '' && password == '') {
			alert("enter the valid userName and password");
		}
	}
</script>
<body>
	<center>
		<h1>Add Candidate</h1>
		<form:form id="candidateForm" modelAttribute="candidateData"
			action="save" method="post"
			onsubmit="return validateCandidateDetailsl()" name="login">
			<table>
				<tr>
					<td><form:label path="userName">UserName: </form:label></td>
					<td><form:input path="userName" name="userName" id="userName" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
				<tr>
					<td></td>
					<td align="left"><form:button id="login" name="login">Login</form:button></td>
				</tr>
			</table>
		</form:form>
		<a href="Welcome.jsp">Home</a>
	</center>
</body>
</html>