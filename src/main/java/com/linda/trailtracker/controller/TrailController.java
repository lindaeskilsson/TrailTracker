package com.linda.trailtracker.controller;

import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.service.TrailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trails")
public class TrailController {

    private final TrailService trailService;

    public TrailController(TrailService trailService){
        this.trailService =trailService;
    }

    //list of trails
    @GetMapping
    public String listTrails(Model model) {
        model.addAttribute("trails", trailService.getAllTrails());
        return "trails/list";
    }

    //create new trail
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("trail", new CreateTrailDto());
        return "trails/create";
    }

    @PostMapping
    public String createTrail(@ModelAttribute("trail") CreateTrailDto dto){
        trailService.createTrail(dto);
    return "redirect:/trails";
    }
}
