<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/7/2021
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Characters</title>
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
        <div id="add-character-tray">
            <p>Character</p>
            <form action="addCharacter" method="post">
                <section class="add-character-centre">
                    <div class="add-character-form">
                        <div class="add-character-card">
                            <img src="img/characters/${character.getName()}.png" height="209" width="150"
                                 id="character-card-img">
                            <div id="character-card-name">
                                <h3>${character.getName()}</h3>
                            </div>
                        </div>
                    </div>
                    <div class="add-character-form">
                        <label>Level:</label>
                        <input type="text" name="level"/>
                        <br/><br/>
                        <label>Crit Rate:</label>
                        <input type="text" name="critRate"/>
                        <br/><br/>
                        <label>Crit DMG:</label>
                        <input type="text" name="critDmg"/>
                    </div>
                </section>
                <input type="hidden" name="characterId" value="${character.getCharacterId()}"/>
                <input type="hidden" name="name" value="${character.getName()}"/>
                <div id="add-character-button">
                    <input class="character" type="submit" value="Save">
                </div>
            </form>
            <a class="add-character-button"
               href="ArtifactSet?characterId=${character.getCharacterId()}">
                <button>Back</button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
