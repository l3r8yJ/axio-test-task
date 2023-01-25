package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.repository.CustomerRepository;
import com.l3r8y.axiotesttask.dto.CustomerDTO;
import com.l3r8y.axiotesttask.service.CustomerService;
import com.l3r8y.axiotesttask.util.CustomerMapper;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerDTO> all() {
        return this.repository
            .findAll()
            .stream()
            .map(CustomerMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void create(final CustomerDTO dto) {
        this.repository.save(CustomerMapper.toEntity(dto));
    }

    @Override
    public void update(final CustomerDTO dto) {
        this.repository.save(CustomerMapper.toEntity(dto));
    }

    @Override
    public void delete(final CustomerDTO dto) {
        this.repository.delete(CustomerMapper.toEntity(dto));
    }

    @Override
    public CustomerDTO byId(final Long id) {
        return CustomerMapper.toDTO(
            this.repository.findById(id).orElseThrow(NoSuchElementException::new)
        );
    }

    @Override
    public List<CustomerDTO> search(final CustomerDTO dto) {
        return null;
    }
}
