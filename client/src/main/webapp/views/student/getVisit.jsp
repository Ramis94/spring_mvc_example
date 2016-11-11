<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 01.11.16
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <thead>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Пол</th>
        <th>Дата рождения</th>
        <th>Кол. посещений</th>
        </thead>
        <tbody>
        <c:forEach var="listValueStudent" items="${listVisit}">
            <tr>
                <th>${listValueStudent.student.id}</th>
                <th>${listValueStudent.student.firstName}</th>
                <th>${listValueStudent.student.lastName}</th>
                <th>${listValueStudent.student.sex}</th>
                <th>${listValueStudent.student.bornDate}</th>
                <th>${listValueStudent.visit}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
