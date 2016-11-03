<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 31.10.16
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <script>
    function searchStudend() {
        $.ajax({
            url: "/student/search=" + $(".search").val(),
            dataType: 'json',
            success : function (data) {
                console.log(data);
                var result = data.id + ' ' + data.firstName + ' ' + data.lastName + ' ' + data.sex + ' ' + data.bornDate;
                $(".searchResult").text(result);
            }
        });
    }
    </script>
</head>
<body>


        Поиск по имени : <input class="search" type="text" value=""><button onclick="searchStudend();">Поиск</button>
        <p class="searchResult"></p>


        <table>
            <thead>
                <th><a href="/student/sort=id">ID</a></th>
                <th><a href="/student/sort=firstName">Имя</a></th>
                <th><a href="/student/sort=lastName">Фамилия</a></th>
                <th><a href="/student/sort=sex">Пол</a></th>
                <th><a href="/student/sort=bornDate">Дата рождения</a></th>
            </thead>
            <tbody>
            <c:forEach var="listValueStudent" items="${list}">
                <tr>
                    <th>${listValueStudent.id}</th>
                    <th>${listValueStudent.firstName}</th>
                    <th>${listValueStudent.lastName}</th>
                    <th>${listValueStudent.sex}</th>
                    <th>${listValueStudent.bornDate}</th>
                    <th><a href="/student/${listValueStudent.firstName}">Просмотреть</a> </th>
                    <th><a href="/student/del=${listValueStudent.id}">Удалить</a> </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <br>
    <br>
    <br>
    <br>
    <br>
        <form action="/student/add" method="POST">
            Имя: <input type="text" name="firstName" value=""/>
            <br>
            Фамилия: <input type="text" name="lastName" />
            <br>
            Пол: <input type="text" name="sex" />
            <br>
            Дата рождения: <input type="text" name="bornDate" />
            <br>
            <input type="submit" value="Добавить" />
        </form>
</body>
</html>
