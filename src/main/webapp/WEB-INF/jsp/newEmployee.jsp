<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script>
function isValidDate(element,name)
{

	dateString=element.value;
	
	// First check for the pattern
    var regex_date = /^\d{4}\-\d{1,2}\-\d{1,2}$/;

    if(!regex_date.test(dateString))
    {
    	  alert("The " + name + " is invalid. The format must be yyyy-MM-dd" );
          return false;
    }

    // Parse the date parts to integers
    var parts   = dateString.split("-");
    var day     = parseInt(parts[2], 10);
    var month   = parseInt(parts[1], 10);
    var year    = parseInt(parts[0], 10);

    // Check the ranges of month and year
    if(year < 1000 || year > 3000 || month == 0 || month > 12)
    {
    	alert("The " + name + " is invalid. The format must be yyyy-MM-dd" );
        return false;
    }

    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    // Adjust for leap years
    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
    {
        monthLength[1] = 29;
    }

 // Check the range of the day
   if( !(day > 0 && day <= monthLength[month - 1]) ) {
	    alert("The " + name + " is invalid. The format must be yyyy-MM-dd" );
		return false;
	   }

   return true;
    	
}

function validateDates(){

	if(isValidDate(miforma.stringDateBirth,'Date of Birth') && isValidDate(miforma.stringDateOfEmployment,'Date of Employment') )

      return true;
	else
		return false;
	
}


</script>



<title>New Employee</title>
</head>
<body>
<form:form  name="miforma" action="/moduleEmployees/saveEmployee" method="post" modelAttribute="employee" onsubmit=" return validateDates();">
 <table>
      
<tr>
<td align="center" colspan="2"><b>New Employee</b></td>
</tr>
                
<tr>
<td align="left">FirstName:</td>
<td align="left"><form:input size="25" maxlength="25" path="firstName"/></td>
</tr>
<tr>
<td align="left">MiddleInitial:</td>
<td align="left"><form:input size="25" maxlength="25" path="middleInitial"/></td>
</tr>
<tr>
<td align="left">LastName:</td>
<td align="left"><form:input size="25" maxlength="25" path="lastName"/></td>
</tr>
<tr>
<td align="left">DateOfBirth:</td>
<td align="left">
<form:input size="25" maxlength="25" path="stringDateBirth" id="stringDateBirth"/>



</td>
</tr>
<tr>
<td align="left">DateOfEmployment:</td>
<td align="left">
<form:input size="25" maxlength="25" path="stringDateOfEmployment" id="stringDateOfEmployment"/>
                                               
</td>
</tr>

<tr>
<td align="center" colspan="2"><button type="submit" class="btn btn-success">Save</button>
</td>
</tr>
</form:form>

</body>
</html>