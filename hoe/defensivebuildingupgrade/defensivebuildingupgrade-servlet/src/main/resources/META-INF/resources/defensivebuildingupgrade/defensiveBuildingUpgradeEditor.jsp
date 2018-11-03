<%@page import="hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editor</title>
    </head>
    <body>
        <h1>Defensive Building Upgrade Editor</h1>
        <% DefensiveBuildingUpgrade dbu=(DefensiveBuildingUpgrade)request.getAttribute("dbu"); %>
        <form action="update" method="POST">
            Id: <%= dbu.getId() %> <input type="hidden" name="id" value="<%= dbu.getId() %>"><br/>
            Name: <input type="text" name="name" value="<%= dbu.getName() %>"><br/>
            Hp: <input type="number" name="hp" value="<%= dbu.getHp() %>"><br/>
            Attack: <input type="number" name="attack" value="<%= dbu.getAttack() %>"><br/>
            Defense: <input type="number" name="defense" value="<%= dbu.getDefense() %>"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
