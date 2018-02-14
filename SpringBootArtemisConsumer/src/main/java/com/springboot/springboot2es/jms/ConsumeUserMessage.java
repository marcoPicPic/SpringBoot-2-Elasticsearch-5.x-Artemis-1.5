package com.springboot.springboot2es.jms;


import com.artemis.domain.TicketEventList;
import com.artemis.domain.User;
import com.springboot.springboot2es.service.TicketService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


@Log
@Component
public class ConsumeUserMessage implements MessageListener {

    @Autowired
    private TicketService ticketService;

    @Override
    public void onMessage(Message message) {
        ObjectMessage objMsg = (ObjectMessage) message;
        try {
            if (objMsg.getObject() instanceof User) {
                User user = (User) ((ObjectMessage) message).getObject();
                log.info("Message text " + user.getName());
                System.out.println("Message text " + user.getFirstName());
            } else if (objMsg.getObject() instanceof TicketEventList) {
                TicketEventList ticketEventList = (TicketEventList) ((ObjectMessage) message).getObject();
                ticketService.createAndSaveTicketsLogs(ticketEventList);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
