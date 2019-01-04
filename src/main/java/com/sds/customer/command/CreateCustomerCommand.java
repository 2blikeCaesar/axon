package com.sds.customer.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateCustomerCommand {
    private String name;
    private String email;
}
