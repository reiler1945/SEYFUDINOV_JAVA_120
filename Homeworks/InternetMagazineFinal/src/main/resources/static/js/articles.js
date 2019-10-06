function addArticleToCart(csrf, cartId, articleId) {
    // создаем тело запроса в формате JSON
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    const reload = function (response) {
        let cartHtml = document.getElementById('cart');
        cartHtml["innerHTML"] = '<a href="/cart?cartId='+ cartId + '" > Корзина(' + response + ') </a>';
    };
    $.ajax({
        url: '/cart',
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

function addArticle(csrf, name, price, cartId) {
    // создаем тело запроса в формате JSON
    let body = {
        "name": name,
        "price": price
    };
    const reload = function (response) {
        //let cartHtml = document.getElementById('articles');
        $('#articles tr:last').after(
            '        <tr>\n' +
            '            <td>' + response["id"] + '</td>\n' +
            '            <td> ' + response["name"] + '</td>\n' +
            '            <td> ' + response["price"] + '</td>\n' +
            '            <td><a onclick="addArticleToCart(\'' + csrf + '\', ' + cartId + ', ' + response["id"] + ')" href = "#">в корзину</a></td>\n' +
            '        </tr>'
        );
    };
    $.ajax({
        url: '/articles/add',
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