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

import java.io.IOException;

@Controller
public class SimpleController extends ConsumptionData{
    int eighty = 80;
    @GetMapping("/home")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws IOException {
        model.addAttribute("name", name);
        model.addAttribute("wasteTotal", wasteTotal(getCurrentMonth() - 1, 2));
        model.addAttribute("wasteRecycled", wasteRecycled(1, 2));
        model.addAttribute("waterConsumedCurr", waterConsumed(1, 3));
        model.addAttribute("waterConsumedPrev1", waterConsumed(1, 2));
        model.addAttribute("waterConsumedPrev2", waterConsumed(1, 1));
        model.addAttribute("electricityConsumedCurr", electricityConsumed(1, 3));
        model.addAttribute("electricityConsumedPrev1", electricityConsumed(1, 2));
        model.addAttribute("electricityConsumedPrev2", electricityConsumed(1, 1));
        model.addAttribute("gasConsumedCurr", gasConsumed(1, 3));
        model.addAttribute("gasConsumedPrev1", gasConsumed(1, 2));
        model.addAttribute("gasConsumedPrev2", gasConsumed(1, 1));
        return "home";
    }

}