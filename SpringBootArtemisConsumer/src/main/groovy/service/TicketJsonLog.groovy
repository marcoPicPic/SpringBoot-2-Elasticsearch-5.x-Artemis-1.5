package service

import com.artemis.domain.Ticket
import groovy.json.JsonOutput

class TicketJsonLog {

    static def FILE_NAME = "historic.log"
    static def DIRECTORY = "C:\\temp\\"
    static def AMOUNT_LOG = 10000
    static def AMOUNT_LOG_SLEEP = 500
    static def PARSE_END = System.getProperty("line.separator")
    static def TIME_SLEEP = 2000

    static
    writeTicketLogsInFileLogs() {
        def inputFile = new File(DIRECTORY + FILE_NAME)

        for (int i = 0; i < AMOUNT_LOG; i++) {
            Ticket ticket = new Ticket().generateTicket(i)
            ticket.setId(String.valueOf(i))
            writeFileLog(inputFile, ticket)
            if (i % AMOUNT_LOG_SLEEP == 0)
                sleep(TIME_SLEEP)
        }
    }

    static void writeFileLog(def inputFile, Ticket ticket) {
        String jsonTicket = JsonOutput.toJson(ticket).toString() + PARSE_END
        if (inputFile.exists()) {
            inputFile.append(jsonTicket)
        } else {
            inputFile.write(jsonTicket)
        }
    }
}
