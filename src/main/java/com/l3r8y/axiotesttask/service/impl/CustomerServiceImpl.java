package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.dao.CustomerRepository;
import com.l3r8y.axiotesttask.dto.CustomerSearch;
import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.exception.CustomerNotFoundException;
import com.l3r8y.axiotesttask.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<CustomerEntity> all() {
        return this.repository.findAll();
    }

    @Override
    @Transactional
    public void create(final CustomerEntity entity) {
        this.repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public List<CustomerEntity> search(final CustomerSearch search)
        throws CustomerNotFoundException {
        if (!search.getPhone().equals("%")) {
            return Optional.of(
                this.repository.byPhoneLike(search.getPhone())
            ).orElseThrow(CustomerNotFoundException::new);
        }
        if (!search.getFio().equals("%")) {
            return Optional.of(
                this.repository.byFioLike(search.getFio())
            ).orElseThrow(CustomerNotFoundException::new);
        }
        if (!search.getPassport().equals("%")) {
            return Optional.of(
                this.repository.byPassportLike(search.getPassport())
            ).orElseThrow(CustomerNotFoundException::new);
        }
        throw new CustomerNotFoundException();
    }
}
