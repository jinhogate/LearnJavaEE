<html>
	<%@ include file="includes/header.jsp"%>
	<body>
		<h1>BIENVENUE SUR J2I</h1>
		<p>
			<form action="accueil" method="post">
				<p>
					<c:if test="${ !empty message}">
						<c:out value="${message}"/>
					</c:if>
				</p> 
				<br>
				<div>
					<label for="login">Login</label>
					<input type="text" id="login" name="login" value='<c:out value="${!empty login?login:''}"/>'>
				</div>
				<br>
				<div>
					<label for="pass">Pass</label>
					<input type="password" id="pass" name="pass" value='<c:out value="${!empty pass?pass:''}"/>'>
				</div>
				<br>
				<input type="submit" value="Se Connecter">
			</form>
		</p>
	</body>
</html>