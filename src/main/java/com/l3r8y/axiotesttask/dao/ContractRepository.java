package com.l3r8y.axiotesttask.dao;

import com.l3r8y.axiotesttask.entity.ContractEntity;

import java.util.List;
import java.util.Optional;

public interface ContractRepository {

    List<ContractEntity> findAll();

    void save(ContractEntity contract);

    Optional<ContractEntity> findById(Long id);
}
