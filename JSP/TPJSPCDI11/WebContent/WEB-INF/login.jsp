<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	<div class="container">
		<div class="content">
			<form method="POST">
				<div>
					<label for="loginInput">login : </label><input id="loginInput"
						type="text" value="" name="login">
				</div>
				<div>
					<label for="passwInput">mot de passe : </label><input
						id="passwInput" type="text" value="" name="passw" />
				</div>
				<input type="submit" name="login" />
			</form>
		</div>
	</div>
</body>
</html>