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
        <form action="/student/update" method="POST" name="studentForm">
                <input type="text" name="id" value="${student.id}" hidden><br>
                <input type="text" name="version" value="${student.version}" hidden><br>
                Имя <input type="text" name="firstName" value="${student.firstName}"><br>
                Фамилия <input type="text" name="lastName" value="${student.lastName}"><br>
                Пол <input type="text" name="sex" value="${student.sex}"><br>
                Дата рождения <input type="date" name="bornDate" value="${student.bornDate}"><br>
                <input type="submit" value="Обновить" />
        </form>
</body>
</html>
