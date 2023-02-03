package com.l3r8y.axiotesttask.dao.impl;

import com.l3r8y.axiotesttask.dao.CustomerRepository;
import com.l3r8y.axiotesttask.entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory factory;

    @Autowired
    public CustomerRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<CustomerEntity> findCustomerEntitiesByFioContaining(String fio) {
        return null;
    }

    @Override
    public List<CustomerEntity> findCustomerEntitiesByPhoneContaining(String phone) {
        return null;
    }

    @Override
    public List<CustomerEntity> findCustomerEntitiesByPassportContaining(String passport) {
        return null;
    }

    @Override
    public List<CustomerEntity> findAll() {
        final Session session = this.factory.getCurrentSession();
        return session.createQuery("from CustomerEntity", CustomerEntity.class).list();
    }

    @Override
    public void save(CustomerEntity customer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
