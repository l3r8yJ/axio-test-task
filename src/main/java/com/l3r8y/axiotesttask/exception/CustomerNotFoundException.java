package com.l3r8y.axiotesttask.exception;

/**
 * Exception when {@link com.l3r8y.axiotesttask.entity.CustomerEntity} not found
 * in {@link com.l3r8y.axiotesttask.repository.CustomerRepository}
 */
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super("По вашему запросу ничего не найдено");
    }
}
