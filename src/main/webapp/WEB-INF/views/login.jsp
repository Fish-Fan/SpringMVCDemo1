<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
    <div class="container">
        <c:if test="${not empty message}">
            <p class="bg-warning">${message}</p>
        </c:if>

        <form action="/users/login" method="post">
            <div>
                <label>username:</label>
                <input type="text" name="username" class="form-control">
            </div>

            <div>
                <label>password:</label>
                <input type="password" name="password" class="form-control">
            </div>

            <button type="submit" class="btn btn-primary">登录</button>
        </form>
    </div>
</body>
</html>