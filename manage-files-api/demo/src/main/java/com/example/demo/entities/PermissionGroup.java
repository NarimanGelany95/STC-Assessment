package com.example.demo.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.enums.PermissionLevel;

@Entity
@Table(name = "permission_groups")
public class PermissionGroup {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "permissionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "permissionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Permission> permissions = new ArrayList<>();


    // getters and setters
    
    public PermissionGroup() {}
    
    public PermissionGroup(Long id) {
        this.id = id;
    }
    
    public void addPermission(Permission permission) {
        permissions.add(permission);
        permission.setPermissionGroup(this);
    }

    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public void setPermissions(List<Permission>  permissions) {
        this.permissions = permissions;
    }
   

    public List<Permission> getPermissions() {
        return permissions;
    }
    
    public Long getId(){
        return this.id;
     }
    
    public String getGroupName(){
        return this.groupName;
     }

    public boolean hasUserPermission(String userEmail, PermissionLevel permissionLevel) {
        return permissions.stream()
                .filter(permission -> permission.getUserEmail().equals(userEmail))
                .anyMatch(permission -> permission.getPermissionLevel() == permissionLevel);
    }

     

  

}
