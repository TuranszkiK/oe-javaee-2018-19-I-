<%--
  Created by IntelliJ IDEA.
  User: mfrohlich
  Date: 2018. 09. 28.
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Building Upgrade Editor</title>
</head>
<body>
<fieldset>
    <legend>All building upgrades</legend>
  
        <c:forEach var="upgrade" items="${ sessionScope['buildingupgrades']}">
            <form action="editor?update=true" method="post">
                <input type="text" name="editUpgradeId" enabled="false" value="${upgrade.id}"/>
                <input type="text" name="editUpgradeName" value="${upgrade.name}"/>
                <input type="text" name="editUpgradeDescription" value="${upgrade.description}"/>
                <input type="text" name="editUpgradeCost" value="${upgrade.cost}"/>
                <input type="text" name="editUpgradeBonusAttribute" value="${upgrade.bonusAttribute}"/>
                <input type="text" name="editUpgradeBonusAttributeValue" value="${upgrade.bonusAttributeValue}"/>
                <input type="submit" value="Mentés"/>
            </form>
        </c:forEach>
   
</fieldset>

<fieldset>
    <legend>Create new building upgrade</legend>
    <form method="post" action="editor">
        Név: <input type="text" name="newUpgradeName"/>
        <br>
        Leírás: <input type="text" name="newUpgradeDescription"/>
        <br>
        Költség: <input type="text" name="newUpgradeCost"/>
        <br>
        Bónusz neve: <input type="text" name="newUpgradeBonusAttribute"/>
        <br>
        Bónusz értéke: <input type="text" name="newUpgradeBonusAttributeValue"/>
        <br>
        <input type="submit" value="Létrehozás"/>
    </form>

<fieldset>
    <legend>Delete building upgrade</legend>
    <form method="post" action="editor?delete=true">
    <select name="deleteSelector">
        <c:forEach var="upgrade" items="${ sessionScope['buildingupgrades']}">
            <option value="${upgrade.id}">${upgrade.name}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Törlés"/>
    </form>
</fieldset>
</body>
</html>
