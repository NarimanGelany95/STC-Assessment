package com.example.demo.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.FolderDto;
import com.example.demo.service.FolderService;

@RestController
@RequestMapping("/folders")
public class FolderController {
	
	@Autowired
    private FolderService folderService;
   
  
    
    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

	@PostMapping
	public ResponseEntity<FolderDto> createFolder(@RequestParam Long spaceId) {
        FolderDto folderDto = null;
		try {
			folderDto = folderService.createFolder(spaceId, "backend");
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.status(HttpStatus.CREATED).body(folderDto);
    }

}
