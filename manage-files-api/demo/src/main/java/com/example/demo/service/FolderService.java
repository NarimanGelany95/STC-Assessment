package com.example.demo.service;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

import com.example.demo.exceptions.FolderNotFoundException;
import com.example.demo.entities.Folder;
import com.example.demo.model.FolderDto;
import com.example.demo.model.SpaceDto;
import com.example.demo.model.enums.PermissionLevel;
import com.example.demo.repository.FolderRepository;




@Service
public class FolderService {

	 private final FolderRepository folderRepository;
	    private final SpaceService spaceService;

	    public FolderService(FolderRepository folderRepository, SpaceService spaceService) {
	        this.folderRepository = folderRepository;
	        this.spaceService = spaceService;
	    }

    public FolderDto createFolder(Long spaceId, String name) throws AccessDeniedException {
        SpaceDto space = spaceService.getSpaceById(spaceId);

        // Check if user has EDIT access on the space
        if (!space.getPermissionGroup().hasUserPermission(getCurrentUserEmail(), PermissionLevel.EDIT)) {
            throw new AccessDeniedException("User does not have EDIT access on the space");
        }

        Folder folder = new Folder(name, spaceId);
        folderRepository.save(folder);

        return new FolderDto(folder);
    }
    
    public Folder getFolderById(Long folderId) {
        Optional<Folder> optionalFolder = folderRepository.findById(folderId);
        if (optionalFolder.isPresent()) {
            return optionalFolder.get();
        } else {
            throw new FolderNotFoundException("Folder not found with id: " + folderId);
        }
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
