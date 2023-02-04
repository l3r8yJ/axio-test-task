package com.l3r8y.axiotesttask.dao;

import com.l3r8y.axiotesttask.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository {

    List<CustomerEntity> byFioLike(String fio);

    List<CustomerEntity> byPhoneLike(String phone);

    List<CustomerEntity> byPassportLike(String passport);

    List<CustomerEntity> findAll();

    void save(CustomerEntity customer);

    void deleteById(Long id);
}
