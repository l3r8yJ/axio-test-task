package com.l3r8y.axiotesttask.dao.impl;

import com.l3r8y.axiotesttask.dao.RequestRepository;
import com.l3r8y.axiotesttask.entity.RequestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepositoryImpl implements RequestRepository {

    private final SessionFactory factory;

    @Autowired
    public RequestRepositoryImpl(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<RequestEntity> findAll() {
        return this.currentSession()
            .createQuery("from RequestEntity", RequestEntity.class)
            .list();
    }

    @Override
    public void save(final RequestEntity request) {
        this.currentSession().save(request);
    }

    private Session currentSession() {
        return this.factory.getCurrentSession();
    }
}
