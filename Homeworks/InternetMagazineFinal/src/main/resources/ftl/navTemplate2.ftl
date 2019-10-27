<nav class = "nav navbar-expand-lg navbar-light bg-light">
    <a href="#">
        <img src="/img/logomak_logo.png" width = "50" height="50">
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/articles">Товары<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profile">Профиль</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chat">Чат магазина</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/profile">${user.firstName + " " + user.lastName}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">(logout)</a>
            </li>
            <li class="nav-item">
                <div id = 'cart'>
                    <a class="nav-link" href="/cart?cartId=${user.cartId}">Корзина(${cartArticlesCount})</a>
                </div>
            </li>
        </ul>
    </div>
</nav>