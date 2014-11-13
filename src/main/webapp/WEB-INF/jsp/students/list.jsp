<%@ include file="../header.jsp" %>

<h1>Listado de Alumnos</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Legajo</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${students}">
		<tr>
			<td><c:out value="${student.studentNumber}"/></td>
			<td><c:out value="${student.firstName}"/></td>
			<td><c:out value="${student.lastName}"/></td>
			<c:url var="profile" value="/bin/students/profile">
				<c:param name="student" value="${student.id}"/>
			</c:url>
			<td><a href="${profile}" title="Perfil"><i class="icon-search"></i></a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="../footer.jsp" %>