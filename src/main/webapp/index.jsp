<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/7/2021
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Giflex</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@700&family=Open+Sans&display=swap"
          rel="stylesheet">
    <style>
        <%@include file="./css/geral.css"%>
    </style>
</head>
<body>
<div id="container">
    <div id="navbar">
        <h1 class="giflex">Giflex</h1>
        <div id="navbar_line"></div>
    </div>
    <div id="main">
        <a href="addArtifact">Add Artifact</a>
        <h3>${status}</h3>
        <c:if test="${status == 'OK'}">
            <h2>Artifact added with success</h2>
        </c:if>
        <%--add chara button--%>
        <%--show added characters--%>
        <%--clicking a character redirect to equipped artifacts--%>
    </div>
</div>
</body>
</html>


