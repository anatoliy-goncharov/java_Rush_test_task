<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaRush Test | Edit Form</title>
</head>
<body>
	<center>
		<div style="color: teal; font-size: 30px">JavaRush Test | Search Form</div>
		<c:url var="searchUser" value="searchUser.html" />
		<form:form id="SearchForm" modelAttribute="user" method="post"
			action="searchUser">
			<table width="250px" height="50px">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input required="true" maxlength="25" pattern="[0-9A-Za-zА-Яа-я]{1,25}" autofocus = "true" path="name" placeholder="Введите буквы/цифры"/></td>
					<td><input type="submit" value="Search" />
				</tr>
			</table>
		</form:form>
		<br></br>
        <a href="list"><input type="button" value="See all Users" /></a>
        <a href="form"><input type="button" value="Add new User" /></a>
	</center>
</body>
</html>
