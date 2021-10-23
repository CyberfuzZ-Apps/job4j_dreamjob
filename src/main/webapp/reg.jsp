<%--
  User: Евгений Зайцев
  Date: 18.10.2021
  Time: 13:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function validate() {
            let name = $('#name');
            let email = $('#email');
            let password = $('#password');
            let array = [name, email, password];
            for (let i = 0; i < array.length; i++) {
                if (array[i].val() === '') {
                    alert(array[i].attr('title') + ' не заполнено!');
                    return false;
                }
            }
            return true;
        }
    </script>

    <title>Регистрация</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/auth.do">Войти</a>
            </li>
        </ul>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Новый пользователь
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/reg.do" method="post">
                    <div class="form-group">
                        <label for="name">Имя</label>
                        <input type="text" class="form-control" id="name" name="name" title="Поле ИМЯ"
                               placeholder="Введите имя">
                    </div>
                    <div class="form-group">
                        <label for="email">Почта</label>
                        <input type="email" class="form-control" id="email" name="email" title="Поле ПОЧТА"
                               placeholder="Введите email">
                    </div>
                    <div class="form-group">
                        <label for="password">Пароль</label>
                        <input type="password" class="form-control" id="password" name="password" title="Поле ПАРОЛЬ"
                               placeholder="Введите пароль">
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validate()">Создать</button>
                    <div class="container">
                        <div class="row">
                            <%  String error = (String) request.getAttribute("error");
                                if (error != null) { %>
                            <div style="color:red; font-weight: bold; margin: 30px 0;">
                                <%=error%>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
