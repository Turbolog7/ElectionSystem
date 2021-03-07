<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Voter</title>
</head>
<body>

	<center>
		<h1>Candidate Details</h1>
		<table>
			<tr>
				<th>Candidate Number-</th>
				<th>Candidate Name-</th>
				<th>About Candidate-</th>
				<th>Vote</th>
			</tr>

			<c:forEach items="${candidateData}" var="detail">
				<tr>
					<td><input type="text"
						value="<c:out value="${detail.candidateId}"/>" name="candidateId"
						maxlength="100" readonly></td>
					<td><input type="text" value="<c:out value="${detail.name}"/>"
						name="name" maxlength="100" readonly></td>
					<td><input type="text"
						value="<c:out value="${detail.description}"/>" name="description"
						maxlength="10" readonly></td>
					<td><a
						href="/electionCommission/vote/?id='${detail.candidateId}'">Vote</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="Welcome.jsp">Home</a>
	</center>
</body>
</html>