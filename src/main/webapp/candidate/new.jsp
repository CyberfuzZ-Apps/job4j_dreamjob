<%--
  User: Евгений Зайцев
  Date: 24.10.2021
  Time: 17:48
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
<%@ page import="ru.job4j.dream.model.User" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <!-- Без этих двух строк AJAX не работает -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <script>
        function validate() {
            let name = $('#name');
            let city = $('#city');
            let array = [name, city];
            for (let i = 0; i < array.length; i++) {
                if (array[i].val() === '') {
                    alert(array[i].attr('title') + ' не заполнено!');
                    return false;
                }
            }
            return true;
        }

        $(document).ready(function () {
            $.ajax({
                type: "GET",
                url: "/dreamjob/cities",
                dataType: "json",
                success: function (data) {
                    let cities = "";
                    for (let i = 0; i < data.length; i++) {
                        cities += "<option value=" + data[i]['id'] + ">" + data[i]['name'] + "</option>";
                    }
                    $('#city').html(cities);
                }
            })
        })
    </script>
    <title>Новый кандидат</title>
</head>
<body>

<%
    String id = request.getParameter("id");
    User user = (User) request.getSession().getAttribute("user");
    Candidate can = new Candidate(0, "");
    if (id != null) {
        can = PsqlStore.instOf().findCandidateById(Integer.parseInt(id));
    }
%>

<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/index.do">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/new.jsp">Добавить кандидата</a>
            </li>
            <li>
                    <span class="badge badge-secondary">
                        <%=user.getName()%>
                    </span>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">Выйти</a>
            </li>
        </ul>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Новый кандидат.
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=can.getId()%>" method="post">
                    <div class="form-group">
                        <label for="name">Имя:</label>
                        <input type="text" class="form-control" name="name" id="name" title="Поле ИМЯ"
                               value="<%=can.getName()%>" placeholder="Введите имя">
                    </div>
                    <div class="form-group">
                        <label for="city">Город (выберите из списка):</label>
                        <select id="city" name="city" class="form-control" required></select>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validate()">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
