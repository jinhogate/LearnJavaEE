<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>Bonjour, ${userName} , Nous apprenons ici le JavaEE</h1>
		<p>
			${userOld<30?"Jeune":"Vieux"} Monsieur! Bonne lecture!
		</p>
	</body>
</html>