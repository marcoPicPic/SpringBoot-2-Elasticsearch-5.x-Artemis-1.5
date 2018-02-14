package com.artemis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Ticket implements Serializable {

    private String id;

    private String date_stat;
    private String realtime_counter_id;
    private String index;
    private String counter_code;
    private String entity_id;
    private String entity_type;
    private String entity_uuid;
    private String entity_name;
    private String counter_id;
    private String tenant_id;
    private String realtime_counter_value_type;
    private String entity_type_name;
    private String realtime_counter_value;
    private String tenant_uuid;
    private String tenant_name;
    private String realtime_counter_rolling;
    private String realtime_counter_raz;

    public Ticket(String date_stat, String realtime_counter_id, String index, String counter_code,
                  String entity_id, String entity_type, String entity_uuid, String entity_name,
                  String counter_id, String tenant_id, String realtime_counter_value_type,
                  String entity_type_name, String realtime_counter_value, String tenant_uuid,
                  String tenant_name, String realtime_counter_rolling, String realtime_counter_raz) {
        this.date_stat = date_stat;
        this.realtime_counter_id = realtime_counter_id;
        this.index = index;
        this.counter_code = counter_code;
        this.entity_id = entity_id;
        this.entity_type = entity_type;
        this.entity_uuid = entity_uuid;
        this.entity_name = entity_name;
        this.counter_id = counter_id;
        this.tenant_id = tenant_id;
        this.realtime_counter_value_type = realtime_counter_value_type;
        this.entity_type_name = entity_type_name;
        this.realtime_counter_value = realtime_counter_value;
        this.tenant_uuid = tenant_uuid;
        this.tenant_name = tenant_name;
        this.realtime_counter_rolling = realtime_counter_rolling;
        this.realtime_counter_raz = realtime_counter_raz;
    }
    

    public Ticket generateTicket(int i) {
        return new Ticket("2017-10-25T12:44:33.115Z",
                "OldestUnProc.1.13" + i,
                "realtime_counters_f0e59e00-ed4c-4068-bf7c-f99e69ab4fc1_3_2017-10-25",
                "OldestUnProc",
                "13",
                "1",
                "7465ed00-9d8f-4bca-984b-95cf0db4364d",
                "courrier1",
                "73",
                "3",
                "0",
                "queue",
                "1475588902245",
                "f0e59e00-ed4c-4068-bf7c-f99e69ab4fc1" + i,
                "TENANT3",
                "false",
                "false");
    }

}
