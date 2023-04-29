package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.enums.SpaceType;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "space")
public class Space {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "permission_group_id")
	    private PermissionGroup permissionGroup;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "parent_id")
	    private Space parent;

	    public Space(Long id) { 
	    	this.id = id;
	    	}

	    public Space(String name, Long permissionGroupId) {
	        this.name = name;
	        this.permissionGroup = new PermissionGroup(permissionGroupId);
	    }

    // getters and setters
    
    
    public Long getId() {
        return id;
     }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
       return name;
    }
    
    

	public void setPermissionGroup(PermissionGroup permissionGroup) {
		
		this.permissionGroup = permissionGroup;
		
	}
	
   public PermissionGroup getPermissionGroup() {
		
		return  permissionGroup;
		
	}
   public Space getParent() {
       return parent;
   }
  



	
	
}