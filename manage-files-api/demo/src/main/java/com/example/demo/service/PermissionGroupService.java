package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Permission;
import com.example.demo.entities.PermissionGroup;
import com.example.demo.model.PermissionGroupDto;
import com.example.demo.model.enums.PermissionLevel;
import com.example.demo.repository.PermissionGroupRepository;

import jakarta.persistence.EntityNotFoundException;

public class PermissionGroupService {
	 private final PermissionGroupRepository permissionGroupRepository;

	    public PermissionGroupService(PermissionGroupRepository permissionGroupRepository) {
	        this.permissionGroupRepository = permissionGroupRepository;
	    }

	    public PermissionGroupDto createPermissionGroup(String groupName) {
	        PermissionGroup permissionGroup = new PermissionGroup();
	        permissionGroup.setGroupName(groupName);
	        permissionGroupRepository.save(permissionGroup);
	        return new PermissionGroupDto(permissionGroup);
	    }

	    public void addUserToGroup(Long groupId, String userEmail, PermissionLevel permissionLevel) {
	        PermissionGroup permissionGroup = permissionGroupRepository.findById(groupId)
	                .orElseThrow(() -> new EntityNotFoundException("Permission group not found"));

	        // Check if user already has permission and update if necessary
	        Optional<Permission> optionalPermission = permissionGroup.getPermissions().stream()
	                .filter(permission -> permission.getUserEmail().equals(userEmail))
	                .findFirst();
	        if (optionalPermission.isPresent()) {
	            Permission permission = optionalPermission.get();
	            permission.setPermissionLevel(permissionLevel);
	        } else {
	            Permission permission = new Permission(userEmail, permissionLevel);
	            permissionGroup.addPermission(permission);
	        }

	        permissionGroupRepository.save(permissionGroup);
	    }

	    public boolean hasUserPermission(Long groupId, String userEmail, PermissionLevel permissionLevel) {
	        PermissionGroup permissionGroup = permissionGroupRepository.findById(groupId)
	                .orElseThrow(() -> new EntityNotFoundException("Permission group not found"));
	        return permissionGroup.hasUserPermission(userEmail, permissionLevel);
	    }

}
