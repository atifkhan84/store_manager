<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2 style="color:red;">Generalized Exception Handler Page</h2>
    <hr>
    Exception Occured is : ${message}
    <hr>
    Details of Exception
    <hr>
    ${exception}
    <hr>
    <a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>