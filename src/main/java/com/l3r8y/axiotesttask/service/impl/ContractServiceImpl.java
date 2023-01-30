package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.entity.ContractEntity;
import com.l3r8y.axiotesttask.repository.ContractRepository;
import com.l3r8y.axiotesttask.service.ContractService;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Autowired
    public ContractServiceImpl(final ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ContractEntity> all() {
        return this.repository.findAll();
    }

    @Override
    public void assign(final ContractEntity contract) {
        contract.setSigned(true);
        contract.setDateSignature(new Date(Instant.now().toEpochMilli()));
        this.repository.save(contract);
    }

    @Override
    public ContractEntity byId(final Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}