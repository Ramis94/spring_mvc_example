<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 02.11.16
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/j_spring_security_check" method="post">
        <h2 class="form-group modal-header">Вход</h2>
        <fieldset>
            <div class="form-group">
                <h4>Логин:</h4>
                <input class="form-control" name="j_username" placeholder="Login" type="text" autofocus >
            </div>
            <div class="form-group">
                <h4>Пароль:</h4>
                <input class="form-control" name="j_password" placeholder="Password"  type="password" value="">
            </div>
            <input type="submit" value="Login"/>
        </fieldset>
    </form>

</body>
</html>
