<html>
<head>
    <title>Товары</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
    <script src="js/articles.js"></script>
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Товары</td></tr>
</table>
<table id='articles' class="table">
    <thead class="thead-light">
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
