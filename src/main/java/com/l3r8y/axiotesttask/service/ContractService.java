package com.l3r8y.axiotesttask.service;

import com.l3r8y.axiotesttask.entity.ContractEntity;
import java.util.List;

public interface ContractService {

    List<ContractEntity> all();

    void assign(ContractEntity contract);

    ContractEntity byId(Long id);
}
