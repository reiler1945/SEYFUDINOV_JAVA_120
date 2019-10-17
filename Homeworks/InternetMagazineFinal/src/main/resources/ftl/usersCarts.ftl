<html>
<head>
    <title>Users Carts</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
</head>
<body>
<#include "template2.ftl">
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Корзины пользователей</td></tr>
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
            <th>Id товара</th>
            <th>Имя товара</th>
            <th>Цена товара</th>
        </tr>
        </thead>
        <#list cartDtos as cartDto>
            <tr>
                <td>${cartDto.user.id}</td>
                <td>${cartDto.user.firstName}</td>
                <td>${cartDto.user.lastName}</td>
                <td colspan="3"></td>
            </tr>
            <#list cartDto.articles as article>
                <tr>
                    <td colspan="3"></td>
                    <td>${article.id}</td>
                    <td>${article.name}</td>
                    <td>${article.price}</td>
                </tr>
            </#list>
        </#list>
    </>
    </table>
</div>
</body>
</html>