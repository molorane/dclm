package com.blessy.application.controller;


import com.blessy.application.model.Continent;
import com.blessy.application.service.ContinentService;
import com.blessy.application.utils.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/continent")
public class ContinentController {

    private final ContinentService continentService;

    @Autowired
    public ContinentController(ContinentService continentService){
        this.continentService = continentService;
    }

    @RequestMapping("/all")
    public String continents(Model model) {
        model.addAttribute("continents", continentService.findAll());
        return WebPage.CONTINENTS.getPageName();
    }

    @RequestMapping("/add")
    public String addGetContinent(Model model) {
        model.addAttribute("continent", new Continent());
        return WebPage.ADD_CONTINENT.getPageName();
    }

    @PostMapping("/add")
    public String addPostContinent(@ModelAttribute("continent") @Valid Continent saveUser, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return WebPage.ADD_CONTINENT.getPageName();
        }

        return WebPage.ADD_CONTINENT.getPageName();
    }

}
