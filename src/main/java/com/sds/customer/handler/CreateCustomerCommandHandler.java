package com.sds.customer.handler;

import com.sds.customer.command.CreateCustomerCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerCommandHandler {

    @CommandHandler
    public void create(CreateCustomerCommand createCustomerCommand) {
        System.out.println("Create Customer!");
        System.out.println("Name : " + createCustomerCommand.getName() + " Email : " + createCustomerCommand.getEmail());
    }
}
