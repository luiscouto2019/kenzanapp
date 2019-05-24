<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="calendario.css" type="text/css" rel="stylesheet">
<script src="calendar.js" type="text/javascript"></script>
<script src="calendar-es.js" type="text/javascript"></script>
<script src="calendar-setup.js" type="text/javascript"></script>

<title>confirmation</title>
</head>
<body>
<form:form  name="miforma" action="/moduleEmployees/searchEmployee" method="get">
 <table align="center">
              
<tr>
<td>${msg}</td>
<td><button type="submit" class="btn btn-success">Done</button></td>
</tr>

</table>
</form:form>

</body>
</html>