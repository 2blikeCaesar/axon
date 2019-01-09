package com.sds.customer.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustomerDTO {
    private String customerAggregateId;
    private String name;
    private String email;
}
