<c:if test="${!empty sessionScope.compteSession.userBean}">
	<c:set var="user" value="${compteSession.userBean}" scope="session"/>
	<h1>
		<c:choose>
			<c:when test="${user.sexeUser=='M'}">Monsieur </c:when>
			<c:when test="${user.sexeUser=='F'}">Madame </c:when>
			<c:otherwise>Autre</c:otherwise>
		</c:choose>
		<c:out value="${user.nomUser} ${user.prenomUser}"/> est connecté!
	</h1> <br>
</c:if>
<c:out value="${compte.userBean.nomUser}"></c:out>
<ul>
  <li> <a href="accueil">ACCEUIL</a> </li>
  <li> <a href="learn">LEARN</a> </li>
  <li> <a href="fichier">FICHIER</a> </li>
  <li> <a href="auteur">AUTEUR</a> </li>
  <li> AUTRES </li>
</ul>
