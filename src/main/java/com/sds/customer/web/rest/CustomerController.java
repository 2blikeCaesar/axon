package com.sds.customer.web.rest;

import com.sds.customer.command.CreateCustomerCommand;
import com.sds.customer.dto.CustomerDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sds.customer.web.rest.ApiConstants.API_V1_BASE_PATH;

@RestController
@RequestMapping(value = API_V1_BASE_PATH + "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand(customerDTO.getName(), customerDTO.getEmail());
        commandGateway.send(createCustomerCommand);
    }
}
