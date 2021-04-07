package com.eds.cakefactory.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class StartPageController {

    @GetMapping("cakes")
    public String showStartPage(Model model) {
        List<String> cakes = Arrays.asList("Muffin", "Cake");

        model.addAttribute("cakes", cakes);

        return "index";
    }
}
