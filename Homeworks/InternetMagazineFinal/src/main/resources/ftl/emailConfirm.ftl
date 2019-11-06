<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Email Confirm</title>
</head>
<body>
<div>
    <h1>Введите ваш Email для прохождения регистрации</h1>
    <form action="/email/confirm" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="text" name="email" placeholder="Email">
        <br>
        <input type="submit" value="SignUp">
    </form>
</div>
</body>
</html>