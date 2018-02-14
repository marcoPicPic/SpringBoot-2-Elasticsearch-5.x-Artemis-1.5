package com.artemis.service;

import com.artemis.domain.Ticket;
import com.artemis.domain.TicketEventList;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class TicketEventListService {
    static int AMOUNT_LOG = 50;
    static int AMOUNT_LOG_SLEEP = 500;

    static int TIME_SLEEP = 2000;


    public TicketEventList createTicketEventList() throws InterruptedException {

        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < AMOUNT_LOG; i++) {
            Ticket ticket = new Ticket().generateTicket(i);
            ticket.setId(String.valueOf(i));
            tickets.add(ticket);
            if (i % AMOUNT_LOG_SLEEP == 0)
                sleep(TIME_SLEEP);
        }

        return  new TicketEventList(tickets);
    }
}
