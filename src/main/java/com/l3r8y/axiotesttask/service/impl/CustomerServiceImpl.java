package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.repository.CustomerRepository;
import com.l3r8y.axiotesttask.service.CustomerService;
import java.util.List;
import java.util.NoSuchElementException;
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
    public List<CustomerEntity> all() {
        return this.repository.findAll();
    }

    @Override
    public void create(final CustomerEntity entity) {
        this.repository.save(entity);
    }

    @Override
    public void update(final CustomerEntity entity) {
        this.repository.save(entity);
    }

    @Override
    public void delete(final CustomerEntity entity) {
        this.repository.delete(entity);
    }

    @Override
    public CustomerEntity byId(final Long id) {
        return this.repository
            .findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<CustomerEntity> search(final CustomerEntity dto) {
        return null;
    }
}
