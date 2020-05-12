<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

<title>Sign Up</title>

</head>
<body>
<h3 style="color: green;font-size: 15px; <c:if test="${empty msg}">display:none</c:if>" align="center">${msg}</h3>
<h3 style="color: red;font-size: 15px; <c:if test="${empty error}">display:none</c:if>" align="center">${error}</h3>

<form action="${pageContext.servletContext.contextPath}/UserController" id="signupform" method="post" autocomplete="off">
	<input type="hidden" name="method" value="saveRecord">
	<table border="1" cellspacing="4" align="center" width="40%" bgcolor="pink">
		<tr bgcolor="lime">
            <td colspan="2" align="center">
                <h2>Signup</h2>
            </td>
        </tr>
		<tr>
			<td align="right">First Name:</td>
			<td><input type="text" name="firstname" required/></td>
		</tr>
		<tr>
			<td align="right">Last Name:</td>
			<td><input type="text" name="lastname"/></td>
		</tr>
		<tr>
			<td align="right">Country:</td>
			<td>
				<select id ="country" name="country">
					<option value="">---select----</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">State:</td>
			<td>
				<select id ="state" name="state">
					<option value="">---select----</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">City:</td>
			<td>
				<select id ="city" name="city">
					<option value="">---select----</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Pincode:</td>
			<td><input type="text" name="pincode" required/></td>
		</tr>
		<tr>
			<td align="right">Area:</td>
			<td><input type="text" name="areaname" required/></td>
		</tr>
		<tr>
			<td align="right">Contact No:</td>
			<td><input type="text" name="contact" required/></td>
		</tr>
		<tr>
			<td align="right">Email:</td>
			<td><input type="email" name="email" required/></td>
		</tr>
		<tr>
			<td align="right">Password:</td>
			<td><input type="password" name="pass" required/></td>
		</tr>
		<tr>
			<td align="right">Confirm Password:</td>
			<td><input type="password" name="cnfpass" required/></td>
		</tr>
		<tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register" />
                <input type="reset" value="Reset" />
            </td>
        </tr>
	</table>
	<table id="user_info">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Country</th>
				<th>State</th>
				<th>City</th>
				<th>pincode</th>
				<th>Area</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Password</th>
				<th>Confirm Password</th>
			</tr>
		</thead>
	</table>
</form>

<script type="text/javascript" src="js/signup.js"></script>
<script type="text/javascript" src="js/validation.js"></script>

</body>
</html>