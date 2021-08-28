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
        <div class="add-character-centre">
            <p>Add Character</p>
            <form action="addCharacter" method="post">
                <label>Select Character:</label>
                <select name="selectCharacter">
                    <c:forEach items="${characterList}" var="character">
                        <option value="${character.getCharacterId()}">
                                ${character.getName()}
                        </option>
                    </c:forEach>
                </select>
                <div id="select-character">
                    <input class="select-character" nome="select-character" type="submit" value="Select">
                </div>
            </form>
        </div>

            <form action="addCharacter" method="post">
                <section class="add-character-form">
                    <div id="character-card">
                        <div class="item">
                            <img src="img/characters/${character.getName()}.png" height="209" width="150"
                                 id="character-card-img">
                            <div id="character-card-name">
                                <h3>${character.getName()}</h3>
                            </div>
                        </div>
                    </div>
                    <div class="character-form-tray">
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
                <br/><br/>
                <div id="add-character-button">
                    <input class="select-character" nome="back" type="submit" value="Back">
                    <input class="select-character" name="save" type="submit" value="Save">
                </div>
            </form>
        
    </div>
</div>


<%--    -> delete button--%>
<%--    -> edit button--%>
<%--    -> add button--%>

<%--    -> show added with success message--%>
<%--    -> ok button--%>
<%--    -> go to index.jsp--%>
</body>
</html>
