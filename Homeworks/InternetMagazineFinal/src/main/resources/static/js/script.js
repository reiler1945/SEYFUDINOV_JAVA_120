function connect() {
    var socket = new SockJS('/chat-messaging');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log("connected: " + frame);
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
}
function sendMessage(){
    var userNamePrefix = $("#userNamePrefix").val();
    var userId = $("#userId").val();
    stompClient.send("/app/message", {}, JSON.stringify({'message': userNamePrefix + ': ' + $("#message_input_value").val(), 'userId': userId}));
    $("#message_input_value").val("");
}
