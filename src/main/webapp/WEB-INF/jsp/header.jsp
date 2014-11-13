<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" />
	</head>
	<body>
	
		<div class="navbar navbar-inverse navbar-fixed-top">
	      <div class="navbar-inner">
	        <div class="container">
	          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="brand" href="<c:url value="/bin/home/home"/>">Sistema de Matriculacion</a>
	          <div class="nav-collapse collapse">
	            <ul class="nav">
	              <li><a href="<c:url value="/bin/home/home"/>">Home</a></li>
	              <li><a href="<c:url value="/bin/courses/list"/>">Cursos</a></li>
	              <li><a href="<c:url value="/bin/students/list"/>">Alumnos</a></li>
	            </ul>
	            <ul class="nav pull-right">
					<c:if test="${not empty user}">
						<li><span><c:out value="${user.email}" /></span></li>
						<li> <a href="<c:url value="/bin/user/logout"/>">Cerrar sesion</a></span></li>
					</c:if>
					<c:if test="${empty user}">
						<li><a href="<c:url value="/bin/user/login"/>">Iniciar sesion</a></li>
					</c:if>
				</ul>
	          </div><!--/.nav-collapse -->
	        </div>
	      </div>
	    </div>

	    <div class="container">