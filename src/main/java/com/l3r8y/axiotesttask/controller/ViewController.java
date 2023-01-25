package com.l3r8y.axiotesttask.controller;

import com.jcabi.log.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

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
        Logger.info(this, "#index() called");
        return "index";
    }
}
