<%@page import="java.util.List"%>
<%@page import="hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DBU Manager</title>
        <style>
             table, th, td {
                border: 1px solid black;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Defensive Building Upgrades</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Hp</th>
                <th>Attack</th>
                <th>Defense</th>
                <th>Action</th>
            </tr>
            <%for(DefensiveBuildingUpgrade d : (List<DefensiveBuildingUpgrade>)request.getAttribute("dbus")){ %>
            <tr>
                <td>
                    <%= d.getId() %>
                </td>
                <td>
                    <%= d.getName() %>
                </td>
                <td>
                    <%= d.getHp()%>
                </td>
                <td>
                    <%= d.getAttack()%>
                </td>
                <td>
                    <%= d.getDefense() %>
                </td>
                <td>
                    <form id="update<%= d.getId() %>" action="update" method="GET">
                        <input type="hidden" name="id" value="<%= d.getId() %>" form="update<%= d.getId() %>">
                        <input type="submit" value="Update" form="update<%= d.getId() %>">
                    </form>
                    <form id="delete<%= d.getId() %>" action="delete" method="POST">
                        <input type="hidden" name="id" value="<%= d.getId() %>" form="delete<%= d.getId() %>">
                        <input type="submit" value="Remove" form="delete<%= d.getId() %>">
                    </form>
                </td>
            </tr>
            <%}%>
            
            <tr>
                <form id="save" method="POST" action="create">
                    <td></td>
                    <td>
                        <input type="text" name="name" form="save">
                    </td>
                    <td>
                        <input type="number" name="hp" form="save">
                    </td>
                    <td>
                        <input type="number" name="attack" form="save">
                    </td>
                    <td>
                        <input type="number" name="defense" form="save">
                    </td>
                    <td>
                        <input type="submit" value="Save" form="save">
                    </td>
                </form>    
            </tr>
            
        </table>
    </body>
</html>
