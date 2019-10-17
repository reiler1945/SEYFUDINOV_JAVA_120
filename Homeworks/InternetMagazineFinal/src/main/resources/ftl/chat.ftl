<!DOCTYPE html>
<html>
<head>
    <title>chat</title>
    <#include "template1.ftl">
    <#include "template3.ftl">
    <script src="js/script.js"></script>
</head>
<body>
<#include "template2.ftl">
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