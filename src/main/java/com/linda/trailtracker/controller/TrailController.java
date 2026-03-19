package com.linda.trailtracker.controller;

import com.linda.trailtracker.service.TrailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trails")
public class TrailController {

    private final TrailService trailService;

    public TrailController(TrailService trailService){
        this.trailService =trailService;
    }

    @GetMapping
    public String listTrails(Model model) {
        model.addAttribute("trails", trailService.getAllTrails());
        return "list";
    }
}
