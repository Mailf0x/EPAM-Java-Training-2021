<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>

		<meta charset="UTF-8">
		<title>Список товаров</title>
	</head>
	<body>

		<h1>Список товаров</h1>
		<ul>
		<c:forEach var="product" items="${products}">

			<li>${product.name} ${product.cost}</li>
		</c:forEach>
		</ul>
	</body>
</html>
