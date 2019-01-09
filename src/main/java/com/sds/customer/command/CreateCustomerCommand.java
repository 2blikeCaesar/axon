package com.sds.customer.command;


import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String customerAggregateId;
    private String name;
    private String email;
}
