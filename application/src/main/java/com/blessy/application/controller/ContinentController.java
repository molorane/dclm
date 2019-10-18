package com.blessy.application.controller;


import com.blessy.application.model.Continent;
import com.blessy.application.model.Country;
import com.blessy.application.service.ContinentService;
import com.blessy.application.service.CountryService;
import com.blessy.application.utils.WebPage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin/continents")
public class ContinentController {

    private final ContinentService continentService;
    private final CountryService countryService;

    @RequestMapping({"/",""})
    public String continents(Model model) {
        model.addAttribute("continents", continentService.findAll());
        return WebPage.CONTINENTS.getPageName();
    }

    @RequestMapping("/addContinent")
    public String addGetContinent(Model model) {
        model.addAttribute("continent", new Continent());
        return WebPage.ADD_CONTINENT.getPageName();
    }

    @PostMapping("/addContinent")
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

    @RequestMapping("addCountry/{continent_id}")
    public String addCountry(@PathVariable("continent_id") Long continent_id, Model model) {
        Continent continent = continentService.findById(continent_id).get();
        Country country = new Country();
        country.setContinent(continent);
        model.addAttribute("country", country);
        return WebPage.ADD_CONTINENT_COUNTRY.getPageName();
    }

    @PostMapping("addCountry/{continent_id}")
    public String addCountry(@ModelAttribute("country") @Valid Country country, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return WebPage.ADD_CONTINENT_COUNTRY.getPageName();
        }
        countryService.addCountry(country);
        model.addAttribute("saved", true);
        return WebPage.ADD_CONTINENT_COUNTRY.getPageName();
    }

}
