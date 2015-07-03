<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="fr.imie.general" var="propertie" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application usager</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	<div class="container">
		<div class="content">
			<jsp:doBody/>
		</div>
	</div>
</body>
</html>