package com.springboot.springboot2es;

import com.artemis.domain.TicketEventList;
import com.springboot.springboot2es.service.TicketService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.JsonLogTicket;
import service.TicketJsonLog;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Log
public class SpringBoot2ESApplication implements CommandLineRunner {
    @Autowired
    TicketService ticketService;

    @Override
    public void run(String... args) throws Exception {
        //Ecriture de log pour recupérer avec logstash
         runWriteTicketsLogsForLogstach();

        //Ecriture de log directement avec spring-Data JPA
        runWriteTicketsLogsDirectlyElasticSearch(ticketService);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBoot2ESApplication.class, "--debug").close();
    }

    private void runWriteTicketsLogsForLogstach() {
        log.info("Debut ThreadTicketJsonLog : " + LocalDateTime.now());
        TicketJsonLog.writeTicketLogsInFileLogs();
        log.info("Fin ThreadTicketJsonLog : " + LocalDateTime.now());
    }


    private void runWriteTicketsLogsDirectlyElasticSearch(TicketService ticketService) throws InterruptedException {
        log.info("Debut ThreadGenerateTicketsLog : " + LocalDateTime.now());
        JsonLogTicket jsonLogTicket = new JsonLogTicket();
        ticketService.createAndSaveTicketsLogs(jsonLogTicket.getTicketEventListInFileLog());
        log.info("Fin ThreadGenerateTicketsLog : " + LocalDateTime.now());
    }

}


