<%@page import="java.util.Map"%>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<c:set var="etudiantListe" value="${etudiants}" scope="page"/>
		<c:if test="${!empty etudiantListe}">
		<h1>La liste des étudiants:</h1> <br>
			**************************************************************
			<c:forEach items="${etudiantListe}" var="etudiant">
				<li>id : <c:out value="${etudiant.id}"/> </li> <br>
				<li>Nom : <c:out value="${etudiant.nom}"/> </li> <br>
				<li>Prenom : <c:out value="${etudiant.prenom}"/> </li> <br>
				<li>Sexe : <c:out value="${etudiant.sexe}"/> </li> <br>
			*************************************************************** <br>
			</c:forEach>
		</c:if>
		<h1>Ajouter un étudiant</h1>
		<div style="color: red;">
			<c:if test="${!empty erreur}">
				<c:out value="${erreur}"/>
			</c:if>
		</div>
		<form action="etudiants" method="post">
			<div>
				<label for="nom">Nom</label>
				<input type="text" id="nom" name="nom"/>
			</div>
			<br>
			<div>
				<label for="prenom">Prenom</label>
				<input type="text" id="prenom" name="prenom"/>
			</div>
			<br>
			<div>
				<label for="sexe">Sexe</label>
				<input type="text" id="sexe" name="sexe"/>
			</div>
			<br>
			<input type="submit" value="Ajouter Etudiant">
		</form>
	</body>
</html>