<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
</head>
<body>
<div>
    <form action="/signIn" method="post">
        <input type="text" name="login" placeholder="Login">
        <br>
        <input type="password" name="password" placeholder="Password">
        <br>
        <input type="submit" value="SignIn">
    </form>
    <br/>
    <a href = "/signUp">Sign Up</a>
</div>
</body>
</html>