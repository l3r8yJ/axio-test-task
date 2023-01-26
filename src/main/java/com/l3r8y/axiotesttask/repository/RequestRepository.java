package com.l3r8y.axiotesttask.repository;

import com.l3r8y.axiotesttask.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

}
