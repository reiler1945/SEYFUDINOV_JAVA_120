<html>
<head>
    <title>Users</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Пользователи</td></tr>
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