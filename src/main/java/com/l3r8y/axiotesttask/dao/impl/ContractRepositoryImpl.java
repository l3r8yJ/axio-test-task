package com.l3r8y.axiotesttask.dao.impl;

import com.l3r8y.axiotesttask.dao.ContractRepository;
import com.l3r8y.axiotesttask.entity.ContractEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    @Override
    public List<ContractEntity> findAll() {
        return null;
    }

    @Override
    public void save(ContractEntity contract) {

    }

    @Override
    public Optional<ContractEntity> findById(Long id) {
        return Optional.empty();
    }
}
