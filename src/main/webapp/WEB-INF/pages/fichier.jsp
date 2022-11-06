<html>
	<%@ include file="includes/header.jsp"%>
	<body>
		<%@ include file="includes/menu.jsp" %>
		<h1>Envoyer un fichier</h1>
    	<c:if test="${ !empty fichier }">
    	<p>	<c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /> </p> <br>
    	</c:if>
		<p>
			<form action="fichier" method="post" enctype="multipart/form-data">
				<div>
					<label for="description">Description</label>
					<input type="text" id="description" name="description">
				</div>
				<br>
				<div>
					<label for="fichier">Importer fichier</label>
					<input type="file" id="fichier" name="fichier">
				</div>
				<br>
				<input type="submit" value="Envoyer">
			</form>
		</p>
	</body>
</html>