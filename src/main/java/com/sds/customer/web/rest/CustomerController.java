package com.sds.customer.web.rest;

import com.sds.customer.command.CreateCustomerCommand;
import com.sds.customer.command.UpdateCustomerCommand;
import com.sds.customer.dto.CreateCustomerDTO;
import com.sds.customer.dto.UpdateCustomerDTO;
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

    @PostMapping("/create")
    public void createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand(createCustomerDTO.getName(), createCustomerDTO.getEmail());
        commandGateway.send(createCustomerCommand);
    }

    @PostMapping("/update")
    public void updateCustomer(@RequestBody UpdateCustomerDTO updateCustomerDTO) {
        UpdateCustomerCommand updateCustomerCommand = new UpdateCustomerCommand(updateCustomerDTO.getCustomerId(), updateCustomerDTO.getName(), updateCustomerDTO.getEmail());
        commandGateway.send(updateCustomerCommand);
    }
}
