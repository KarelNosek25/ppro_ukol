<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.err {
		color : red;
	}
</style>
<title>Detail inzeratu</title>
</head>
<body>
	<h1>Detail inzeratu</h1>
	<form:form modelAttribute="inzerat">
		<table>
			<tr>
				<td>ID inzeratu</td>
				<td><form:input path="id" size="5"/></td>
				<td><form:errors path="id" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Kategorie</td>
				<td><form:input path="kategorie"/></td>
				<td><form:errors path="kategorie" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Text</td>
				<td><form:input path="text" size="100"/> </td>
				<td><form:errors path="text" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Cena</td>
				<td><form:input path="cena" size="5"/> ,-Kč</td>
				<td><form:errors path="cena" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Datum</td>
				<td><form:input path="datum" size="5"/> ,-Kč</td>
				<td><form:errors path="datum" cssClass="err"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="Uložit"/>	
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>