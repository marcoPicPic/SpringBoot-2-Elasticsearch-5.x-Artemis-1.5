package com.artemis.controller;

import com.artemis.domain.User;
import com.artemis.jms.ArtemisProducer;
import com.artemis.jms.UserProducer;
import com.artemis.service.TicketEventListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @Autowired
    ArtemisProducer producer;

    @Autowired
    UserProducer userProducer;



    @RequestMapping(value = "/produce")
    public String produce() throws InterruptedException {
        producer.send(new TicketEventListService().createTicketEventList());
        return "Done";
    }

    @RequestMapping(value = "/user")
    public String user() throws InterruptedException {
        userProducer.send(new User("toto", "titi"));
        return "Done";
    }

    @RequestMapping(value="/string")
    public String string(@RequestParam("msg")String msg){
        producer.sendString(msg);
        return "Done";
    }
}