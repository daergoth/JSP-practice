<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login page</title>

<meta charset="utf-8">
</head>
<body>
	<h2>Login</h2>

	<c:choose>
		<c:when test="${param.error == 0}">
			<p style="color: red;">Invalid email or password!</p>
		</c:when>
		<c:when test="${param.error == 1}">
			<p style="color: red;">Missing email or password!</p>
		</c:when>

	</c:choose>

	<form action="/login" method="POST">
		<label for="email">Email: </label> <input type="text" id="email"
			name="email" placeholder="email" /> <br /> <label for="password">Password:
		</label> <input type="password" id="password" name="password"
			placeholder="Password" /> <br /> <input type="submit" value="Login" />
	</form>
</body>
</html>