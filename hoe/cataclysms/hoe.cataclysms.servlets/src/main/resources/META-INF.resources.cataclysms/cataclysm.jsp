<%-- 
    Document   : cataclysm
    Created on : Oct 4, 2018, 5:06:00 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Heroes Of Empires - Cataclysms</title>
    </head>
 
    <body>
        <div>
        <h3>All Cataclysms in the database:</h3>
        <br>
        <c:forEach items="${applicationScope['all']}" var="cat">
            <form action="/cataclysm?action=update" method="post">
                <input type="text" name="id" value="${cat.id}"/>   
                <input type="text" name="empireId" value="${cat.empireId}"/>
                <input type="text" name="description" value="${cat.description}"/>
                <input type="text" name="intensity" value="${cat.intensity}"/>
                <input type="text" name="damage" value="${cat.damage}"/>
                <input type="date" name="date" value="${cat.date}"/>
                <input type="time" name="time" value="${cat.time}"/>
                <input type="submit" value="Save changes"/>
            </form>
    </c:forEach>
        
        <h3>Add new:</h3>
        <form action="/cataclysm?action=add" method="post">
                Empire ID:
                <input type="text" name="empireId">
                Description:
                <input type="text" name="description"/>
                Intensity:
                <input type="text" name="intensity"/>
                Damage:
                <input type="text" name="damage">
                Date:
                <input type="date" name="date"/>
                Time:
                <input type="time" name="time"/>
                <input type="submit" value="Save changes"/>
            </form>
        </div>
    </body>
</html>
