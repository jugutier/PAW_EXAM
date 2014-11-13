<%@ include file="../header.jsp" %>

<h1>Informacion del Curso</h1>
<dl>
	<dt>Codigo</dt>
	<dd><c:out value="${course.code}"/></dd>
	<dt>Nombre</dt>
	<dd><c:out value="${course.name}"/></dd>
	<dt>Alumnos</dt>
	<dd>
		<ul>
		<c:forEach var="student" items="${course.students}">
			<li><c:out value="${student.studentNumber}"/> - <c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/> - 
			<c:url var="profile" value="/bin/students/profile">
				<c:param name="student" value="${student.id}"/>
			</c:url>
			<a href="${profile}" title="Perfil"><i class="icon-search"></i></a></li>
		</c:forEach>
		</ul>
	</dd>
</dl>

<%@ include file="../footer.jsp" %>