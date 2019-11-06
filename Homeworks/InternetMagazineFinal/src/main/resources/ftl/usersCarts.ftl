<html>
<head>
    <title>Users Carts</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Все корзины</td></tr>
</table>
<div>
    <table class="table">
        <thead class="thead-light">
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