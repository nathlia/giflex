<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/30/2021
  Time: 3:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Showcase</title>
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
        <div class="showcase-image">
            <div class="showcase-image">
                <img src="img/${character.getName()}/${image}.png"
                     height="675"
                     id="image-1">
            </div>
        </div>
        <section class="showcase-tray">
            <div class="showcase-character-card-status">
                <p class="showcase-artifact-set-rate">Crit Rate: ${character.getCritRate()}</p>
                <p class="showcase-artifact-set-dmg">Crit DMG: ${character.getCritDmg()}</p>
            </div>
            <div id="showcase-artifacts-tray">
                <section class="showcase-artifacts">
                    <c:forEach items="${artifactList}" var="artifact">
                        <div class="showcase-artifact">
                            <div class="showcase-artifact-box">
                                <p class="showcase-artifact-set-name">${artifact.getArtifactSetType().getName()}</p>
                                <p class="showcase-artifact-set-type">${artifact.getArtifactType().getName()}</p>
                                <p class="showcase-artifact-mainstat">${artifact.getMainStat().getName()}
                                    : ${artifact.getMainStatValue()}</p>
                                <c:forEach items="${artifact.getSubstats()}" var="substat">
                                    <div class="">
                                        <p class="showcase-artifact-substat">${substat.getName()}
                                            : ${substat.getValue()}</p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </section>
            </div>
        </section>
        <a class="showcase-back-button"
           href="selectImage?characterId=${character.getCharacterId()}">
            <button>Back</button>
        </a>
    </div>
</div>
</body>
</html>
