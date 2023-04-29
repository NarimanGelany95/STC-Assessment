package com.example.demo.service;


import org.springframework.stereotype.Service;


import com.example.demo.entities.Space;
import com.example.demo.model.PermissionGroupDto;
import com.example.demo.model.SpaceDto;
import com.example.demo.model.enums.PermissionLevel;

import com.example.demo.repository.SpaceRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SpaceService {
    private final SpaceRepository spaceRepository;
    private final PermissionGroupService permissionGroupService;

    public SpaceService(SpaceRepository spaceRepository, PermissionGroupService permissionGroupService) {
        this.spaceRepository = spaceRepository;
        this.permissionGroupService = permissionGroupService;
    }

    public SpaceDto createSpace(String name) {
        PermissionGroupDto permissionGroupDto = permissionGroupService.createPermissionGroup("admin");

        // Add users with VIEW and EDIT access
        permissionGroupService.addUserToGroup(permissionGroupDto.getId(), "user1@example.com", PermissionLevel.VIEW);
        permissionGroupService.addUserToGroup(permissionGroupDto.getId(), "user2@example.com", PermissionLevel.EDIT);

        // Create space with assigned permission group
        Space space = new Space(name, permissionGroupDto.getId());
        spaceRepository.save(space);

        return new SpaceDto(space);
    }
    
    public SpaceDto getSpaceById(Long spaceId) {
        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new EntityNotFoundException("Space not found"));
        return new SpaceDto(space);
    }
} 


		
        
	
	
	
   
   
      
	    
	    
	    

	
