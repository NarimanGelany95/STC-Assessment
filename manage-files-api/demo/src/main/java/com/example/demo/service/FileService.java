package com.example.demo.service;

import java.nio.file.AccessDeniedException;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.entities.File;
import com.example.demo.entities.Folder;

import com.example.demo.model.FileDto;
import com.example.demo.model.enums.PermissionLevel;
import com.example.demo.repository.FileRepository;



public class FileService {
	 private final FileRepository fileRepository;
	    private final FolderService folderService;

	    public FileService(FileRepository fileRepository, FolderService folderService) {
	        this.fileRepository = fileRepository;
	        this.folderService = folderService;
	    }

	    public FileDto createFile(Long folderId, String name) throws AccessDeniedException {
	        Folder folder = folderService.getFolderById(folderId);

	        // Check if user has EDIT access on the folder
	        if (!folder.getPermissionGroup().hasUserPermission(getCurrentUserEmail(), PermissionLevel.EDIT)) {
	            throw new AccessDeniedException("User does not have EDIT access on the folder");
	        }

	        File file = new File(name, folderId);
	        fileRepository.save(file);

	        return new FileDto(file);
	    }

	    private String getCurrentUserEmail() {
	       //  logic to get current user email
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            return authentication.getName();
	        }
	        return null;
	    }
	

}
