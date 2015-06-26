<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.general" var="propertie" />
<t:main>
	<div>
		<form method="POST">
			<input type="submit" class="icon createIcon" name="create" />
		</form>
	</div>
	<table>
		<tr>
			<th>nom</th>
			<th>prenom</th>
			<th>actions</th>
		</tr>
		<c:forEach items="${usagers}" var="usager" varStatus="loopStatus">
			<tr>
				<form method="POST">
					<td>${usager.nom}</td>
					<td>${usager.prenom}</td>
					<td><input type="hidden" value="${loopStatus.index+1}"
						name="numLigne" /><input type="submit" name="edit"
						class="icon editIcon" /><input type="submit" name="delete"
						class="icon delIcon" /></td>
				</form>
			</tr>
		</c:forEach>
	</table>
</t:main>