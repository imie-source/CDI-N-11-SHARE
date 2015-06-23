<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usagerList</title>
<link rel="stylesheet" type="text/css" href="css/base.css">

</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	<div class="container">
		<div class="content">
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
		</div>
	</div>
</body>
</html>