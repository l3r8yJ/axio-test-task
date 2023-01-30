package com.l3r8y.axiotesttask.service;

import com.l3r8y.axiotesttask.dto.CustomerSearch;
import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.exception.CustomerNotFoundException;
import java.util.List;

public interface CustomerService {

    List<CustomerEntity> all();

    void create(CustomerEntity dto);

    void update(CustomerEntity dto);

    void delete(Long id);

    CustomerEntity byId(Long id);

    List<CustomerEntity> search(CustomerSearch search) throws CustomerNotFoundException;
}
