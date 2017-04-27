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

        <form id="regForm">
            <label>注册账号：</label>
            <input type="text" name="username" class="form-control" id="username">

            <label>注册密码:</label>
            <input type="password" name="password" class="form-control" id="password">

            <select name="gender">
                <option value="1">男</option>
                <option value="2">女</option>
            </select>

            <span id="regMsg" class="hide">注册成功,<span class="sec">3</span>秒后自动跳转到登录页面</span>

            <button id="regBtn" type="button" class="btn btn-success">注册</button>
        </form>
    </div>
    <script src="/static/js/jQuery1.9.1.js"></script>
    <script src="/static/js/jquery.validate.min.js"></script>
    <script>
        $(function () {
            $("#regForm").validate({
                errorClass: "text-danger",
                errorElement: "span",
                onkeyup: false,
                rules: {
                    username: {
                        required: true,
                        minlength: 3,
                        maxlength: 10,
                        remote: "/users/validate/username"
                    },

                    password: {
                        required: true,
                        minlength: 6,
                        maxlength: 16,
                    }
                },
                messages: {
                    username: {
                        required: "请填写此字段",
                        minlength: "用户名长度为3-10个字符",
                        maxlength: "用户名长度为3-10个字符",
                        remote: "该账号已经被注册，请重新填写"
                    },

                    password: {
                        required: "请填写此字段",
                        minlength: "密码长度为6-10个字符",
                        maxlength: "密码长度为6-10个字符"
                    }
                },
                submitHandler:function (form) {
                    $.post("/users/registeruser",$("#regForm").serialize())
                        .done(function (result) {
                            if(result == "error"){
                                console.log(result);
                                alert("注册失败");
                            } else {
                                $("#regMsg").removeClass("hide");
                                var sec = 3;
                                setInterval(function () {
                                    sec--;
                                    if(sec == 0) {
                                        window.location.href = "/users/login";
                                        return;
                                    }
                                    $("#regMsg .sec").text(sec);
                                },1000)
                            }
                        }).fail(function () {
                        alert("服务器异常，请稍后再试");
                    });
                }
            });

            $("#regBtn").click(function () {
                $("#regForm").submit();
            });
        });
    </script>
</body>
</html>