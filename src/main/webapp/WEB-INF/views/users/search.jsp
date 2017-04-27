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
        <form action="/users/search" method="get">
            <label>根据用户名搜索:</label>
            <input type="text" name="value" class="form-control">
            <button type="submit" class="btn btn-primary">搜索</button>
        </form>

        <c:if test="${not empty count}">
            <p class="bg-danger">共为您找到${count}条搜索结果</p>
        </c:if>

        <c:if test="${not empty userList}">
            <c:forEach items="${userList}" var="user">
                <div class="row">
                    <div class="col-md-8">
                        <div class="bg-primary" style="margin: 10px 0">
                            <li>username:${user.username}</li>
                            <li>password:${user.password}</li>
                            <li>gender:${user.gender}</li>
                            <li>id:${user.id}</li>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <a href="/users/del?id=${user.id}" class="btn btn-danger" style="margin-right: 10px">删除</a>
                        <a href="/users/update?id=${user.id}" class="btn btn-primary">修改</a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>