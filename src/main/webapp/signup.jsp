<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>
	<center>
		<h5>Library App SignUp</h5>
		<form action="${pageContext.request.contextPath}/sign-up"
			method="post">
			Username : <input type="text" name="username" /><br /> Password: <input
				type="password" name="password"><br /> <input type="submit"
				value="Sign-Up">
		</form>
	</center>
</body>
</html>