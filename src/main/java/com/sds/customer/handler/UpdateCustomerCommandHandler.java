package com.sds.customer.handler;

import com.sds.customer.command.UpdateCustomerCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerCommandHandler {

    @CommandHandler
    public void update(UpdateCustomerCommand updateCustomerCommand) {
        System.out.println("Update Customer " + updateCustomerCommand.getCustomerId());
        System.out.println("Name : " + updateCustomerCommand.getName() + " Email : " + updateCustomerCommand.getEmail());
    }
}
