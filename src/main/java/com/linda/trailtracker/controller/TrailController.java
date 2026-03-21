package com.linda.trailtracker.controller;

import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.dto.UpdateTrailDto;
import com.linda.trailtracker.service.TrailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public String createTrail(@Valid @ModelAttribute("trail") CreateTrailDto dto,
                              BindingResult result) {

        if (result.hasErrors()) {
            return "trails/create";
        }

        trailService.createTrail(dto);
        return "redirect:/trails";
    }

    //Update trail, hämta via id
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        TrailDto trail = trailService.getTrailDtoById(id);

        UpdateTrailDto dto = new UpdateTrailDto();
        dto.setName(trail.getName());
        dto.setDistanceKm(trail.getDistanceKm());
        dto.setTimeMinutes(trail.getTimeMinutes());
        dto.setElevationGain(trail.getElevationGain());
        dto.setDescription(trail.getDescription());
        dto.setLocation(trail.getLocation());

        model.addAttribute("trail", dto);
        model.addAttribute("trailId", id);

        return "trails/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateTrail(@PathVariable Long id,
                              @Valid @ModelAttribute("trail") UpdateTrailDto dto,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            model.addAttribute("trailId", id);
            return "trails/edit";
        }

        trailService.updateTrail(id, dto);
        return "redirect:/trails";
    }
    //Delete trail
    @PostMapping("/{id}/delete")
    public String deleteTrail(@PathVariable Long id) {
        trailService.deleteTrail(id);
        return "redirect:/trails";
    }
}
