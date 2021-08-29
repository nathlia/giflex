<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/28/2021
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Artifact Set</title>
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
        <a href="index.jsp" class="giflex">Giflex</a>
        <div id="navbar_line"></div>
    </div>
    <div id="main">
        <h2>Genshin Impact Character Showcase</h2>
        <p>Artifact Set</p>

        <section class="character-status-card">
            <c:forEach items="${listCharacter}" var="character">
                <div class="item" id="item">
                    <img src="img/characters/${character.getName()}.png" height="209" width="150"
                         id="character-card-img">
                    <div id="character-card-name">
                        <h3>${character.getName()}</h3>
                    </div>
                    <div id="character-card-status">
                        <h4>Level: ${character.getLevel()}</h4>
                        <h4>Crit Rate: ${character.getCritRate()}</h4>
                        <h4>Crit DMG: ${character.getCritDmg()}</h4>
                    </div>
                </div>
            </c:forEach>
        </section>
        <section class="artifacts-tray">
            <c:forEach items="${artifactList}" var="artifact">

            </c:forEach>

        </section>
        <%--add chara button--%>
        <%--show added characters--%>
        <%--clicking a character redirect to equipped artifacts--%>
    </div>
</div>

</body>
</html>
