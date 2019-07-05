package com.Green.demo.controller;

import com.Green.demo.controller.ConsumptionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController extends ConsumptionData {
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);

        model.addAttribute("monthName", getLastMonthName());

        model.addAttribute("currentYear", getCurrentYear());
        model.addAttribute("lastYear", getLastYear());
        model.addAttribute("twoYearsAgo", getTwoYearsAgo());

        model.addAttribute("wasteTotal", wasteTotal(getLastMonth()));
        model.addAttribute("wasteRecycled", wasteRecycled(getLastMonth()));

        model.addAttribute("waterConsumedCurrentYear", waterConsumed(getLastMonth(), 3));
        model.addAttribute("waterConsumedLastYear", waterConsumed(getLastMonth(), 2));
        model.addAttribute("waterConsumedTwoYearsAgo", waterConsumed(getLastMonth(), 1));

        model.addAttribute("electricityConsumedCurrentYear", electricityConsumed(getLastMonth(), 3));
        model.addAttribute("electricityConsumedLastYear", electricityConsumed(getLastMonth(), 2));
        model.addAttribute("electricityConsumedTwoYearsAgo", electricityConsumed(getLastMonth(), 1));

        model.addAttribute("gasConsumedCurrentYear", gasConsumed(getLastMonth(), 3));
        model.addAttribute("gasConsumedLastYear", gasConsumed(getLastMonth(), 2));
        model.addAttribute("gasConsumedTwoYearsAgo", gasConsumed(getLastMonth(), 1));

        model.addAttribute("wasteCommentHeader", commentHeader(WASTE));
        model.addAttribute("wasteComment", comment(WATER));
        model.addAttribute("waterCommentHeader", commentHeader(WATER));
        model.addAttribute("waterComment", comment(WATER));
        model.addAttribute("electricityCommentHeader", commentHeader(ELECTRICITY));
        model.addAttribute("electricityComment", comment(ELECTRICITY));
        model.addAttribute("gasCommentHeader", commentHeader(GAS));
        model.addAttribute("gasComment", comment(GAS));

        return "home";
    }

}