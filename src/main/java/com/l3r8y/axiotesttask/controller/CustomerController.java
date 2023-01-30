package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.dto.CustomerSearch;
import com.l3r8y.axiotesttask.exception.CustomerNotFoundException;
import com.l3r8y.axiotesttask.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String customers(final Model model) {
        model.addAttribute("customers", this.customerService.all());
        return "customers";
    }

    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable final Long id) {
        this.customerService.delete(id);
        return "redirect:/customers";
    }

    @GetMapping("/customers/search{fio}{phone}{passport}")
    public String search(
        @PathVariable(required = false) final String fio,
        @PathVariable(required = false) final String phone,
        @PathVariable(required = false) final String passport,
        final Model model
    ) {
        try {
            model.addAttribute(
                "customers",
                this.customerService.search(
                    new CustomerSearch(fio, passport, phone)
                )
            );
        } catch (final CustomerNotFoundException ex) {
            model.addAttribute("customerNotFound", ex.getMessage());
        }
        return "/customers";
    }

}
