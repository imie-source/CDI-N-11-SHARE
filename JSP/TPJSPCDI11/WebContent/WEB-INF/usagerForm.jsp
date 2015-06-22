<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fr.imie.DTO.UsagerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usagerForm</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
<%!SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
</head>
<jsp:useBean id="usager" class="fr.imie.DTO.UsagerDTO" scope="request"></jsp:useBean>
<%-- <%Integer numLigne = (Integer)request.getAttribute("numLigne"); %> --%>
<body>
	<%@ include file="menu.jspf"%>
	<%-- <%
		UsagerDTO usagerDTO = (UsagerDTO) request.getAttribute("usager");
	%> --%>
	<div class="container">
		<div class="content">
			<form method="POST">
				<div>
					<input type="hidden" value="${numLigne}" />
					<div>
						<label for="nomInput">nom : </label><input id="nomInput"
							type="text" value="${usager.nom}" />
					</div>
					<div>
						<label for="prenomInput">prenom : </label><input id="prenomInput"
							type="text" value="${usager.prenom}" name="prenom" />
					</div>
					<div>
						<label for="mailInput">mail : </label><input id="mailInput"
							type="text" value="${usager.email}" name="mail" />
					</div>
					<div>
						<label for="dateNaissInput">date de naissance : </label><input
							id="dateNaissInput" type="date"
							value="<%=usager == null || usager.getDateNaiss() == null ? ""
					: simpleDateFormat.format(usager.getDateNaiss())%>"
							name="dateNaiss" />
					</div>
					<div>
						<label for="passwInput">mot de passe : </label><input
							id="passwInput" type="password" value="${usager.password}"
							name="password" />
					</div>
				</div>
				<input type="submit"
					value="<%=usager.getId()!= null ? "modifier" : "créer"%>" />
			</form>
		</div>
	</div>
</body>
</html>