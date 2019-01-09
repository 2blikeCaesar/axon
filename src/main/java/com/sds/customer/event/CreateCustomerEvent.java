package com.sds.customer.event;

import lombok.Value;

@Value
public class CreateCustomerEvent {
    private String customerAggregateId;
    private String name;
    private String email;
}
