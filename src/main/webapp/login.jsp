<%--
  Created by IntelliJ IDEA.
  User: Natty
  Date: 8/7/2021
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login</h3>
<form action="index.jsp" method="post">
    Email: <input type="email" name="username"/> <br />
    Password: <input type="password" name="password"/> <br />
    <input type="submit" value="Create Account">
    <input type="submit" value="Login">

    <%--login redirects to index.jsp--%>
</form>
</body>
</html>
