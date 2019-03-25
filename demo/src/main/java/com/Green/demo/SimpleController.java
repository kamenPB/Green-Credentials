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

        model.addAttribute("monthName", getLastMonthName());

        model.addAttribute("currentYear", getCurrentYear());
        model.addAttribute("lastYear", getLastYear());
        model.addAttribute("twoYearsAgo", getTwoYearsAgo());

        model.addAttribute("wasteTotal", wasteTotal(getLastMonth(), 2));
        model.addAttribute("wasteRecycled", wasteRecycled(getLastMonth(), 2));

        model.addAttribute("waterConsumedCurrentYear", waterConsumed(getLastMonth(), 3));
        model.addAttribute("waterConsumedLastYear", waterConsumed(getLastMonth(), 2));
        model.addAttribute("waterConsumedTwoYearsAgo", waterConsumed(getLastMonth(), 1));

        model.addAttribute("electricityConsumedCurrentYear", electricityConsumed(getLastMonth(), 3));
        model.addAttribute("electricityConsumedLastYear", electricityConsumed(getLastMonth(), 2));
        model.addAttribute("electricityConsumedTwoYearsAgo", electricityConsumed(getLastMonth(), 1));

        model.addAttribute("gasConsumedCurrentYear", gasConsumed(getLastMonth(), 3));
        model.addAttribute("gasConsumedLastYear", gasConsumed(getLastMonth(), 2));
        model.addAttribute("gasConsumedTwoYearsAgo", gasConsumed(getLastMonth(), 1));

        model.addAttribute("wasteCommentHeader", commentHeader("waste"));
        model.addAttribute("wasteComment", comment("waste"));
        model.addAttribute("waterCommentHeader", commentHeader("water"));
        model.addAttribute("waterComment", comment("water"));
        model.addAttribute("electricityCommentHeader", commentHeader("electricity"));
        model.addAttribute("electricityComment", comment("electricity"));
        model.addAttribute("gasCommentHeader", commentHeader("gas"));
        model.addAttribute("gasComment", comment("gas"));

        return "home";
    }

}