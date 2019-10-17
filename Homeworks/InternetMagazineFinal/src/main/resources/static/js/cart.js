function deleteArticleFromCart(csrf, cartId, articleId) {
    // создаем тело запроса в формате JSON
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    const reload = function (response) {
        let cartHtml = document.getElementById('cart');
        cartHtml["innerHTML"] = '<a class="nav-link" href="/cart?cartId='+ cartId + '" > Корзина(' + response.length + ') </a>';

        let articlesListHtml = document.getElementById('articles-list');
        // создаем новую HTML-ку с новым списком
        let newArticles = '<thead class="thead-dark">\n' +
            '        <tr>\n' +
            '            <th>ID</th>\n' +
            '            <th>NAME</th>\n' +
            '            <th>PRICE</th>\n' +
            '            <th>Удалить из корзины</th>\n' +
            '        </tr>\n' +
            '        </thead>';
        // бежим по всей jSON-ке (новой) со списком
        for (let i = 0; i < response.length; i++) {
            let cartArticleDto = response[i];
            newArticles += '<tr>';
            newArticles += '<td>' + cartArticleDto["articleId"] + '</td>'
            newArticles += '<td>' + cartArticleDto["name"] + '</td>';
            newArticles += '<td>' + cartArticleDto["price"] + '</td>';
            newArticles += '<td><a onclick="deleteArticleFromCart(\'' + csrf + '\', ' + cartArticleDto["cartId"] + ', ' + cartArticleDto["articleId"] + ')" href = "#">удалить</a></td>';
            newArticles += '</tr>';
        }
        articlesListHtml.innerHTML = newArticles;
    };
    $.ajax({
        url: '/cart/delete',
        contentType: 'application/json',
        type: 'post',
        headers : {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
         success: function (response) {
             reload(response);
        }
    })
}