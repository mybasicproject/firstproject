<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

</head>
<body>
<h1 align="center">Sign Up</h1>

<form action="UserController" method="post" autocomplete="off">
	<input type="hidden" name="method" value="updateRecord">
	<input type="hidden" name="id" value="${userdata.id }">
	<table border="1" cellspacing="4" align="center" >
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstname" value="${userdata.name.firstName }"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastname" value="${userdata.name.lastName }"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>
				<input type="text" id ="country" name="country" value="${userdata.address.country }"/>
			</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>
				<input type="text" id ="state" name="state" value="${userdata.address.state }"/>
			</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>
				<input type="text" id ="city" name="city" value="${userdata.address.city }"/>
			</td>
		</tr>
		<tr>
			<td>Pincode:</td>
			<td><input type="text" name="pincode" value="${userdata.address.pincode }"/></td>
		</tr>
		<tr>
			<td>Area:</td>
			<td><input type="text" name="areaname" value="${userdata.area }"/></td>
		</tr>
		<tr>
			<td>Contact No:</td>
			<td><input type="text" name="contact" value="${userdata.contact }"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"  value="${userdata.email }" autocomplete="off"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="pass" value="${userdata.password }"/></td>
		</tr>
		<tr>
			<td>Confirm Password:</td>
			<td><input type="password" name="cnfpass" value="${userdata.confirmPassword }"/></td>
		</tr>
		<tr>
               <td colspan="2" align="center">
                   <input type="submit" value="Update" />
                   <input type="reset" value="Reset" />
               </td>
           </tr>
	</table>
</form>

</body>
</html>