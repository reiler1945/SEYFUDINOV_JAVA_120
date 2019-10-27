function connect() {
    var socket = new SockJS('/chat-messaging');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log("connected: " + frame);
        draw("connected");
        stompClient.subscribe('/chat/messages', function(response) {
            var data = JSON.parse(response.body);
            draw(data.message);
        });
    });
}

function draw(text) {
    $('#messagesList').first().after("<li>" + text + "</li>")

}
function disconnect(){
    stompClient.disconnect();
    draw("disconnected");
}
function sendMessage(){
    var userNamePrefix = $("#userNamePrefix").val();
    var userId = $("#userId").val();
    var msg = $("#message_input_value").val();
    if (msg.length != '') {
        stompClient.send("/app/message", {}, JSON.stringify({
            'message': userNamePrefix + ': ' + msg,
            'userId': userId
        }));
    }
    $("#message_input_value").val("");
}
