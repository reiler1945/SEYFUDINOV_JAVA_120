function deleteArticleFromCart(cartId, articleId) {
    // создаем переменную, в которой находится объект для отправки запроса
    let xhr = new XMLHttpRequest();
    // создаем тело запроса в формате JSON
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    xhr.open('POST', '/cart/delete');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        let response = JSON.parse(xhr.response);
        let cartHtml = document.getElementById('articles-list');

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
            newArticles += '<td><a onclick="deleteArticleFromCart(' + cartArticleDto["cartId"] + ', ' + cartArticleDto["articleId"] + ')" href = "#">удалить</a></td>';
            newArticles += '</tr>';
        }
        articlesListHtml.innerHTML = newArticles;
    };
    xhr.send(JSON.stringify(body));
}