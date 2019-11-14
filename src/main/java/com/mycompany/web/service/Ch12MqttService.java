package com.mycompany.web.service;

import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Ch12MqttService {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch12MqttService.class);
	
	private MqttClient client;
	
	public Ch12MqttService() {
		mqttConnect();
	}

	private void mqttConnect() {
		try {
			client = new MqttClient("tcp://localhost:1884", MqttClient.generateClientId(), null);
			client.connect();
			receiveMessage();
			logger.debug("MQTT Broker에 연결 성공: tcp://localhost:1884");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void mqttDisconnect() {
		try {
			client.disconnectForcibly(1);
			client.close(true);			
			logger.debug("MQTT Broker에 연결 끊기 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy  
	public void destroy() {
		logger.debug("3초 후에 사라져~");
		mqttDisconnect();		
		//Ch12MqttService객체가 없이지기 직전에 마지막으로 이 메소드를 실행한다.
	}
	
	private void receiveMessage() throws MqttException {
		client.setCallback(new MqttCallback() {
			
			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				byte[] bytes = message.getPayload();
				String json = new String(bytes);
				logger.debug(json);
				//문제점:subscribe Thread는 publish를 할수 없다 //client.publish(..) (X)
				
				//해결책: 새로운 스레드로 publish는 가능하다
				Thread thread = new Thread() {
					@Override
					public void run() {
						
					}
				};
				thread.start();
			}
			
			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub
				
			}
		});
		client.subscribe("/drone/mqttservice/sub");
	}

	public void sendMessage(String topic, String message) {
		try {
			client.publish(topic, message.getBytes(), 0, false);		
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
}
