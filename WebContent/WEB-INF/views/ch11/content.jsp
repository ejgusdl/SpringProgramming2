<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/paho-mqtt-min.js"></script>
		<script type="text/javascript">
			$(function() {
				//MQTT Broker와 연결하기
				client = new Paho.MQTT.Client(location.hostname, 61614, "clientId"+new Date().getTime());
				client.onMessageArrived = onMessageArrived;
				client.connect({onSuccess:onConnect});
			});
			
			
			//연결이 완료되었을 때 자동으로 실행(콜백) 되는 함수
			function onConnect() { 
				  client.subscribe("/drone/pub");				  
			}
			
			//메시지를 수신했을때 자동으로 실행(콜백)되는 함수
			function onMessageArrived(message) {
				$("#divRecive").append(message.payloadString + "<br/>");
			}
			
			function sendMassage() {
				var data = $("#inputData").val();
				var message = new Paho.MQTT.Message(data);
				message.destinationName = "/drone/sub";
				client.send(message);
			}
			
			
		</script>
	</head>
	<body>
		<input id="inputData" type="text"/>
		<button onclick="sendMassage()">누르지마</button>
		<h5>수신된 메세지</h5>
		<div id="divRecive"></div>
		
	</body>
</html>