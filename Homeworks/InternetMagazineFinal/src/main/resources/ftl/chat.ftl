<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>chat</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="js/script.js"></script>
</head>
<body>
<table width="100%">
    <tr><td colspan="2" align="center" bgcolor="#f4a460">Чат</td></tr>
    <tr>
        <td align="left">
            <div id = 'profile'>
                <a href="/profile">${user.firstName + " " +user.lastName}</a>
                <a href="/logout">(logout)</a>
            </div>
        </td>
        <td align="right">
            <div id = 'articles'>
                <a href="/articles">В магазин</a>
            </div>
        </td>
    </tr>
</table>
<h1>Magazine Chat</h1>
<div>
    <input type="hidden" id="userNamePrefix" value="${user.firstName + " " + user.lastName}">
    <input type="hidden" id="userId" value="${user.id}">
    <div id="message_template">
        <ul id="messagesList"></ul>
    </div>
    <div>
        <div>
            <input id="message_input_value" placeholder="Type your message here..." size = 45 onkeypress="if (event.keyCode == 13) return sendMessage()">
        </div>
        <button onclick="connect()">Connect to chat</button>
        <button onclick="sendMessage()">Send</button>
        <button onclick="disconnect()">Disconnect from chat</button>
    </div>
</div>
</body>
</html>