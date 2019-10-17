<html>
<head>
    <title>Корзина</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
    <script src="js/cart.js"></script>
</head>
<body>
<#include "template2.ftl">
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Корзина</td></tr>
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
<table id='articles-list' class="table">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>Удалить из корзины</th>
    </tr>
    </thead>
    <#list articles as article>
        <tr>
            <td>${article.articleId}</td>
            <td>${article.name}</td>
            <td>${article.price}</td>
            <td><a onclick="deleteArticleFromCart('${_csrf.token}', ${user.cartId}, ${article.articleId})" href = "#">удалить</a></td>
        </tr>
    </#list>
</table>
<button onclick="location.href='/pay'">
    Перейти к оплате
</button>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
