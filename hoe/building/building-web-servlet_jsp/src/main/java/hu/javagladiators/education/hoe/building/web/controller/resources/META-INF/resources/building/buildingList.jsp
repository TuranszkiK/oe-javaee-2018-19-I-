<%-- 
    Document   : building
    Created on : Sep 29, 2018, 10:06:33 AM
    Author     : cserof
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buildings</title>
    </head>
    <body>
        <h1>Buildings</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="building" items="${buildings}">
                <tr>
                    <th>${building.id}</th>
                    <th>${building.name}</th>
                    <th>${building.description}</th>
                    <th><a href="building?id=<c:out value='${building.id}' />">Edit</a></th>
                    <th><a href="building/delete?id=<c:out value='${building.id}' />">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
        <a href="building">New building</a>
    </body>
</html>
