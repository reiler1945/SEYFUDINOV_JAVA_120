<html>
<head>
    <title>Товары</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="js/articles.js"></script>
</head>
<body>
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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
