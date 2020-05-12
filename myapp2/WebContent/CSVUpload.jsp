<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<form method="post" action="${pageContext.servletContext.contextPath}/MyFormController" 
											id="uploadForm" enctype="multipart/form-data">
	<input type="hidden" name="method" id="method" value="uploadData"/>
    <table border="1" cellspacing="4" cellpadding="6" bgcolor="pink" width="40%" align="center">
    	
    	<tr bgcolor="lime">
             <td colspan="2" align="center">
                 <h2>CSVupload Page</h2>
             </td>
        </tr>       
         <tr>
            <td>Upload</td>
            <td><input type="file" name="upload" id="upload"/></td>
        </tr>
         <tr>
             <td colspan="2" align="center">
                 <input type="submit" value="submit" />
             </td>
        </tr>
    </table>   
</form>
<script type="text/javascript">/* 
$('#uploadForm').click(function(){
	$('#uploadForm').attr("action","UploadFormController");
	$('#uploadForm').attr("enctype","multipart/form-data");
	$('#method').val("uploadData");
	$('#uploadForm').submit();
}); */
</script>
</body>
</html>