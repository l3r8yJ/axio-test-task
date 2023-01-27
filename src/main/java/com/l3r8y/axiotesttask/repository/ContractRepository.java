package com.l3r8y.axiotesttask.repository;

import com.l3r8y.axiotesttask.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

}
