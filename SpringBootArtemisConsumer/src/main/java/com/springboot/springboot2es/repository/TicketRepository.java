package com.springboot.springboot2es.repository;


import com.artemis.domain.Ticket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketRepository extends ElasticsearchRepository<Ticket, String> {


}
