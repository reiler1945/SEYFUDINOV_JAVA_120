<!DOCTYPE html>
<html>
<head>
    <title>chat</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
    <script src="js/script.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Чат</td></tr>
</table>
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