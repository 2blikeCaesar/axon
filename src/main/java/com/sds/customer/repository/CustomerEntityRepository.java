package com.sds.customer.repository;

import com.sds.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findOneByCustomerAggregateId(String customerAggregateId);
}
