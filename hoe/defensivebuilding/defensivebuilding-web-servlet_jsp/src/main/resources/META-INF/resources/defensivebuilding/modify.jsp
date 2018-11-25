<!DOCTYPE html>
<html>
    <head>
        <title>HOE - Defensive building modification</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="modify" method="post">
            <fieldset>
                <legend>Modify</legend>
                <div>
                    <label>Health </label>
                    <input name="health" value="${requestScope['item'].health}">
                </div>
                <div>
                    <label>Level </label>
                    <input name="level" value="${requestScope['item'].level}">
                </div>
                <div>
                    <label>Attacking point </label>
                    <input name="ap" value="${requestScope['item'].attackPoint}">
                </div>
                <div>
                    <label>Defensive point </label>
                    <input name="dp" value="${requestScope['item'].defensePoint}">
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>