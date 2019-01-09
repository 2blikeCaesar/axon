package com.sds.customer.event;

import lombok.Value;

@Value
public class UpdateCustomerEvent {
    private String customerAggregateId;
    private String name;
    private String email;
}
