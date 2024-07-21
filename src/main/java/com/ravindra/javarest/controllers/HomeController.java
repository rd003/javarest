package com.ravindra.javarest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "TODO LIST REST API");
        return "index";
    }
   
}
