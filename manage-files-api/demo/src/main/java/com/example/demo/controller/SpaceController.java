package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.SpaceDto;

import com.example.demo.service.SpaceService;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

	private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping
    public ResponseEntity<SpaceDto> createSpace() {
        SpaceDto spaceDto = spaceService.createSpace("stc-assessments");
        return ResponseEntity.status(HttpStatus.CREATED).body(spaceDto);
    }
    
   
    
}
