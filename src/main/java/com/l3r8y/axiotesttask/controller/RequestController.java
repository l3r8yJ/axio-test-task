package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import com.l3r8y.axiotesttask.service.CustomerService;
import com.l3r8y.axiotesttask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestController {

    private final RequestService requestService;

    private final CustomerService customerService;

    @Autowired
    public RequestController(
        final RequestService requestService,
        final CustomerService customerService
    ) {
        this.requestService = requestService;
        this.customerService = customerService;
    }

    @PostMapping("/request/new/send")
    public String requestCreate(
        final CustomerEntity entity,
        final BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/request/new";
        }
        this.customerService.create(entity);
        this.requestService.create(entity);
        return "redirect:/requests";
    }
}
