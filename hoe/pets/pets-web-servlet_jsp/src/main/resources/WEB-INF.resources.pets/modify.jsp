<!DOCTYPE html>
<html>
    <head>
        <title>HOE - Állat</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="modify" method="post">
            <fieldset>
                <legend>Módosítás</legend>
                <div>
                    <label>Állat neve</label>
                    <input name="name" value="${requestScope['item'].name}">
                </div>
                <div>
                    <label>Típus </label>
                    <input name="type" value="${requestScope['item'].type}" >
                </div>
                <div>
                    <label>Er?sség </label>
                    <input name="strength" value="${requestScope['item'].strength}" >
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>