<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <title>STO</title>
</head>

<h1>Points List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Price</th><td>Name</td><td>Count</td><th>Edit</th><th>Delete</th><%--<th>View Cert</th>--%></tr>
    <c:forEach var="point" items="${points}">
        <tr>
            <td>${point.id}</td>
            <td>${point.price}</td>
            <td>${point.name}</td>
            <td>${point.count}</td>
            <td><a href="editPoint/${point.id}">Edit</a></td>
            <td><a href="deletePoint/${point.id}">Delete</a></td>
            <%--<td><a href="point?pointId=${point.id}">View point</a></td>--%>
        </tr>
    </c:forEach>
</table>
<br/>
<%--<a href="createNewCertificate">Create new Certificate</a>--%>
<%--<a href="getCert">Back</a>--%>