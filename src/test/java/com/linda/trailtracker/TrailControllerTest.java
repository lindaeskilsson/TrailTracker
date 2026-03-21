package com.linda.trailtracker;

import com.linda.trailtracker.controller.TrailController;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.service.TrailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest(TrailController.class)
public class TrailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrailService trailService;

    // Testar att listvyn laddas korrekt

    @Test
    void listTrails_ShouldReturnListView() throws Exception {
        when(trailService.getAllTrails()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/trails"))
                .andExpect(status().isOk())
                .andExpect(view().name("trails/list"))
                .andExpect(model().attributeExists("trails"));

        verify(trailService, times(1)).getAllTrails();
    }


     //Testar att formuläret för att skapa en ny led visas.
    @Test
    void showCreateForm_ShouldReturnCreateView() throws Exception {
        mockMvc.perform(get("/trails/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("trails/create"))
                .andExpect(model().attributeExists("trail"));
    }


     //testar lyckad inskickning av formulär (create).

    @Test
    void createTrail_WithValidData_ShouldRedirect() throws Exception {
        mockMvc.perform(post("/trails/new")
                        .param("name", "Vandringsled A")
                        .param("distanceKm", "10.5")
                        .param("timeMinutes", "120")
                        .param("elevationGain", "300")
                        .param("description", "Fin led")
                        .param("location", "Åre"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/trails"));

        verify(trailService, times(1)).createTrail(any());
    }

    //Testar att redigeringsformuläret laddas med rätt data.

    @Test
    void showEditForm_ShouldPopulateModelAndReturnView() throws Exception {
        Long trailId = 1L;
        TrailDto mockTrail = new TrailDto();
        mockTrail.setName("Mock Trail");

        when(trailService.getTrailDtoById(trailId)).thenReturn(mockTrail);

        mockMvc.perform(get("/trails/" + trailId + "/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("trails/edit"))
                .andExpect(model().attributeExists("trail"))
                .andExpect(model().attribute("trailId", trailId));
    }


     //Testar lyckad uppdatering av en befintlig led.
    @Test
    void updateTrail_WithValidData_ShouldRedirect() throws Exception {
        Long trailId = 1L;

        mockMvc.perform(post("/trails/{id}/edit", trailId)
                        .param("name", "Uppdaterat namn")
                        .param("distanceKm", "12.0")
                        .param("timeMinutes", "130")
                        .param("elevationGain", "350")
                        .param("description", "Uppdaterad beskrivning")
                        .param("location", "Åre"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/trails"));

        verify(trailService, times(1)).updateTrail(eq(trailId), any());
    }

    //Testar radering av en led.

    @Test
    void deleteTrail_ShouldRedirectToTrails() throws Exception {
        Long trailId = 1L;

        mockMvc.perform(post("/trails/" + trailId + "/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/trails"));

        verify(trailService, times(1)).deleteTrail(trailId);
    }
}
