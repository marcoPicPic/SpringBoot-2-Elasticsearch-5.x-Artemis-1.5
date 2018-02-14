package service

import com.artemis.domain.Ticket
import com.artemis.domain.TicketEventList
import groovy.json.JsonSlurper

class JsonLogTicket {

    static def FILE_NAME = "historic.log"
    static def DIRECTORY = "C:\\temp\\"

    static ArrayList<Ticket> readTicketLog() {
        ArrayList<Ticket> tickets = new Ticket()
        new File(DIRECTORY + FILE_NAME).eachLine {
            line -> tickets.add(parseJson(line))
        }
        return tickets

    }

    def parseJson(def p) {

        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(p)

        if (object instanceof Ticket) {
            return new Ticket(object.date_stat, object.realtime_counter_id, object.index, object.counter_code,
                    object.entity_id, object.entity_type, object.entity_uuid, object.entity_name, object.counter_id, object.tenant_id,
                    object.realtime_counter_value_type, object.entity_type_name, object.realtime_counter_value,
                    object.tenant_uuid, object.tenant_name, object.realtime_counter_rolling, object.realtime_counter_raz
            )
        }
    }

    TicketEventList getTicketEventListInFileLog() {
        TicketEventList ticketEventList = new TicketEventList()
        ArrayList<Ticket> tickets = readTicketLog()
        ticketEventList.setTickets(tickets)
        return ticketEventList
    }
}
