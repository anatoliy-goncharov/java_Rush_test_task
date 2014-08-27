<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaRush Test | Registration Form</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">JavaRush Test |
			Registration Form</div>
		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="registerForm" modelAttribute="user" method="post"
			action="register">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input required="true" pattern="[0-9A-Za-zА-Яа-я\s]{1,25}" placeholder="Введите буквы/цифры" maxlength="25" autofocus="true" path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input pattern="\d{0,2}" type="number" min="18" max="99" path="age" /></td>
				</tr>
				<tr>
				    <td><form:checkbox path="admin" value="false" label="is Admin" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" />
					</td>
				</tr>
			</table>
		</form:form>

        <br></br>
        <a href="list"><input type="button" value="See all Users"></a><a href="search"><input type="button" value="Search User"></a>
	</center>
</body>
</html>
