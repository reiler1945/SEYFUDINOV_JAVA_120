<html>
<head>
    <title>Profile</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
</head>
<body>
    <#include "template2.ftl">
    <div>
        <h1>First Name:</h1>
        <h2>${user.firstName}</h2>
        <h1>Last Name:</h1>
        <h2>${user.lastName}</h2>
        <table class="table">
            <tr><td><a href="/articles">В магазин</a></td></tr>
            <tr><td><a href="/users">Пользователи</a></td></tr>
            <tr><td><a href="/users/carts">Все товары в корзине по всем пользователям</a></td></tr>
            <tr><td><a href="/users/pages?pageSize=3">Пользователи (pagination)</a></td></tr>
            <tr><td><a href="/chat">Чат магазина</a></tr>
            <tr><td><a href="/bootstrap">bootstrap</a></tr>
            <tr><td><a href="/logout">logout</a></tr>
        </table>
    </div>
</body>
</html>
