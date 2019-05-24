<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Module</title>
</head>
<body>
         
<form:form  name="miforma"  action="/moduleEmployees/newEmployee" method="GET" modelAttribute="searchForm">
<table class="table table-striped" align="center">
                
                <tr>
                <td align="center">
                <b> Employees Module     </b>            
                </td>
                </tr>
                               
                <tr>
                <td align="left">
                <button type="submit">New Employee</button>                
                </td>
                </tr>
               
                </table>
                 </form:form>  
   <table class="table table-striped" align="center">       
   <tr>
   <th>Id</th>
   <th>FirstName</th>
   <th>MiddleInitial</th>
   <th>LastName</th>
   <th>Status</th>
   <th>DateBirth</th>
   <th>DateOfEmployment</th>
   </tr>
    <c:forEach var="employee" items="${lstEmployees}">
      <tr>
      <td>
       <a href="/moduleEmployees/editEmployee?idemployee=${employee.id}">
       ${employee.id}
       </a>
      </td>
      <td>
       ${employee.firstName}
      </td>
      <td>
       ${employee.middleInitial}
      </td>
      <td>
       ${employee.lastName}
      </td>
      <td>
       ${employee.status}
      </td>
      <td>
       ${employee.stringDateBirth}
      </td>
       <td>
       ${employee.stringDateOfEmployment}
      </td>
      </tr>
    
     
    </c:forEach>
   
   <tr>
                <td align="center" colspan="7">
                <b> Click on the Id to edit one employee</b>         
                </td>
                </tr>
               
   </table>       
                 
                 
</body>
</html>