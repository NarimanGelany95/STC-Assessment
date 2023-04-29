package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.PermissionGroup;
import com.example.demo.model.enums.PermissionLevel;
public class PermissionGroupDto {
	private Long id;
    private String groupName;
    private List<PermissionDto> permissions;

    public PermissionGroupDto() {}

    public  PermissionGroupDto(PermissionGroup permissionGroup) {
        this.id = permissionGroup.getId();
        this.groupName = permissionGroup.getGroupName();
        this.permissions = permissionGroup.getPermissions().stream()
                .map(PermissionDto::new)
                .collect(Collectors.toList());
    }

	public Long getId() {
		return id;
	}

	 public boolean hasUserPermission(String userEmail, PermissionLevel permissionLevel) {
	        return permissions.stream()
	                .filter(permission -> permission.getUserEmail().equals(userEmail))
	                .anyMatch(permission -> permission.getPermissionLevel() == permissionLevel);
	    }

    


}
