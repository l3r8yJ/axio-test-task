package com.l3r8y.axiotesttask.dao.impl;

import com.l3r8y.axiotesttask.dao.ContractRepository;
import com.l3r8y.axiotesttask.entity.ContractEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private final SessionFactory factory;

    @Autowired
    public ContractRepositoryImpl(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<ContractEntity> findAll() {
        return this.currentSession()
            .createQuery("from ContractEntity", ContractEntity.class).list();
    }

    @Override
    public void save(final ContractEntity contract) {
        Transaction transaction = null;
        try(final Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(contract);
            transaction.commit();
        } catch (final Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new IllegalStateException("Error while saving new contract", ex);
        }
    }

    @Override
    public Optional<ContractEntity> findById(final Long id) {
        return Optional.ofNullable(
            this.currentSession().byId(ContractEntity.class).getReference(id.intValue())
        );
    }

    @Override
    public void update(final ContractEntity contract) {
        Transaction transaction = null;
        try(final Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(contract);
            transaction.commit();
        } catch (final Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new IllegalStateException("Error while saving new contract", ex);
        }
    }

    private Session currentSession() {
        return this.factory.getCurrentSession();
    }
}
