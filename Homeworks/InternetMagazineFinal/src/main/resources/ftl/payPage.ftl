<html>
<head>
    <title>Оплата</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
</head>
<body>
<#include "template2.ftl">
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Оплата</td></tr>
    <tr>
        <td align="left">
            <div id = 'profile'>
                <a href="/profile">${user.firstName + " " + user.lastName}</a>
                <a href="/logout">(logout)</a>
            </div>
        </td>
        <td align="right">
            <div id = 'cart'>
                <a href="/cart?cartId=${cartId}">Корзина(${cartArticlesCount})</a>
            </div>
        </td>
    </tr>
</table>
<table id='payInfo' class="table">
    <thead class="thead-dark">
    <tr>
        <th>Кол-во</th>
        <th>Сумма к оплате</th>
    </tr>
    </thead>
    <tr>
        <td>
            ${cartArticlesCount}
        </td>
        <td>
            <#if cartArticlesSum??>
                ${cartArticlesSum}
            <#else>
                0
            </#if>
        </td>
    </tr>
</table>
</body>
</html>
