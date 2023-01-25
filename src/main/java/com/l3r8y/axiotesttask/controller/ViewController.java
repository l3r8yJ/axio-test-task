package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.dto.CustomerDTO;
import com.l3r8y.axiotesttask.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final CustomerService service;

    @Autowired
    public ViewController(final CustomerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(
        @RequestParam(
            name = "name",
            required = false,
            defaultValue = "from Spring"
        )
        final String name,
        final Model model
    ) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/customer/all")
    public ResponseEntity<List<CustomerDTO>> all() {
        return new ResponseEntity<>(
            this.service.all(),
            HttpStatus.OK
        );
    }
}
