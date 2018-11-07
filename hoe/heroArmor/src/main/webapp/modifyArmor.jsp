<%-- 
    Document   : modifyArmor
    Created on : Oct 23, 2018, 8:48:19 PM
    Author     : szark
--%>
<%@page import="java.util.List"%>
<%@page import="hu.oe.hoe.heroarmor.datamodel.HeroArmor"%>
<%@ page import="hu.oe.hoe.heroarmor.utils.enums.*" %>
<% List<HeroArmor> armors = (List<HeroArmor>) session.getAttribute("heroarmors"); %>
<% HeroArmor model = (HeroArmor)session.getAttribute("modId"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify</title>
    </head>
    <body>
    <div class="container body-content">
    <h2>Modify</h2>
    <h4>Armor</h4>
    <hr />
    <div class="row col-md-4">
        <form method="post" action="modify?update=true">
            <div class="form-group">
                <label class="control-label">Name</label>
                <input name="editArmorName" class="form-control" value="${sessionScope["modId"].getName()}" />
            </div>
            <div class="form-group">
                <label class="control-label">Description</label>
                <input type="text" name="editArmorDescription" class="form-control" value="${sessionScope["modId"].getDescription()}"/>
            </div>
            <div class="form-group">
                <label class="control-label">Armor</label>
                <input type="number" name="editArmor" class="form-control" value="${sessionScope["modId"].getArmor()}"/>
            </div>
            <div class="form-group">
                <label class="control-label">Armor type</label>
                <input type="text" list="armorType" name="editArmorType" class="form-control" value="${sessionScope["modId"].getArmorType()}"/>
                <datalist id="armorType">
                    <c:forEach var="type" items="<%=ArmorType.values()%>">
                        <option>${type.toString()}</option>
                    </c:forEach>
                </datalist>
            </div>
            <div class="form-group">
                <label class="control-label">Armor part</label>
                <input type="text" list="armorPart" name="editArmorPart" class="form-control" value="${sessionScope["modId"].getArmorPart()}"/>
                <datalist id="armorPart">
                    <c:forEach var="type" items="<%=ArmorPart.values()%>">
                        <option>${type.toString()}</option>
                    </c:forEach>
                </datalist>
            </div>
            <div class="form-group">
                <label class="control-label">Durability</label>
                <input type="text" list="durability" name="editArmorDurability" class="form-control" value="${sessionScope["modId"].getDurability()}"/>
                <datalist id="durability">
                    <c:forEach var="type" items="<%=Durability.values()%>">
                        <option>${type.toString()}</option>
                    </c:forEach>
                </datalist>
            </div>
                <div class="form-group">
                    <label class="control-label">Status</label>
                    <input type="text" list="status" name="active" class="form-control" value="${sessionScope["modId"].isActive()}"/>
                    <datalist id="status">
                        <option>true</option>
                        <option>false</option>
                    </datalist>
                </div>
            <div class="form-group">
                <input type="hidden" name="editArmorId" value="${sessionScope["modId"].getId()}"
                
            </div>
                <div class="form-group">
                <input type="submit" value="Save" class="btn btn-primary">
                </div>
        </form>
    </div>
</div>
    </body>
</html>
