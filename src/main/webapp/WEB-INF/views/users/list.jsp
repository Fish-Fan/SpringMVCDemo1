<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <p class="bg-danger">${message}</p>
        </c:if>
        <p class="bg-danger">当前共有${allUserCount}位用户，以下为各用户详细信息</p>
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
    </div>
</body>
</html>