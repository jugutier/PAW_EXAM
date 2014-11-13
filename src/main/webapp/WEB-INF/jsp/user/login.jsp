<%@ include file="../header.jsp" %>

<form:form method="POST" action="login" commandName="loginForm" class="form-signin">
	<h2 class="form-signin-heading">Login</h2>
	<form:errors path="*" cssClass="error"/>
	<form:input path="email" class="input-block-level" placeholder="Email"/>
	<form:password path="password" class="input-block-level" placeholder="Password"/>
	<input type="submit" name="submit" value="Ingresar" class="btn btn-large btn-primary"/>
</form:form>

<%@ include file="../footer.jsp" %>