<%@page import="java.util.Map"%>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>BIENVENUE SUR MA PAGE M. ${name}</h1>
		<h2>
			<c:out value="R�galez vous"/>
		</h2>
		<p>
			Affichage de la liste des diff�rents param�tres <br>
			${params.containsKey("name")?params.get("name")[0]:"Personne"}
		</p>
	</body>
</html>