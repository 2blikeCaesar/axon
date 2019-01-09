package com.sds.customer.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class UpdateCustomerCommand {
    @TargetAggregateIdentifier
    private String customerAggregateId;
    private String name;
    private String email;
}
