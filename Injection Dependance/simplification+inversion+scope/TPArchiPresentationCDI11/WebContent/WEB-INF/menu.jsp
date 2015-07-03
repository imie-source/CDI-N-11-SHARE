<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.general" var="propertie" />
<div id="menuContainer">
	<a href="home"><div id="menu0" class="menu">
			<fmt:message key="menu.home" bundle="${propertie}" />
		</div></a><a href="usagerList"><div id="menu1" class="menu">
			<fmt:message key="menu.usagers" bundle="${propertie}" />
		</div></a>
	<c:if test="${! empty connectionSessionBean.connectedUsager}">
		<a href="deconnexion">
			<div id="menu9" class="menu menuRight">
				<fmt:message key="menu.logout" bundle="${propertie}" />
			</div>
		</a>
		<div class="menu menuRight">${connectionSessionBean.connectedUsager.nom}</div>
	</c:if>
	<div class="menu menuRight">${connectionCountApplicationBean.connectionCount}</div>
</div>
<div>
	<span>${error}</span>
</div>