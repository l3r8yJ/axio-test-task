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
    public CustomerRepositoryImpl(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<CustomerEntity> byFioLike(final String fio) {
        return this.currentSession().createQuery(
            this.likeQuery("fio"),
            CustomerEntity.class
        ).setParameter("fio", fio).list();
    }

    @Override
    public List<CustomerEntity> byPhoneLike(final String phone) {
        return this.currentSession().createQuery(
            this.likeQuery("phone"),
            CustomerEntity.class
        ).setParameter("phone", phone).list();

    }

    @Override
    public List<CustomerEntity> byPassportLike(final String passport) {
        return this.currentSession().createQuery(
            this.likeQuery("passport"),
            CustomerEntity.class
        ).setParameter("passport", passport).list();
    }

    @Override
    public List<CustomerEntity> findAll() {
        return this.currentSession()
            .createQuery("from CustomerEntity", CustomerEntity.class).list();
    }

    @Override
    public void save(final CustomerEntity customer) {
        this.currentSession().save(customer);
    }

    @Override
    public void deleteById(final Long id) {
        this.currentSession().delete(
            this.currentSession().get(CustomerEntity.class, id.intValue())
        );
    }

    private Session currentSession() {
        return this.factory.getCurrentSession();
    }

    private String likeQuery(final String field) {
        return "from CustomerEntity where " + field + " like concat('%', :" + field + ", '%')";
    }
}
