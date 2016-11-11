<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 31.10.16
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="/student/update" method="POST">
                ID <input type="text" value="${student.id}" hidden><br>
                Имя <input type="text" value="${student.firstName}"><br>
                Фамилия <input type="text" value="${student.lastName}"><br>
                Пол <input type="text" value="${student.sex}"><br>
                Дата рождения <input type="text" value="${student.bornDate}"><br>
                <input type="submit" value="Обновить" />
        </form>
</body>
</html>
