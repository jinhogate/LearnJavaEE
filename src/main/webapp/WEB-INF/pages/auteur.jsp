<%@page import="java.util.Map"%>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>BIENVENUE SUR MA PAGE M. ${auteur.name}</h1>
		<p>
			Affichage des informations de M. ${auteur.name} <br>
			Name : ${auteur.name} <br>
			FirstName : ${auteur.firstName} <br>
			Actif : ${auteur.actif?"Yes":"No"} <br>
		</p>
	</body>
</html>