
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Jármuvek</h1>
<h2>Módosítás/Törlés</h2>
<table>
    <tr><td></td><td>Jármu neve</td><td>Jármu leirása</td></tr>
    <c:forEach var="onevehicle" items="${vehicle}">
    <form method="get" action="vehiclemod" >
        <tr><td><input type="hidden" value="${onevehicle.id}" name="modid"</td><td><input type="text" value="${onevehicle.name}" name="modname"/></td><td><input type="text" value="${onevehicle.description}" name="moddesc"/></td>
        <td><input type="submit" value="modositas"></td>
    </form>
    <form method="get" action="vehicledelete" >
        <td><input type="hidden" value="${onevehicle.id}" name="delid"</td>
        <td><input type="submit" value="torles"</td>
    </form>
    </tr>
    
    </c:forEach>  
</table>

<h2>Új hozzáadás</h2>
        <form method="post" action="vehicle">
            <div>
                <span>Neve</span>
                <input type="text" name="vname">
            </div>
            <div>
                <span>Leírás</span>
                <textarea name="vdesc"></textarea>
            </div>
            <div>
                <input type="submit" value="felvitel" name="add">
            </div>
        </form>

