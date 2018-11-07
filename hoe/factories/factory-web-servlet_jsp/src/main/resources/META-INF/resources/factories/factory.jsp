<%-- 
    Document   : factory
    Created on : Oct 1, 2018, 4:31:03 PM
    Author     : Lóci
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Gyár menedzser oldal </h1><br/>
        <fieldset>
            <h3>Gyárak</h3>
           
            <table>
                
                <c:forEach var="fact" items="${factories}" varStatus="ln">
                    <td>${fact.name}</td>
                </c:forEach>   
            </table>
                <script>
                    function doChange() 
                    {
                        var val = document.getElementById("dropdown").value;
                        var e = document.getElementById("modname");
                        e.value = val;
                    }
                </script>
            <form method="post" action="factory" onchange="doChange()">        
                <select name="dropdown" id="dropdown">
                    <c:forEach var="fact" items="${factories}" varStatus="ln">
                        <option><c:out value="${fact.name}"/></option>
                        <br/>
                    </c:forEach>  
                </select><br/>
                <fieldset>
                    <h5>Módosítás:</h5><br/>
                    Név:<input type="text" name="modname" id="modname">
                    Leirás:<textarea name="moddesc"></textarea>
                    Mit:<input type="text" name="modprod">
                    Miből:<input type="text" name="modfrom">
                </fieldset>
                <select name="deletemod">
                    <option>DELETE</option>
                    <option>MODIFY</option>
                </select>
                <input type="submit" value="kiválasztás" name="sel">
            </form>
        </fieldset>
            <form method="post" action="factory">
                <div>
                    <span>Gyár neve</span>
                    <input type="text" name="fname">
                </div>
                <div>
                    <span>Gyár leírása</span>
                    <textarea name="fdesc"></textarea>
                </div>
                <div>
                    <span>Gyár terméke</span>
                    <textarea name="fprod"></textarea>
                </div>
                <div>
                    <span>Gyár miből gyárt</span>
                    <textarea name="ffrom"></textarea>
                </div>  
                <div>
                    <input type="submit" value="felvitel" name="new">
                </div>
            </form>        
    </body>
</html>
