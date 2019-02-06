<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
    <title>STO</title>
</head>

<h1>Edit Point</h1>
<form:form method="POST" action="/spring-mvc-web-xml/editPoint" commandName="point">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>