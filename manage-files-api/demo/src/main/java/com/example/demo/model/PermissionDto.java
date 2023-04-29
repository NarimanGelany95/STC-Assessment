package com.example.demo.model;

import com.example.demo.entities.Permission;
import com.example.demo.model.enums.PermissionLevel;

public class PermissionDto {
	 private Long id;
	    private String userEmail;
	    private PermissionLevel permissionLevel;

	    public PermissionDto() {}

	    public PermissionDto(Permission permission) {
	        this.id = permission.getId();
	        this.userEmail = permission.getUserEmail();
	        this.permissionLevel = permission.getPermissionLevel();
	    }

		public String getUserEmail() {
			return userEmail;
		}

		public PermissionLevel getPermissionLevel() {
			return permissionLevel;
		}

}
