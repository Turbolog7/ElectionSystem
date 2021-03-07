<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WelcomePage</title>
</head>
<body>
	<center>
		<h1>Welcome to E-Election Polling</h1>
		<a href="/electionCommission/addCandidate">Admin</a>
		<h4>OR</h4>
		<a href="/electionCommission/viewCandidates">Guest</a>
	</center>
</body>
</html>