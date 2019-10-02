function addArticleToCart(cartId, articleId) {
    // создаем переменную, в которой находится объект для отправки запроса
    let xhr = new XMLHttpRequest();
    // создаем тело запроса в формате JSON
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    xhr.open('POST', '/cart');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        let response = JSON.parse(xhr.response);
        let cartHtml = document.getElementById('cart');
        cartHtml.innerHTML = '<a href="/cart?cartId='+ cartId + '" > Корзина(' + xhr.response + ') </a>';
    };
    xhr.send(JSON.stringify(body));
}