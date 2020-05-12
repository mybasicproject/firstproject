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
<form method="post" action="ProductController">
    <table border="1" cellspacing="4" cellpadding="6" bgcolor="pink" width="20%" align="center">
    	<tr bgcolor="lime">
             <td colspan="2" align="center">
                 <h2>Product Page</h2>
             </td>
        </tr>
        <tr>
             <td colspan="2" align="left">
                 <a href="ProductController?method=insertData" target="_blank">Insert</a>
             </td>
        </tr>
        <tr>
             <td colspan="2" align="left">
                 <a href="ProductController?method=updateData" target="_blank">Update</a>
             </td>
        </tr>
        <tr>
             <td colspan="2" align="left">
                 <a href="ProductController?method=deleteData" target="_blank">Delete</a>
             </td>
        </tr>
    </table>   
</form>
</body>
</html>