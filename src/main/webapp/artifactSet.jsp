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
        <section class="artifacts-tray">
            <div class="character-status-card">
                <div class="item" id="item">
                    <img src="img/characters/${character.getName()}.png" height="209" width="150"
                         id="character-card-img">
                    <div id="character-card-name">
                        <h3>${character.getName()}</h3>
                    </div>
                    <div class="character-card-status">
                        <p class="artifact-set-letter">Level: ${character.getLevel()}</p>
                        <p class="artifact-set-letter">Crit Rate: ${character.getCritRate()}</p>
                        <p class="artifact-set-letter">Crit DMG: ${character.getCritDmg()}</p>
                        <div id="add-character-button">
                            <a class="add-character-button"
                               href="addCharacter?characterId=${character.getCharacterId()}">
                                <button>Edit</button>
                            </a>
                        </div>
                        <a class="set-back-button"
                           href="characters">
                            <button>Back</button>
                        </a>
                    </div>
                </div>
            </div>
            <section class="artifacts">
                <c:forEach items="${artifactList}" var="artifact">
                    <div class="artifact">
                        <p class="artifact-set-type">${artifact.getArtifactType().getName()}</p>
                        <div class="artifact-box">
                            <div class="artifact-box-add">
                                <a href="addArtifact?characterId=${character.getCharacterId()}">
                                    <span class="hyperspan"></span>
                                </a>
                                <p class="artifact-set-name">${artifact.getArtifactSetType().getName()}</p>
                                <p class="artifact-mainstat">${artifact.getMainStat().getName()}
                                    : ${artifact.getMainStatValue()}</p>
                                <c:forEach items="${artifact.getSubstats()}" var="substat">
                                    <div class="">
                                        <p class="artifact-substat">${substat.getName()} : ${substat.getValue()}</p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="artifact">
                    <div class="artifact-box-add">
                        <a href="addArtifact?characterId=${character.getCharacterId()}">
                            <span class="hyperspan"></span>
                        </a>
                        <div class="add-artifact-plus-h"></div>
                        <div class="add-artifact-plus-v"></div>
                    </div>
                </div>
            </section>
        </section>
        <a class="generate-showcase-button"
           href="selectImage?characterId=${character.getCharacterId()}">
            <button>Generate Showcase</button>
        </a>
    </div>
</div>
</body>
</html>
