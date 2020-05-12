<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<title>Login Page</title>
</head>
<body>
<h3 style="color: green;font-size: 15px; <c:if test="${empty message}">display:none</c:if>" align="center">${message}</h3>
<h3 style="color: red;font-size: 15px; <c:if test="${empty error}">display:none</c:if>" align="center">${error}</h3>
<form method="post" action="LoginController" id="loginform">
	<input type="hidden" name="csrfToken" id="csrfToken" value="${csrfTokenReq}"/>
	<input type="hidden" name="method" value="authenticateUser">
	
    <table border="1" cellspacing="4" cellpadding="6" bgcolor="pink" width="40%" align="center">
    	<tr bgcolor="lime">
             <td colspan="2" align="center">
                 <h2>Login Page</h2>
             </td>
        </tr>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username" id="username" value=""/></td>
        </tr>
         <tr>
            <td>Password</td>
            <td><input type="password" name="pwd" id="pwd" /></td>
        </tr>
         <tr>
             <td colspan="2" align="center">
                 <input type="submit" value="Login" />
                 <input type="reset" value="Clear" />
                 <span class="psw"><a href="#">Forgot Password</a></span>
             </td>
        </tr>
        <tr>
             <td colspan="2" align="right">
                 <a href="signup.jsp" target="_blank">Create Account</a>
             </td>
        </tr>
    </table>   
</form>
<script type="text/javascript" src="js/validation.js"></script>
</body>
</html>