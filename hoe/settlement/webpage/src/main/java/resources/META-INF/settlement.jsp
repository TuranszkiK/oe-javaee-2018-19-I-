<%-- 
    Document   : settlement
    Created on : Oct 3, 2018, 4:35:03 PM
    Author     : Tata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <b>Upload:</b>
        <br>
        <form method="post" action="settlement">
            Name: <input type="text" name="name">
            Description: <input type="text" name="description">
            <input type="hidden" name="method" value="upload">
            <input type="submit" value="Upload">
        </form>
        
        <br>
        <hr>
        <br>

        <form method="get" action="settlement">
            Find by id: <input type="number" name="id">
            <input type="hidden" name="method" value="get">
            <input type="submit" value="Get">
        </form>
        
        <br>
        <hr>
        <br>
        
        <form method="post" action="settlement">
            Delete this id: <input type="number" name="id">
            <input type="hidden" name="method" value="delete">
            <input type="submit" value="Delete">
        </form>
        
        <br>
        <hr>
        <br>
        
        <form method="post" action="settlement">
            Modify this id: <input type="number" name="id">
            New Name: <input type="text" name="name">
            New Description: <input type="text" name="description">
            <input type="hidden" name="method" value="modify">
            <input type="submit" value="Modify">
        </form>
        
    </body>
</html>
