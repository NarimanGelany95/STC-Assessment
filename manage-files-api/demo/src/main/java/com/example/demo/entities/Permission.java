package com.example.demo.entities;

import com.example.demo.model.enums.PermissionLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission_level")
    private PermissionLevel permissionLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private PermissionGroup permissionGroup;
    
    // getters and setters
    
    public Permission(String userEmail, PermissionLevel permissionLevel) {
    	this.userEmail = userEmail;
    	this.permissionLevel = permissionLevel;
		
	}

	public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
    
    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }
    
    public String getUserEmail() {
       return userEmail;
    }
    
    public Long getId() {
        return id;
     }
    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
     }
    
    
    
    
    
    

}