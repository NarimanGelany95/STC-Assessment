package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PermissionGroup;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {

	 PermissionGroup save(PermissionGroup permissionGroup);

}
