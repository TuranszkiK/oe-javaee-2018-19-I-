<%-- 
    Document   : abilities
    Created on : Nov 25, 2018, 10:15:05 PM
    Author     : Kristóf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abilities</title>
    </head>
    <body>
        <h1>Abilities</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>>
                <th>Type</th>>
                <th>Value</th>>
                <th>Cooldown</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="ability" items="${abilities}">
                <tr>
                    <th>${ability.id}</th>
                    <th>${ability.name}</th>
                    <th>${ability.description}</th>
                    <th>${ability.type}</th>
                    <th>${ability.value}</th>
                    <th>${ability.cooldown}</th>
                    <th><a href="edit?id=<c:out value='${ability.id}' />">Edit</a></th>
                    <th><a href="delete?id=<c:out value='${ability.id}' />">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
        <a href="edit">New building</a>
    </body>
</html>
