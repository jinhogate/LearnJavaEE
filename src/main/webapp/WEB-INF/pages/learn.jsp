<%@ include file="includes/entete.jsp" %>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>Bonjour, <% out.print(request.getAttribute("userName"));%>, Nous apprenons ici le JavaEE</h1>
		<p>
			<% int old = (int) request.getAttribute("userOld"); %>
			Vous êtes un <% out.print(old<30?"Jeune":"Vieux"); %> Monsieur! Bonne lecture!
		</p>
		<p>
			<% while(old!=0){
				out.println("Tourner en rond! <br>");
				old--;
			} %>
		</p>
	</body>
</html>