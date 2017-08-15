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
<h1>${category.name }</h1>
	<h3>Products</h3>
	<ul>
		<c:forEach var="product" items="${categories.product }">
			<li>${product.name }</li>
		</c:forEach>
	</ul>
	
	<form:form method="POST" action="/categories/${category.id }/new" >
		<p>Add Product:</p>
		<select name="product">
			<c:forEach var="prod" items="${products }">
				<c:if test="${!category.products.contains(prod) }">
					<option value = "${prod.id }"> ${prod.name}</option> 
				</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="add">
	</form:form>
</body>
</html>