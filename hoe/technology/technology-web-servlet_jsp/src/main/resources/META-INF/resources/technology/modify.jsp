<!DOCTYPE html>
<html>
    <head>
        <title>HOE</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="modify" method="post">
            <fieldset>
                <legend>Módosítás</legend>
                <div>
                    <label>Technológia neve</label>
                    <input name="name" value="${requestScope['item'].name}">
                </div>
                <div>
                    <label>Technológia leírása</label>
                    <input name="description" value="${requestScope['item'].description}" >
                </div>
                <div>
                    <label>Minimális birodalom szint</label>
                    <input name="level" value="${requestScope['item'].empireLevel}" >
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>