package com.eds.cakefactory.controller;

import com.eds.cakefactory.model.Items;
import com.eds.cakefactory.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    IItemService cakeService;

    @GetMapping("getCakes")
    public String getCakes(Model model) {
        List<Items> items =cakeService.getItems();

        model.addAttribute("items", items);

        return "index";
    }

}
