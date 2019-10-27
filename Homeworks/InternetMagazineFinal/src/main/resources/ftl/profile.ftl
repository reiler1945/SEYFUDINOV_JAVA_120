<html>
<head>
    <title>Profile</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
</head>
<body>
    <#include "navTemplate2.ftl">
    <table width="100%">
        <tr><td align="center" bgcolor="#b2ff9c">Профиль</td></tr>
    </table>
    <div class="left-container">
    <table class="table-light">
        <thead class="thead-light">
        <tr>
            <th>First Name</th>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <th>Role</th>
            <td>${user.role}</td>
        </tr>
        </thead>
    </table>
    </div>
    <div>
        <table class="table">
            <tr><td><a href="/users">Все пользователи</a></td></tr>
            <tr><td><a href="/users/carts">Все товары в корзине по всем пользователям</a></td></tr>
            <tr><td><a href="/users/pages?pageSize=3">Пользователи (pagination)</a></td></tr>
        </table>
    </div>
</body>
</html>
