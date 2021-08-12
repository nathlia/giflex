<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/11/2021
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Add Artifact</title>
    <style>
        <%@include file="./css/geral.css" %>
        /*<link rel="preconnect" href="https://fonts.googleapis.com">*/
        /*<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>*/
        <
        link href

        =
        "https://fonts.googleapis.com/css2?family=Merriweather:wght@700&family=Open+Sans&display=swap"
        rel

        =
        "stylesheet"
        >
    </style>
</head>
<body>

<div id="container">
    <div id="navbar">
        <h1 class="giflex">Giflex</h1>
        <div id="navbar_line"></div>
    </div>
    <div id="main">
        <h2>Genshin Impact Character Showcase</h2>
        <h3>Add Artifact</h3>
        <div id="character-card">
            <p>Character</p>
            <p>${character.name}</p>
        </div>
        <div id="add-artifact-form">
            <div id="add-main-stats">
                <form action="addArtifact" method="post">
                    &nbsp;
                    <label>Artifact Type:</label>
                    <select name="artifactType">
                        <c:forEach items="${artifactTypeList}" var="artifactType">
                            <option value="${artifactType.getArtifactTypeId()}"
                            >
                                    ${artifactType.getName()}
                            </option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <label>Artifact Set:</label>
                    <br/><br/>
                    <label>Main Stat:</label>
                    <br/><br/>
                    <label>Main Stat Value:</label>
                    <br/><br/>
                    <input type="submit" value="Show"/>
                </form>
            </div>
            <div id="add-sub-stats"></div>
        </div>
    </div>
</div>
</body>
</html>
