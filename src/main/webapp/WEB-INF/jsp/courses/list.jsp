<%@ include file="../header.jsp" %>

<h1>Listado de Cursos</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Codigo</th>
			<th>Nombre del Curso</th>
			<th>Inscriptos</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="course" items="${courses}">
		<tr>
			<td><c:out value="${course.code}"/></td>
			<td><c:out value="${course.name}"/></td>
			<td><c:out value="${course.enrolledStudents}"/></td>
			<td><c:url var="profile" value="/bin/courses/profile">
				<c:param name="course" value="${course.id}"/>
			</c:url>
			<a href="${profile}" title="Detalles"><i class="icon-search"></i></a></td></td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="../footer.jsp" %>