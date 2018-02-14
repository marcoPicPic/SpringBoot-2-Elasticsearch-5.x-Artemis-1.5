package com.springboot.springboot2es.service;


import com.artemis.domain.TicketEventList;
import com.springboot.springboot2es.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    public void createAndSaveTicketsLogs(TicketEventList ticketEventList)  {

        //test si elastic est bien accessible
        ticketRepository.saveAll(ticketEventList.getTickets());
    }

}
