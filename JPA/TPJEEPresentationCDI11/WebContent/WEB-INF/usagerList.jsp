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
	<div class="row">
		<div class="small-12 large-4 columns">
			<form method="post">
				<div class="row">
					<div class="small-5 large-12 columns">
						<label>nom <input type="text" id="inputNom"
							name="inputNom" value="${param.inputNom}">
						</label>
					</div>
					<div class="small-5 large-12 columns">
						<label>prenom <input type="text" id="inputPrenom"
							name="inputPrenom" value="${param.inputPrenom}">
						</label>

					</div>
					<div class="small-2 large-12 columns">
						<input type="submit" value="rechercher" name="actionRechercher">
					</div>
					<div class="small-12 large-12 columns">
						<input type="submit" value="créer" name="actionCreer">
					</div>
				</div>
			</form>
		</div>
		<div class="small-12 large-8 columns">
			<div class="row">
				<div class="small-6 large-4 columns">nom</div>
				<div class="small-6 large-4 columns">prenom</div>
				<div class="small-6 large-4 columns">action</div>
			</div>
			<c:forEach items="${usagers}" var="usager">
				<div class="row">
					<div class="small-6 large-4 columns">${usager.nom}</div>
					<div class="small-6 large-4 columns">${usager.prenom}</div>
					<div class="small-6 large-4 columns">
						<a href="usagerForm?id=${usager.id}">form</a>
						<form method="post">
							<input type="hidden" value="${usager.id}" name="inputId"/>
							<input type="submit" value="delete" name="actionSupprimer">
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>