<html>
<head>
    <title>Товары</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
    <script src="js/articles.js"></script>
</head>
<body>
<#include "template2.ftl">
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Товары</td></tr>
    <tr>
        <td align="left">
            <div id = 'profile'>
                <a href="/profile">${user.firstName + " " + user.lastName}</a>
                <a href="/logout">(logout)</a>
            </div>
        </td>
        <td align="right">
            <div id = 'cart'>
                <a href="/cart?cartId=${user.cartId}">Корзина(${cartArticlesCount})</a>
            </div>
        </td>
    </tr>
</table>
<table id='articles' class="table">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>Добавить в корзину</th>
    </tr>
    </thead>
    <#list articles as article>
        <tr>
            <td>${article.id}</td>
            <td>${article.name}</td>
            <td>${article.price}</td>
            <td><a onclick="addArticleToCart('${_csrf.token}', ${user.cartId}, ${article.id})" href = "#">в корзину</a></td>
        </tr>
    </#list>
</table>
<#if user.role == 'ADMIN'>
    <div id = "addBlock">
        <input type="text" name="name" placeholder="Product name" id = "name">
        <br>
        <input type="number" name="price" placeholder="price" id = "price">
        <br>
        <input type="button" value=Add onclick="addArticle('${_csrf.token}', $('#name').val(), $('#price').val(), ${user.cartId})"/>
    </div>
</#if>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
