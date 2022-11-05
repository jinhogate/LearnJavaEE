<%@page import="java.util.Map"%>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>BIENVENUE SUR MA PAGE M. <c:out value="${auteur.name}" >Nom par défaut</c:out> </h1>
		<p>
			Affichage des informations de M. <c:out value="${auteur.name}" default="Mon nom"/> <br>
			Name : <c:out value="${auteur.name}" default="Mon nom"/> <br>
			FirstName : <c:out value="${auteur.firstName}" default=""/> <br>
			Statut : 
			<c:if test="${auteur.actif}" var="statut">
				<c:out value="${auteur.name}" default="Personne"/> <c:out value="${auteur.firstName}" default="Personne"/>
				 est actif
			</c:if> <br>
		</p>
		<p>
			Déclarons une variable avec la JSTL et affichons la. <br>
			<c:set var="old" value="25" scope="page"/>
			Age : <c:out value="${old}">Age default</c:out> <br>
			Modifions le prénom de notre auteur avec la JSTL <br>
			<c:set target="${auteur}" property="firstName" value="Kossi Jorjinho"/>
			FirstName : <c:out value="${auteur.firstName}" default="Prénom"/> <br>
			Vous êtes :
			<c:choose>
				<c:when test="${old<18}">Mineur</c:when>
				<c:when test="${old>=18 && old<30}">Majeur</c:when>
				<c:when test="${old>=30 && old<60}">Vieux</c:when>
				<c:otherwise>Agé</c:otherwise>
			</c:choose> <br>
			Utilisation des boucles <br>
			<c:forEach var="i" begin="0" end="10" step="1">
				Numero N° <c:out value="${i}"/> <br>
			</c:forEach>
			Parcourir les titres <br>
			*********************************************************************** <br>
			<c:forEach items="${titres}" var="titre" varStatus="status">
				Titre N° <c:out value="${status.count}"/> <c:out value="${titre}"/> <br>
				Index N° <c:out value="${status.index}"/> <br>
				Titre courant <c:out value="${status.current}"/> <br>
				<c:if test="${status.current=='Titanic'}">
					<h4>Meilleur film</h4>
				</c:if>
				Premier de la liste : <c:out value="${status.first}"/> <br>
				Dernier de la liste : <c:out value="${status.last}"/> <br>
				*********************************************************************** <br>
			</c:forEach>
			Itérons sur des éléments d'une liste <br>
			<c:forTokens items="J'apprends le langage JavaEE" delims=" " var="item">
				<c:out value="${item}"/> <br>
			</c:forTokens>
		</p>
	</body>
</html>