<%@ include file="../header.jsp" %>

<h1>Home</h1>
<p>Bienvenido, <em><c:out value="${user.email}" /></em>, al Sistema de Matriculacion</p>
<c:if test="${user.student != null}">
	<h2>Cursos actuales</h2>
	<ul>
		<c:forEach var="course" items="${user.student.courses}">
			<li><c:out value="${course.code}" /> - <c:out value="${course.name}" /> 
			<c:url var="profile" value="/bin/courses/profile">
				<c:param name="course" value="${course.id}" />
			</c:url> <a href="${profile}" title="Detalles"><i class="icon-search"></i></a></li>
		</c:forEach>
	</ul>
</c:if>


<%@ include file="../footer.jsp" %>
