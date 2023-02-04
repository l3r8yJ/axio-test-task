package com.l3r8y.axiotesttask.dao;

import com.l3r8y.axiotesttask.entity.RequestEntity;

import java.util.List;

public interface RequestRepository {

    List<RequestEntity> findAll();

    void save(RequestEntity request);
}
