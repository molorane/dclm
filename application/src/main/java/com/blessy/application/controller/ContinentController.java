package com.blessy.application.controller;


import com.blessy.application.model.Continent;
import com.blessy.application.service.ContinentService;
import com.blessy.application.utils.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin/continents")
public class ContinentController {

    private final ContinentService continentService;

    @Autowired
    public ContinentController(ContinentService continentService){
        this.continentService = continentService;
    }

    @RequestMapping({"/",""})
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
    public String addPostContinent(@ModelAttribute("continent") @Valid Continent continent, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return WebPage.ADD_CONTINENT.getPageName();
        }

        continentService.addContinent(continent);

        model.addAttribute("saved", true);

        return WebPage.ADD_CONTINENT.getPageName();
    }

    @RequestMapping("/{continent_id}")
    public String countriesInContinent(@PathVariable("continent_id") Long continent_id, Model model) {
        Continent continent = continentService.findById(continent_id).get();
        model.addAttribute("continent", continent);
        return WebPage.CONTINENT_COUNTRIES.getPageName();
    }

}
