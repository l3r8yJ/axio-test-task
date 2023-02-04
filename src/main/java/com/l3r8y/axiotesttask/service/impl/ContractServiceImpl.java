package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.entity.ContractEntity;
import com.l3r8y.axiotesttask.dao.ContractRepository;
import com.l3r8y.axiotesttask.service.ContractService;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Autowired
    public ContractServiceImpl(final ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<ContractEntity> all() {
        return this.repository.findAll();
    }

    @Override
    @Transactional
    public void assign(final ContractEntity contract) {
        final ContractEntity current = ContractEntity.builder()
            .idContract(contract.getIdContract())
            .signed(true)
            .dateSignature(new Date(Instant.now().toEpochMilli()))
            .request(contract.getRequest())
            .build();
        this.repository.update(current);
    }

    @Override
    @Transactional
    public ContractEntity byId(final Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}
