var stompClient = null;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket-test', null, {
        'protocols_whitelist': ['websocket']
    });
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });

        stompClient.subscribe('/topic/time', function (greeting) {
            showTime(JSON.parse(greeting.body).content);
        });

        //实时消息
        stompClient.subscribe('/topic/message', function (greeting) {
            showMessageTip(JSON.parse(greeting.body).content);
        });

    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    console.log(message);
    $("#greetings").html("<tr><td>" + message + "</td></tr>");
}

function showTime(time) {
    console.log(time);
    $("#time").text(time);
}


function showMessageTip(message) {
    console.log(message);
    $("#message").append("<p>" + message + "</p>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });

    //connect();
});

