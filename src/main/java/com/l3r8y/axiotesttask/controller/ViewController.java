package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final CustomerService service;

    @Autowired
    public ViewController(final CustomerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customers")
    public String customers(final Model model) {
        model.addAttribute("customers", this.service.all());
        return "customers";
    }

    @GetMapping("/requests")
    public String requests() {
        return "requests";
    }

    @GetMapping("/request/new")
    public String newRequest() {
        return "request-new";
    }

    @GetMapping("assign")
    public String contracts() {
        return "contracts";
    }
}
