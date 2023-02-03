package com.l3r8y.axiotesttask.dao.impl;

import com.l3r8y.axiotesttask.dao.RequestRepository;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepositoryImpl implements RequestRepository {

    @Override
    public List<RequestEntity> findAll() {
        return null;
    }

    @Override
    public void save(RequestEntity request) {

    }
}
