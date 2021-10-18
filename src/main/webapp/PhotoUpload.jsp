<%--
  User: Евгений Зайцев
  Date: 14.10.2021
  Time: 17:35
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Загрузка фото</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <c:if test="${user != null}">
                <li>
                    <span class="badge badge-secondary">
                        <c:out value="${user.name}"/>
                    </span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">Выйти</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>

<div class="container">
    <h2>Загрузка фото</h2>
    <form action="<c:url value='/upload.do?id=${param.id}'/>" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-default">Загрузить</button>
    </form>
</div>

</body>
</html>

