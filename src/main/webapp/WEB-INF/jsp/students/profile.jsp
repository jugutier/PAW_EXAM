<%@ include file="../header.jsp" %>

<h1>Perfil del Alumno</h1>
<dl>
	<dt>Legajo</dt>
	<dd><c:out value="${student.studentNumber}"/></dd>
	<dt>Nombre</dt>
	<dd><c:out value="${student.firstName}"/></dd>
	<dt>Apellido</dt>
	<dd><c:out value="${student.lastName}"/></dd>
	<dt>Materias que cursa</dt>
	<dd>
		<ul>
		<c:forEach var="course" items="${student.courses}">
			<li><c:out value="${course.code}"/> - <c:out value="${course.name}"/> - 
			<form method="POST" action="unenroll" class="form-inline unenroll-form">
				<input type="hidden" name="student" value="<c:out value="${student.id}"/>"/>
				<input type="hidden" name="course" value="<c:out value="${course.id}"/>"/>
				<input type="submit" value="Desmatricular" class="btn btn-link"/>
			</form></li>
		</c:forEach>
		</ul>
	</dd>
</dl>
<h2>Matricular</h2>
<form:form method="POST" action="enroll" commandName="enrollForm">
	<fieldset>
		<legend>Curso a matricular</legend>
		<form:errors path="*" />
		<form:input type="hidden" path="student" value="${student.id}" />
		<form:select path="course" class="span6">
			<c:forEach var="course" items="${enrollableCourses}">
				<option value="<c:out value="${course.id}"/>"><c:out value="${course.code}"/> - <c:out value="${course.name}"/></option>
			</c:forEach>
		</form:select>
	</fieldset>
	<div class="form-actions">
		<input type="submit" value="Matricular" class="btn btn-primary"/>
	</div>
</form:form>


<%@ include file="../footer.jsp" %>