package com.artemis.jms;

import com.artemis.domain.TicketEventList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArtemisProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	public void send(TicketEventList msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}
	public void sendString(String msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}

}