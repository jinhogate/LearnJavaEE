<%@page import="java.util.Map"%>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>BIENVENUE SUR MA PAGE
			<c:if test="${!empty compte}">
				<c:choose>
					<c:when test="${compte.userBean.sexeUser=='M'}">Monsieur</c:when>
					<c:when test="${compte.userBean.sexeUser=='F'}">Madame</c:when>
					<c:otherwise>Autres</c:otherwise>
				</c:choose>
				<c:out value="${compte.userBean.nomUser}"/>
				<c:out value="${compte.userBean.prenomUser}"/>
			</c:if>
		</h1>
		<h2>
			<c:out value="Régalez vous"/>
		</h2>
		<p>
			Affichage de la liste des différents paramètres <br>
			${params.containsKey("name")?params.get("name")[0]:"Personne"}
		</p>
	</body>
</html>