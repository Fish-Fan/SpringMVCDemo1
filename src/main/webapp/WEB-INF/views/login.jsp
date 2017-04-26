<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/users/login" method="post">
    <div>
        <label>username:</label>
        <input type="text" name="username">
    </div>

    <div>
        <label>password:</label>
        <input type="password" name="password">
    </div>

    <button type="submit">注册</button>
</form>
</body>
</html>