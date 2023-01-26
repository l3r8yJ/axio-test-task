package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import com.l3r8y.axiotesttask.repository.RequestRepository;
import com.l3r8y.axiotesttask.service.RequestService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;

    @Autowired
    public RequestServiceImpl(final RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RequestEntity> all() {
        return this.repository.findAll();
    }

    @Override
    public void create(final CustomerEntity customer) {
        final RequestEntity entity = RequestEntity
            .builder()
            .status(new Random().nextBoolean())
            .period(new Random().nextInt(360 - 30) + 30)
            .amount(customer.getCreditAmount())
            .customer(customer)
            .build();
        this.repository.save(entity);
    }
}
