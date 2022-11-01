<%@page import="java.util.Map"%>
<%@ include file="includes/entete.jsp" %>
<html>
	<%@ include file="includes/header.jsp" %>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<% 
			String name = (String) request.getAttribute("name");
			Map<String, String[]> params = (Map<String, String[]>) request.getAttribute("params");
		%>
		<h1>BIENVENUE SUR MA PAGE M. <%out.print(name);%></h1>
		<p>
			Affichage de la liste des différents paramètres <br>
			<%
				for(String key : params.keySet()){
					out.print(key + "=" + params.get(key)[0]+ "<br>");
				}
			%>
		</p>
	</body>
</html>