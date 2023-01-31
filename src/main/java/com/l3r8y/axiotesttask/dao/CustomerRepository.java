package com.l3r8y.axiotesttask.dao;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>,
    JpaSpecificationExecutor<CustomerEntity> {

    List<CustomerEntity> findCustomerEntitiesByFioContaining(String fio);

    List<CustomerEntity> findCustomerEntitiesByPhoneContaining(String phone);

    List<CustomerEntity> findCustomerEntitiesByPassportContaining(String passport);

}
