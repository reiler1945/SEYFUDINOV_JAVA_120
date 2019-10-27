<html>
<head>
    <title>Корзина</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
    <script src="js/cart.js"></script>
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Корзина</td></tr>
</table>
<table id='articles-list' class="table">
    <thead class="thead-light">
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
