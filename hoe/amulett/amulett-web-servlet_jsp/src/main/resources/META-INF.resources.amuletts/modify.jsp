<!DOCTYPE html>
<html>
    <head>
        <title>HOE -   Amulett</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="modify" method="post">
            <fieldset>
                <legend>Módosítás</legend>
                <div>
                    <label>Amulett neve</label>
                    <input name="name" value="${requestScope['item'].name}">
                </div>
                <div>
                    <label>Amulett leírása </label>
                    <input name="description" value="${requestScope['item'].description}" >
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>