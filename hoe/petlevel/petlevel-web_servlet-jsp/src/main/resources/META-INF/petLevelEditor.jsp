<%@page import="hu.javagladiators.education.hoe.petlevel.dao.PetLevel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editor</title>
    </head>
    <body>
        <h1>Defensive Building Upgrade Editor</h1>
        <% PetLevel dbu=(PetLevel)request.getAttribute("dbu"); %>
        <form action="/Update" method="POST">
            Id: <%= dbu.getId() %> <input type="hidden" name="id" value="<%= dbu.getId() %>"><br/>
            LevelName: <input type="text" name="levelName" value="<%= dbu.getLevelName() %>"><br/>
            FromLevel: <input type="number" name="fromLevel" value="<%= dbu.getFromLevel() %>"><br/>
            UntilLevel: <input type="number" name="untilLevel" value="<%= dbu.getUntilLevel() %>"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>