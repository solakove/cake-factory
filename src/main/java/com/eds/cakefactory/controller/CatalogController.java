package com.eds.cakefactory.controller;

import com.eds.cakefactory.model.Cake;
import com.eds.cakefactory.service.ICakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    ICakeService cakeService;

    @GetMapping("getCakes")
    public String getCakes(Model model) {
        List<Cake> cakes =cakeService.getCakes();

        model.addAttribute("cakes", cakes);

        return "index";
    }

}
