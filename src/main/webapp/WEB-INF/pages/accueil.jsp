<%@page import="java.util.Map"%>
<%@ include file="includes/entete.jsp" %>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>BIENVENUE SUR MA PAGE M. ${name}</h1>
		<p>
			Affichage de la liste des différents paramètres <br>
			${params.containsKey("name")?params.get("name")[0]:"Personne"}
		</p>
	</body>
</html>