<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form action="/users/update" method="post">
            <input type="hidden" value="${user.username}" name="username">
            <label>password:</label>
            <input type="text" name="password" value="${user.password}">

            <label>性别:</label>
            <select name="gender">
                <option value="1" ${user.gender eq "1" ? "selected" : ""}>男</option>
                <option value="2" ${user.gender eq "2" ? "selected" : ""}>女</option>
            </select>

            <button type="submit" class="btn btn-success">保存</button>
        </form>
    </div>
</body>
</html>