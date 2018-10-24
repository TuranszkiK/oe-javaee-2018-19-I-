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
        <title>Building</title>
    </head>
    <body>
        <h1>Building</h1>
        <form method="post" action="building">
            <div>
                <span>Id</span><br>
                <input type="text" readonly="readonly" name="id" value="<c:out value="${building.id}"/>" >
            </div>
            <div>
                <span>Name</span><br>
                <input type="text" name="name" value="<c:out value="${building.name}"/>">
            </div>
            <div>
                <span>Description</span><br>
                <textarea name="desc"><c:out value="${building.description}"/></textarea>
            </div>
            <div>
                <input type="submit" value="Submit">
            </div>
        </form>        
    </body>
</html>
