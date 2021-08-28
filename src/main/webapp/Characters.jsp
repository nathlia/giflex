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
        <a href="index.jsp" class="giflex">Giflex</a>
        <div id="navbar_line"></div>
    </div>
    <div id="main">
        <h2>Genshin Impact Character Showcase</h2>
        <p>My Characters</p>
        <a href="addArtifact"><button>Add Artifact</button></a>

        <div id="add-character-button">
            <a class="add-character-button" href="addCharacter"><button>Add Character</button></a>
        </div>

        <p class="alt-color">Select a character</p>
        <section class="characters-tray">
            <c:forEach items="${characterList}" var="character">
                <%--<div class="character-card">--%>
                <div class="item">
                    <img src="img/characters/${character.getName()}.png" height="209" width="150"
                         id="character-card-img">
                    <div id="character-card-name">
                        <h3>${character.getName()}</h3>
                    </div>
                </div>
                <%--</div>--%>
            </c:forEach>


        </section>


        <%--add chara button--%>
        <%--show added characters--%>
        <%--clicking a character redirect to equipped artifacts--%>
    </div>
</div>
</body>
</html>


