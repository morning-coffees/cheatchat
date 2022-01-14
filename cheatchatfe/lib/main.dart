import 'dart:async';
import 'dart:convert';

import 'package:stomp_dart_client/stomp.dart';
import 'package:stomp_dart_client/stomp_config.dart';
import 'package:stomp_dart_client/stomp_frame.dart';

void onConnect(StompFrame frame) {
  stompClient.subscribe(
    destination: '/topic/public',
    callback: (frame) {
      dynamic result = json.decode(frame.body!);
      print(result);
    },
  );

  Timer.periodic(const Duration(seconds: 10), (_) {
    stompClient.send(
      destination: '/app/chat.newUser',
      body: json.encode({'sender': 'username', 'type': 'CONNECT'}),
    );
  });
}

final stompClient = StompClient(
  config: StompConfig(
    url: 'ws://localhost:8091/cheatchat/websocket',
    onConnect: onConnect,
    beforeConnect: () async {
      print('waiting to connect...');
      await Future.delayed(const Duration(milliseconds: 200));
      print('connecting...');
    },
    onWebSocketError: (dynamic error) => print(error.toString()),
    onWebSocketDone: () => print("Done?"),
    stompConnectHeaders: {'Authorization': 'Bearer yourToken'},
    webSocketConnectHeaders: {'Authorization': 'Bearer yourToken'},
  ),
);

void main() {
  stompClient.activate();
}
