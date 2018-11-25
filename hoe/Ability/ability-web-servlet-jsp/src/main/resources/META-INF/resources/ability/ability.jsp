<%-- 
    Document   : ability
    Created on : Nov 25, 2018, 11:06:49 PM
    Author     : Kristóf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ability</title>
    </head>
    <body>
        <h1>Ability</h1>
        <form method="post" action="edit">
            <div>
                <span>Id</span><br>
                <input type="text" readonly="readonly" name="id" value="<c:out value="${ability.id}"/>" >
            </div>
            <div>
                <span>Name</span><br>
                <input type="text" name="name" value="<c:out value="${ability.name}"/>">
            </div>
            <div>
                <span>Description</span><br>
                <textarea name="desc"><c:out value="${ability.desc}"/></textarea>
            </div>
            <div>
                <span>Type</span><br>
                <input type="text" name="name" value="<c:out value="${ability.type}"/>">
            </div>
            <div>
                <span>Value</span><br>
                <input type="number" name="name" value="<c:out value="${ability.value}"/>">
            </div>
            <div>
                <span>Cooldown</span><br>
                <input type="number" name="name" value="<c:out value="${ability.cooldown}"/>">
            </div>
            <div>
                <input type="submit" value="Submit">
            </div>
        </form>        
    </body>
</html>
