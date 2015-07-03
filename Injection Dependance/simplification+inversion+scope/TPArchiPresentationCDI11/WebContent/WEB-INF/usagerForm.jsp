<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.general" var="propertie" />
<t:main>
	<form method="POST">
		<div>
			<input type="hidden" value="${numLigne}" />
			<div>

				<label for="nomInput"><fmt:message key="usager.lastName"
						bundle="${propertie}" /></label><input id="nomInput" type="text"
					value="${usager.nom}" name="nom" />
			</div>
			<div>
				<label for="prenomInput"><fmt:message key="usager.firstName"
						bundle="${propertie}" /></label><input id="prenomInput" type="text"
					value="${usager.prenom}" name="prenom" />
			</div>
			<div>
				<label for="mailInput"><fmt:message key="usager.email"
						bundle="${propertie}" /></label><input id="mailInput" type="text"
					value="${usager.email}" name="mail" />
			</div>
			<div>
				<fmt:formatDate var="dateNaiss" value="${usager.dateNaiss}"
					pattern="dd/MM/yyyy" />
				<label for="dateNaissInput"><fmt:message
						key="usager.dateOfBirth" bundle="${propertie}" /></label><input
					id="dateNaissInput" type="date" value="${dateNaiss}"
					name="dateNaiss" />
			</div>
			<div>
				<label for="passwInput"><fmt:message key="usager.passw"
						bundle="${propertie}" /></label><input id="passwInput" type="password"
					value="${usager.password}" name="password" />
			</div>
		</div>
		<c:choose>
			<c:when test="${empty usager.id}">
				<input type="submit" value="créer" name="create" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="modifier" name="edit" />
			</c:otherwise>
		</c:choose>
	</form>
</t:main>