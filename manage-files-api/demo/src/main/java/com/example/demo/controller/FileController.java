package com.example.demo.controller;


import java.nio.file.AccessDeniedException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.FileDto;
import com.example.demo.service.FileService;


@RestController
@RequestMapping("/files")
public class FileController {
	private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
	
    @PostMapping
    public ResponseEntity<FileDto> createFile(@RequestParam Long folderId) {
        FileDto fileDto = null;
		try {
			fileDto = fileService.createFile(folderId, "assessment.pdf");
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.status(HttpStatus.CREATED).body(fileDto);
    }
	}


