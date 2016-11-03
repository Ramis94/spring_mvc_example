<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 01.11.16
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecture</title>
</head>
<body>


        <table>
            <thead>
            <th>ID</th>
            <th>Topic</th>
            <th>Description</th>
            <th>Date</th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach var="listValueLecture" items="${list}">
                <tr>
                    <th>${listValueLecture.id}</th>
                    <th>${listValueLecture.topic}</th>
                    <th>${listValueLecture.description}</th>
                    <th>${listValueLecture.date}</th>
                    <th><a href=""></a></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        
        <a href="/lecture/visit">Посещения</a>
</body>
</html>
