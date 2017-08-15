<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${product.name }</h1>
	<h3>Categories</h3>
	<ul>
		<c:forEach var="category" items="${product.categories }">
			<li>${category.name }</li>
		</c:forEach>
	</ul>
	
	<form:form method="POST" action="/products/${product.id }/new" >
		<p>Add Category:</p>
		<select name="category">
			<c:forEach var="categoree" items="${categories }">
				<c:if test="${!product.categories.contains(categoree) }">
					<option value = "${categoree.id }"> ${categoree.name}</option> 
				</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="add">
	</form:form>
</body>
</html>