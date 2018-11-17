<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editor</title>
    </head>
    <body>
        <h1>Pet Item Description Editor</h1>
        <form action="update" method="POST">
            Id: ${requestScope['item'].id} <input type="hidden" name="id" value="${requestScope['item'].id}"><br/>
            Name: <input type="text" name="ItemName" value="${requestScope['item'].name}"><br/>
            Description: <input type="text" name="ItemDescription" value="${requestScope['item'].description}"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>