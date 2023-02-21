<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="pra" action="/practice" method="post">
		<c:out value="${pra}"></c:out><br>
		<form:checkboxes items="${pra.list}" path="list"/><br>
		
		<!--<form:radiobuttons path="list" items="${pra.list}"/><br>-->
		
		
		<c:out value="${maps}" ></c:out>
		<c:forEach items="${pra.maps}" var="li">
			<c:out value="${li.key}" ></c:out>:   <!-- both works li.key() and .value() -->
			<c:out value="${li.value}" ></c:out>
	
		</c:forEach><br>
		<!-- <form:select path="maps">
			<form:option value="" label="--Select--"></form:option>
			<form:options items="${pra.maps}"/>
		</form:select> 
		 <form:input path="maps" value="good"/> -->
		 
		<input type="text" name="sizes"> <!-- This is the way to send list to the controller -->
		
		<!-- <input type="checkbox" name="maps" value="USER" /> User
   		<input type="checkbox" name="maps[]" value="ADMIN" /> Admin  -->
   		
   		<input type="text" name="maps['name']" />
   		<input type="text" name="maps['country']" />
		<input type="submit"/>
	</form:form>
</body>
</html>