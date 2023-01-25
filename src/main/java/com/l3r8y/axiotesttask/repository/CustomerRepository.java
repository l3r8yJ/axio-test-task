package com.l3r8y.axiotesttask.repository;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
