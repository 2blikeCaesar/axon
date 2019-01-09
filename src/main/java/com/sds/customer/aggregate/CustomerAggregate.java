package com.sds.customer.aggregate;

import com.sds.customer.command.CreateCustomerCommand;
import com.sds.customer.command.UpdateCustomerCommand;
import com.sds.customer.event.CreateCustomerEvent;
import com.sds.customer.event.UpdateCustomerEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate(snapshotTriggerDefinition = "eventCountSnapshotTriggerDefinition")
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;

    private String name;
    private String email;

    private CustomerAggregate (){

    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand) {
        apply(new CreateCustomerEvent(createCustomerCommand.getCustomerAggregateId(), createCustomerCommand.getName(), createCustomerCommand.getEmail()));
    }

    @CommandHandler
    public void update(UpdateCustomerCommand updateCustomerCommand) {
        apply(new UpdateCustomerEvent(updateCustomerCommand.getCustomerAggregateId(), updateCustomerCommand.getName(), updateCustomerCommand.getEmail()));
    }

    @EventSourcingHandler
    public void on (CreateCustomerEvent createCustomerEvent) {
        this.id = createCustomerEvent.getCustomerAggregateId();
        this.name = createCustomerEvent.getName();
        this.email = createCustomerEvent.getEmail();

    }

    @EventSourcingHandler
    public void on (UpdateCustomerEvent updateCustomerEvent) {
        this.name = updateCustomerEvent.getName();
        this.email = updateCustomerEvent.getEmail();
//        this.id = createCustomerEvent.getCustomerAggregateId();
    }
}
