<html>
<head>
    <title>Users</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
    <link rel="stylesheet" type="text/css" href="../css/usersPage.css"/>
</head>
<body>
<#include "template2.ftl">
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
            <li><a class="active" href="/users/pages?pageSize=${pageSize}&pageNum=${page}">${page}</a></li>
        <#else>
            <li><a href="/users/pages?pageSize=${pageSize}&pageNum=${page}">${page}</a></li>
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