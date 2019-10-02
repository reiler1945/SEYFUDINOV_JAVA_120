<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="../css/usersPage.css"/>
</head>
<body>
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Пользователи</td></tr>
    <tr>
        <td align="left">
            <div id = 'profile'>
                <a href="/profile">${user.firstName + " " +user.lastName}</a>
                <a href="/logout">(logout)</a>
            </div>
        </td>
        <td align="right">
            <div id = 'articles'>
                <a href="/articles">В магазин</a>
            </div>
        </td>
    </tr>
</table>
<div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        </thead>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </#list>
    </table>
</div>
<div>
    <ul class = "pagination" id = 'steps'>
    <#list 1..pageCount as page>
        <#if page == pageNum>
            <li><a class="active href="/users/${pageSize}?pageNum=${page}">${page}</a></li>
        <#else>
            <li><a href="/users/${pageSize}?pageNum=${page}">${page}</a></li>
        </#if>
    </#list>
    </ul>
<#--выполнено js скриптом-->
<#--    <ul class = "pagination" id = 'steps'>-->
<#--        <script>-->
<#--            for (let i = 1; i <= ${pageCount}; i++) {-->
<#--                let stepsHtml = document.getElementById('steps');-->
<#--                if (i == ${pageNum}) {-->
<#--                    stepsHtml.innerHTML = stepsHtml.innerHTML + '<li><a class="active href="/users/' + ${pageSize} +'?pageNum=' + i + '">' + i + '</a></li>';-->
<#--                } else {-->
<#--                    stepsHtml.innerHTML = stepsHtml.innerHTML + '<li><a href="/users/' + ${pageSize} +'?pageNum=' + i + '">' + i + '</a></li>';-->
<#--                }-->
<#--            }-->
<#--        </script>-->
<#--    </ul>-->
</div>
</body>
</html>