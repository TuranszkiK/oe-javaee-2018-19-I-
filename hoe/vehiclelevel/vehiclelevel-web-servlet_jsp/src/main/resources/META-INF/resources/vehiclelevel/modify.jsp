<!DOCTYPE html>
<html>
    <head>
        <title>Vehicle Level</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="modify" method="post">
            <fieldset>
                <legend>Modify</legend>
                <div>
                    <label>Name</label>
                    <input name="name" value="${requestScope['item'].name}">
                </div>
                <div>
                    <label>Description</label>
                    <input name="description" value="${requestScope['item'].desc}" >
                </div>
                <div><input type="submit"></div>            
        </form>
    </body>
</html>