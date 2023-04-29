package com.example.demo.model;

import java.util.List;

import com.example.demo.entities.Space;

public class SpaceDto {
	private Long id;
    private String name;
    private PermissionGroupDto permissionGroup;

    public SpaceDto() {}

    public SpaceDto(Space space) {
        this.id = space.getId();
        this.name = space.getName();
        this.permissionGroup = new PermissionGroupDto(space.getPermissionGroup());
    }
    public PermissionGroupDto getPermissionGroup() {
		return permissionGroup;
	}
	



}
