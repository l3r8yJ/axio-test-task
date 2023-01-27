package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
