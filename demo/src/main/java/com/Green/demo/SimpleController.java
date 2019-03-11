package com.Green.demo;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import java.util.List;
//import org.springframework.boot.SpringApplication;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class SimpleController {
//    @Value("${spring.application.name}")
//    String appName;
//
//    @GetMapping("/home")
//    public String homePage(Model model) {
//        model.addAttribute("appName", appName);
//        return "home";
//    }
//}

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController extends ConsumptionData{
    int eighty = 80;
    @GetMapping("/home")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("eighty", getWasteTotal(1, 2));
//        model.addAttribute("");
        return "home";
    }

}