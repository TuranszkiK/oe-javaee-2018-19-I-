<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Item Manager</title>
        <style>
             table, th, td {
                border: 1px solid black;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>PET Items</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
            <c:forEach var="item" items="${requestScope['items']}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>
                    <form id="update${item.id}" action="update" method="GET">
                        <input type="hidden" name="id" value="${item.id}" form="update${item.id}">
                        <input type="submit" value="Update" form="update${item.id}">
                    </form>
                    <form id="delete${item.id}" action="delete" method="POST">
                        <input type="hidden" name="id" value="${item.id}" form="delete${item.id}">
                        <input type="submit" value="Remove" form="delete${item.id}">
                    </form>
                </td>
            </tr>
            </c:forEach>
            
            <tr>
                <form id="save" method="POST" action="create">
                    <td></td>
                    <td>
                        <input type="text" name="ItemName" form="save">
                    </td>
                    <td>
                        <input type="text" name="ItemDescription" form="save">
                    </td>
                    <td>
                        <input type="submit" value="Save" form="save">
                    </td>
                </form>    
            </tr>
            
        </table>
    </body>
</html>