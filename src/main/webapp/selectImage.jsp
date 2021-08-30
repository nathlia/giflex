<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/30/2021
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Select Image</title>
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
        <section class="images-tray">
            <div class="image-of-character">
                <div class="select-image-text">
                    <h3>Select Image for Showcase</h3>
                </div>
                <div class="character-name-box">
                    <h3 class="character-name">${character.getName()}</h3>
                </div>
            </div>
            <section class="images">
                <div class="image">
                    <a href="showcase?characterId=${character.getCharacterId()}&&image=${1}">
                        <span class="hyperspan"></span>
                    </a>
                    <img src="img/${character.getName()}/1.png"
                    height="300"
                         id="image-1">
                </div>
                <div class="image">
                    <a href="showcase?characterId=${character.getCharacterId()}&&image=${2}">
                        <span class="hyperspan"></span>
                    </a>
                    <img src="img/${character.getName()}/2.png"
                    height="300"
                         id="image-2">
                </div>
                <div class="image">
                    <a href="showcase?characterId=${character.getCharacterId()}&&image=${3}">
                        <span class="hyperspan"></span>
                    </a>
                    <img src="img/${character.getName()}/3.png"
                    height="300"
                         id="image-3">
                </div>
                <div class="image">
                    <a href="showcase?characterId=${character.getCharacterId()}&&image=${4}">
                        <span class="hyperspan"></span>
                    </a>
                    <img src="img/${character.getName()}/4.png"
                    height="300"
                         id="image-4">
                </div>
            </section>
        </section>
    </div>
</div>
</body>
</html>
