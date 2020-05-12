<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Sign Up</h1>
<center>
<form action="UserController" method="post">
	<input type="hidden" name="method" value="getData">
	<table border="1" cellspacing="4">
		<tr>
			<td>Enter Id :</td>
			<td><input type="text" name="id"/></td>
		</tr>
		
		<tr>
             <td colspan="2" align="center">
                 <input type="submit" value="Get Data" />
                 <input type="reset" value="Reset" />
             </td>
           </tr>
	</table>
</form>
</center>
</body>
</html>