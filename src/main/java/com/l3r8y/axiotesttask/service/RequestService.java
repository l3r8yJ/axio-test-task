package com.l3r8y.axiotesttask.service;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import java.util.List;

public interface RequestService {

    List<RequestEntity> all();

    void create(final CustomerEntity customer);
}
