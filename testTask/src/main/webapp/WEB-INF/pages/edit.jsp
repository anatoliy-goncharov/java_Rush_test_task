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

		<div style="color: teal; font-size: 30px">JavaRush Test | Edit Form</div>
		<c:url var="editUser" value="editUser.html" />
		<form:form id="EditForm" modelAttribute="user" method="post"
			action="update">
			<table width="400px" height="150px">
				<tr>
				    <td><form:label path="id">ID</form:label></td>
                    <td><form:input readonly="true" path="id" value="${user.id}" /></td>
				</tr>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input required="true" pattern="[0-9A-Za-zА-Яа-я]{1,25}" placeholder="Введите буквы/ цифры" maxlength="25" path="name" value="${user.name}" /></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input pattern="\d{0,2}" type="number" min="18" max="99" path="age" value="${user.age}"/></td>
				</tr>
				<tr>
                	<td><form:checkbox path="admin" value="${user.admin}" label="Is Admin" /></td>
                </tr>
                <tr>
                	<td><form:input type="hidden" path="createdDate" value="${user.createdDate}" /></td>
                </tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" />
					</td>
				</tr>
			</table>
		</form:form>
		<br></br>

        <a href="form"><input type="button" value="Add new User" /></a>
        <a href="list"><input type="button" value="See all Users"/></a>
        <a href="search"><input type="button" value="Search User"></a>
	</center>
</body>
</html>
