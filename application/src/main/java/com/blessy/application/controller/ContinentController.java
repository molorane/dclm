package com.blessy.application.controller;


import com.blessy.application.service.IContinentService;
import com.blessy.application.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ContinentController {

    private final IContinentService continentService;

    @Autowired
    public ContinentController(IContinentService continentService){
        this.continentService = continentService;
    }

    @GetMapping("/continents")
    public String continents(Model model) {
        model.addAttribute("continents", continentService.findAll());
        return "index";
    }

}