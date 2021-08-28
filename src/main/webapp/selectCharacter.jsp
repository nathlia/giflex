<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/28/2021
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Select character</title>
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
        <div class="add-character-centre">
            <p>Add Character</p>
            <form action="selectCharacter" method="post">
                <label>Select Character:</label>
                <select name="selectCharacter">
                    <c:forEach items="${characterList}" var="character">
                        <option value="${character.getCharacterId()}">
                                ${character.getName()}
                        </option>
                    </c:forEach>
                </select>
                <div id="select-character">
                    <input class="select-character" type="submit" value="Select">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
