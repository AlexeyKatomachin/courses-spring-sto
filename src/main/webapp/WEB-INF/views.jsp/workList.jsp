<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <title>STO</title>
</head>

<h1>Certificate Of Completion List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Total Amount</th><th>Point</th><th>Edit</th><th>Delete</th><th>View Cert</th></tr>
    <c:forEach var="cert" items="${cert}">
        <tr>
            <td>${cert.totalAmount}</td>
            <td>
                <table border="2" width="70%" cellpadding="2">
                    <tr><th>Id</th><th>Price</th><th>Name</th><th>Count</th><th>Edit</th><th>Delete</th><th>View Point</th></tr>
                    <c:forEach var="point" items="${cert.points}">
                        <td>${point.id}</td>
                        <td>${point.price}</td>
                        <td>${point.name}</td>
                        <td>${point.count}</td>
                        <td><a href="editPoint/${point.id}">Edit</a></td>
                        <td><a href="deletePoint/${point.id}">Delete</a></td>
                        <td><a href="point?pointId=${point.id}">View point</a></td>
                    </c:forEach>
                </table>
            </td>
            <td><a href="editCert/${cert.id}">Edit</a></td>
            <td><a href="deleteCert/${cert.id}">Delete</a></td>
            <td><a href="cert?certId=${cert.id}">View book</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="createNewCertificate">Create new Certificate</a>
<a href="getCert">Back</a>