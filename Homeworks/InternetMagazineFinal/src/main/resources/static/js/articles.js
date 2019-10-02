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