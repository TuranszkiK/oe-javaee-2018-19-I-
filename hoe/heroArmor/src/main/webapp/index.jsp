<%-- 
    Document   : index
    Created on : Oct 10, 2018, 1:19:18 AM
    Author     : szark
--%>

<%@ page import="hu.oe.hoe.heroarmor.datamodel.HeroArmor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="org.apache.commons.lang3.reflect.FieldUtils" %>

<% List<HeroArmor> armors = (List<HeroArmor>) session.getAttribute("heroarmors"); %>
<% List<Field> fields = FieldUtils.getAllFieldsList(HeroArmor.class); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <title>Armors</title>
</head>
<body>
<div class="container body-content">
    <h4>Armory</h4>
    <table class="table">
        <thead>
        <tr>
            <c:forEach var="field" items="<%=fields%>">
                <th>${field.getName()}</th>
            </c:forEach>
                <th></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="armor" items="${sessionScope['heroarmors']}">
            <tr>
                <td>${armor.id}</td>
                <td>${armor.name}</td>
                <td>${armor.description}</td>
                <td>${armor.armor}</td>
                <td>${armor.armorType}</td>
                <td>${armor.armorPart}</td>
                <td>${armor.durability}</td>
                <td>${armor.active}</td>
                <td>
                    <form method="post" action="modify?delete=true">
                        <input type="hidden" name="deleteSelected" value="${armor.id}"/>
                        <input type="submit" value="Delete" class="btn btn-danger"/>
                    </form>
                        <a href="nav?id=${armor.id}" class="btn btn-primary">Modify</a>
                        <!--<form method="get" action="modify">
                            <input type="hidden" name="id" value="${armor.id}"/>
                            <intput type="button" class="btn btn-primary" value="Modify"/>
                        </form>-->
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="addArmor.jsp" class="btn btn-primary float-right">Add new armor</a>
</div>
</body>
