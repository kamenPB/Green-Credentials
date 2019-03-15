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
    @GetMapping("/home")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws IOException {
        model.addAttribute("name", name);

        model.addAttribute("monthName", getCurrentMonthName());

        model.addAttribute("currentYear", getCurrentYear());
        model.addAttribute("lastYear", getLastYear());
        model.addAttribute("twoYearsAgo", getTwoYearsAgo());

        model.addAttribute("wasteTotal", wasteTotal(getCurrentMonth(), 2));
        model.addAttribute("wasteRecycled", wasteRecycled(getCurrentMonth(), 2));

        model.addAttribute("waterConsumedCurrentYear", waterConsumed(getCurrentMonth(), 3));
        model.addAttribute("waterConsumedLastYear", waterConsumed(getCurrentMonth(), 2));
        model.addAttribute("waterConsumedTwoYearsAgo", waterConsumed(getCurrentMonth(), 1));

        model.addAttribute("electricityConsumedCurrentYear", electricityConsumed(getCurrentMonth(), 3));
        model.addAttribute("electricityConsumedLastYear", electricityConsumed(getCurrentMonth(), 2));
        model.addAttribute("electricityConsumedTwoYearsAgo", electricityConsumed(getCurrentMonth(), 1));

        model.addAttribute("gasConsumedCurrentYear", gasConsumed(getCurrentMonth(), 3));
        model.addAttribute("gasConsumedLastYear", gasConsumed(getCurrentMonth(), 2));
        model.addAttribute("gasConsumedTwoYearsAgo", gasConsumed(getCurrentMonth(), 1));

        return "home";
    }

}