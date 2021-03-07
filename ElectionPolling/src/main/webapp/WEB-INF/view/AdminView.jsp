<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
</head>
<body>

	<center>
		<h1>Candidate Details In Admin View</h1>
	</center>
	<center>
		<table>
			<tr>
				<th>Candidate ID</th>
				<th>Candidate Name</th>
				<th>Candidate Description</th>
			</tr>
			<c:forEach items="${candidateData}" var="obj">
				<tr>
					<td><input type="text"
						value="<c:out value="${obj.candidateId}"/>" name="candidateId"
						maxlength="100" readonly></td>

					<td><input type="text" value="<c:out value="${obj.name}"/>"
						name="name" maxlength="100" readonly></td>

					<td><input type="text"
						value="<c:out value="${obj.description}"/>" name="description"
						maxlength="1000" readonly></td>
				</tr>
			</c:forEach>
		</table>
		<a href="Welcome.jsp">Home</a>
	</center>


</body>
</html>