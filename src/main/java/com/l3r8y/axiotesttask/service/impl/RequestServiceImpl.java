package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.entity.ContractEntity;
import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import com.l3r8y.axiotesttask.dao.ContractRepository;
import com.l3r8y.axiotesttask.dao.RequestRepository;
import com.l3r8y.axiotesttask.service.RequestService;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final ContractRepository contractRepository;

    @Autowired
    public RequestServiceImpl(
        final RequestRepository requestRepository,
        final ContractRepository contractRepository
    ) {
        this.requestRepository = requestRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public List<RequestEntity> all() {
        return this.requestRepository.findAll();
    }

    @Override
    public void create(final CustomerEntity customer) {
        final RequestEntity request = this.requestByCustomer(customer);
        this.requestRepository.save(request);
        this.createContractIfStatusPositive(request);
    }

    private RequestEntity requestByCustomer(final CustomerEntity customer) {
        return RequestEntity
            .builder()
            .status(new Random().nextBoolean())
            .period(new Random().nextInt(360 - 30) + 30)
            .amount(customer.getCreditAmount())
            .customer(customer)
            .build();
    }

    private void createContractIfStatusPositive(final RequestEntity request) {
        if (request.isStatus()) {
            this.contractRepository.save(
                ContractEntity.builder()
                    .request(request)
                    .signed(false)
                    .build()
            );
        }
    }
}
