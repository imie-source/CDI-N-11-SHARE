<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.general" var="propertie" />
<t:main>
	<form method="POST">
		<div>
			<label for="loginInput">login : </label><input id="loginInput"
				type="text" value="" name="login">
		</div>
		<div>
			<label for="passwInput">mot de passe : </label><input id="passwInput"
				type="text" value="" name="passw" />
		</div>
		<input type="submit" name="login" />
	</form>
</t:main>
