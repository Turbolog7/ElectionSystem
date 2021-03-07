<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ElectionResult</title>
</head>
<body>
	<center>
		<h1>Election Result</h1>

		<table>

			<c:forEach items="${winnerCandidate}" var="obj">
				<input type="text" value="<c:out value="${obj.candidateId}"/>"
					name="candidateId" maxlength="100" readonly>
				<br>
				<br>

				<input type="text" value="<c:out value="${obj.name}"/>" name="name"
					maxlength="100" readonly>

			</c:forEach>
		</table>
		<a href="Welcome.jsp">Home</a>
	</center>
</body>
</html>