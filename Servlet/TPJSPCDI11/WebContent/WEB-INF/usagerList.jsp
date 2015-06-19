<%@page import="fr.imie.DTO.UsagerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usagerList</title>
<link rel="stylesheet" type="text/css" href="css/base.css">

</head>
<body>
	<%@ include file="menu.jspf"%>
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
				<%
					List<UsagerDTO> dtos = (List<UsagerDTO>) session
							.getAttribute("usagers");
				    Integer cpt=1;
					for (UsagerDTO usagerDTO : dtos) {
				%>
				<tr>
					<form method="POST">
					<td><%= usagerDTO.getNom()%></td>
					<td><%= usagerDTO.getPrenom()%></td>
					<td><input type="hidden" value="<%=cpt++%>" name="numLigne" /><input
						type="submit" name="edit" class="icon editIcon" /><input
						type="submit" name="delete" class="icon delIcon" /></td>
					</form>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>