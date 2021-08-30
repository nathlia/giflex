<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/11/2021
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Artifact</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@700&family=Open+Sans&display=swap"
          rel="stylesheet">

    <style>
        <%@include file="./css/geral.css" %>
    </style>
</head>
<body>

<div id="container">
    <div id="navbar">
        <a href="index.jsp" class="giflex">Giflex</a>
        <div id="navbar_line"></div>
    </div>
    <div id="main">
        <h2>Genshin Impact Character Showcase</h2>
        <p>Add Artifact</p>
        <div class="add-character-card">
            <img src="img/characters/${character.getName()}.png" height="209" width="150"
                 id="character-card-img">
            <div id="character-card-name">
                <h3>${character.getName()}</h3>
            </div>
        </div>
        <div id="add-artifact-form">
            <div id="add-main-stats">
                <form action="addArtifact" method="post">
                    <label>Artifact Type:</label>
                    <select name="artifactType">
                        <c:forEach items="${artifactTypeList}" var="artifactType">
                            <option value="${artifactType.getArtifactTypeId()}">
                                    ${artifactType.getName()}
                            </option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <label>Artifact Set:</label>
                    <select name="artifactSet">
                        <c:forEach items="${artifactSetTypeList}" var="artifactSet">
                            <option value="${artifactSet.getArtifactSetTypeId()}">
                                    ${artifactSet.getName()}
                            </option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <label>Main Stat:</label>
                    <select name="mainStat">
                        <c:forEach items="${artifactMainStat}" var="mainStat">
                            <option value="${mainStat.getSubstatId()}">
                                    ${mainStat.getName()}
                            </option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <label>Main Stat Value:</label>
                    <input type="text" name="mainStatValue"/>
                    <br/><br/>
                    <input type="hidden" name="characterId" value="${character.getCharacterId()}"/>
                    <div id="save-button">
                        <input type="submit" value="Save"/>
                    </div>
                </form>
            </div>
            <div id="add-sub-stats"></div>
        </div>
    </div>
</div>
</body>
</html>
