package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.dto.RequestDTO;
import com.l3r8y.axiotesttask.service.CustomerService;
import com.l3r8y.axiotesttask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final CustomerService customerService;

    private final RequestService requestService;

    @Autowired
    public ViewController(
        final CustomerService customerService,
        final RequestService requestService
    ) {
        this.customerService = customerService;
        this.requestService = requestService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customers")
    public String customers(final Model model) {
        model.addAttribute("customers", this.customerService.all());
        return "customers";
    }

    @GetMapping("/requests")
    public String requests(final Model model) {
        model.addAttribute("requests", this.requestService.all());
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
