<html>
<head>
    <title>Users</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
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
</body>
</html>