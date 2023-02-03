package com.l3r8y.axiotesttask.dao;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository {

    List<CustomerEntity> findCustomerEntitiesByFioContaining(String fio);

    List<CustomerEntity> findCustomerEntitiesByPhoneContaining(String phone);

    List<CustomerEntity> findCustomerEntitiesByPassportContaining(String passport);

    List<CustomerEntity> findAll();

    void save(CustomerEntity customer);

    void deleteById(Long id);
}
