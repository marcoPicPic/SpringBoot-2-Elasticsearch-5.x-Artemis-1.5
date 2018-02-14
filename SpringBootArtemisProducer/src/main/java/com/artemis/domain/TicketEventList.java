package com.artemis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TicketEventList implements Serializable {

    private List<Ticket> tickets;

}
