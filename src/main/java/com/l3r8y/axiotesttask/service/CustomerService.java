package com.l3r8y.axiotesttask.service;

import com.l3r8y.axiotesttask.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {

    List<CustomerDTO> all();

    void create(CustomerDTO dto);

    void update(CustomerDTO dto);

    void delete(CustomerDTO dto);

    CustomerDTO byId(Long id);

    List<CustomerDTO> search(CustomerDTO dto);
}
