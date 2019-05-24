<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         
<form:form  name="miforma"  action="/findEmployees" method="GET" modelAttribute="searchForm">
<table class="table table-striped">
                
               <tr>
                <td align="right">
                Id:
                </td>
                <td align="right">
                <form:input size="10" maxlength="10" path="idEmployee" />	
                </td>
                </tr>
               <tr>
                <td align="right">
                
<button type="submit">Search</button>                
                </td>
                <td align="right">
                
<button type="button">New</button>                
               
                </td>
                </tr>
               
                </table>
                 </form:form>  
</body>
</html>