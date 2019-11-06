<html>
<head>
    <title>Users</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
    <link rel="stylesheet" type="text/css" href="../css/usersPage.css"/>
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Пользователи(pagination)</td></tr>
</table>
<div>
    <table class="table">
        <thead class="thead-light">
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