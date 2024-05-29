package com.example.bookmyshow2.controller;

import com.example.bookmyshow2.dto.TheatreRequestDTO;
import com.example.bookmyshow2.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;


    @PostMapping("/theatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO requestDTO){
        return ResponseEntity.ok(theatreService.saveTheatre(requestDTO.getTheatreName(), requestDTO.getAddress(), requestDTO.getCityId()));
    }
}
