<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="foudation/foundation-essentials-5.5.2/css/foundation.css">
<link rel="stylesheet" href="main.css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<div>
			<label>nom : </label> <input type="text" value="${usager.nom}"
				name="inputNom" />
		</div>
		<div>
			<label>prenom : </label> <input type="text" value="${usager.prenom}"
				name="inputPrenom" />
		</div>
		<c:choose>
			<c:when test="${empty usager}">
				<input type="submit" name="actionCreer">
			</c:when>
			<c:otherwise>
				<input type="submit" name="actionModifier">
			</c:otherwise>
		</c:choose>

	</form>
</body>
</html>