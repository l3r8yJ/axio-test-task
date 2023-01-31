package com.l3r8y.axiotesttask.controller;

import com.l3r8y.axiotesttask.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(final ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("contracts")
    public String contracts(final Model model) {
        model.addAttribute("contracts", this.contractService.all());
        return "contracts";
    }

    @GetMapping("contract/assign/{id}")
    public String sign(@PathVariable final String id) {
        this.contractService.assign(
            this.contractService.byId(Long.valueOf(id))
        );
        return "redirect:/contracts";
    }
}
