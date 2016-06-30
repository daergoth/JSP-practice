<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Profile page</title>
</head>
<body>
	<h2>Profile</h2>

	<p>
		<span style="font-size: 1.3em;">Products</span>
	<table style="text-align: left; border: 1px solid black;">
		<tr>
			<th>Name:</th>
			<th>Price:</th>
			<th>Production time:</th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.name}" /></td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.productionTime}" /></td>
			</tr>
		</c:forEach>
	</table>
	</p>

	<form action="/logout" method="POST">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>