<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Magic</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>    
    </head>
    <body>
        <c:forEach var="item" items="${requestScope['items']}">
            <div class="row">
                <div class="col-4">${item.name}</div>
                <div class="col-4">${item.description}</div>
                <div class="col-4">
                    <a href="modify?id=${item.id}">Módosítás</a>
                    <a href="delete?id=${item.id}">Tötlés</a>
                </div>
            </div>
        </c:forEach>    
        
        <form action="main" method="post">
            <fieldset>
                <legend>Új varázslat létrehozása</legend>
                <div>
                    <label>Varázslat neve:</label>
                    <input name="name">
                </div>
                <div>
                    <label>Leírás: </label>
                    <input name="description" >
                </div>
                <div>
                    <label>Sebzés: </label>
                    <input name="damage" >
                </div>
                <div>
                    <label>Költség: </label>
                    <input name="cost" >
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>