package com.sds.customer.handler;

import com.sds.customer.entity.CustomerEntity;
import com.sds.customer.event.CreateCustomerEvent;
import com.sds.customer.event.UpdateCustomerEvent;
import com.sds.customer.repository.CustomerEntityRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerEventHandler {

    private CustomerEntityRepository customerRepository;

    @Autowired
    public CreateCustomerEventHandler(CustomerEntityRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventHandler
    public void create(CreateCustomerEvent createCustomerEvent) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerAggregateId(createCustomerEvent.getCustomerAggregateId());
        customerEntity.setName(createCustomerEvent.getName());
        customerEntity.setEmail(createCustomerEvent.getEmail());
        customerRepository.save(customerEntity);
    }

    @EventHandler
    public void update(UpdateCustomerEvent updateCustomerEvent) {
        CustomerEntity customerEntity = customerRepository.findOneByCustomerAggregateId(updateCustomerEvent.getCustomerAggregateId());
        customerEntity.setName(updateCustomerEvent.getName());
        customerEntity.setEmail(updateCustomerEvent.getEmail());
        customerRepository.save(customerEntity);
    }

}
