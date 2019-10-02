<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp</title>
</head>
<body>
<div>
    <form action="/signUp" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="text" name="firstName" placeholder="First Name">
        <br>
        <input type="text" name="lastName" placeholder="Last Name">
        <br>
        <input type="text" name="login" placeholder="Login">
        <br>
        <input type="password" name="password" placeholder="Password">
        <br>
        <input type="submit" value="SignUp">
    </form>
</div>
</body>
</html>