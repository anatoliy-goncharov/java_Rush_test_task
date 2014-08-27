<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JavaRush | User Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">JavaRush Test | User Details</div>

		<c:if test="${!empty userList}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">

					<td>ID</td>
					<td>Name</td>
					<td>Age</td>
					<td>Is Admin</td>
					<td>Created Date</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.age}" /></td>
                        <td><c:out value="${user.admin}" /></td>
                        <td><c:out value="${user.createdDate}" /></td>
                        <td><a href="edit?id=${user.id}">Edit</a></td>
						<td><a href="delete?id=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
            <a href="prevPage">Prev. page</a>
            <a href="nextPage">Next page</a>
        <br></br>
		<a href="form"><input type="button" value="Add new User" /></a>
		<a href="search"><input type="button" value="Search User"></a>
	</center>
</body>
</html>
