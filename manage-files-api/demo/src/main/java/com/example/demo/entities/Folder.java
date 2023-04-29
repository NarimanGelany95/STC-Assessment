package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.SpaceDto;
import com.example.demo.model.enums.ItemType;

import jakarta.persistence.CascadeType;
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
@Table(name = "folder")
public class Folder {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @Enumerated(EnumType.STRING)
	    private ItemType type;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "space_id")
	    private Space space;
	    
	    @OneToOne(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
	    private PermissionGroup permissionGroup;

	    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	    private List<Item> items;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "parent_id")
	    private Folder parent;
	    
	    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<File> files = new ArrayList<>();

    // getters and setters
	    
	public Folder(Long id) {
	        this.id = id;
	    }
    
	public Folder(String name, Long spaceId) {
	        this.name = name;
	        this.space = new Space(spaceId);
	    }


	public void setName(String name) {
        this.name = name;
        
    }
	public String getName() {
		
		return name;
	}
       
    public void setType(ItemType type) {
        this.type = type;
        
    }
    
    public Space getSpace() {
        return space;
     }
    public PermissionGroup getPermissionGroup() {
        return permissionGroup;
    }


	public Long getId() {
		return id;
	}


	public Folder getParent() {
        return parent;
    }
	 public List<Space> getSpaces() {
	        List<Space> spaces = new ArrayList<>();
	        Space space = this.space;
	        while (space != null) {
	            spaces.add(space);
	            space = space.getParent();
	        }
	        return spaces;
	    }
	 public List<File> getFiles() {
	        return this.files;
	    }


	


	
    
    
    
    
    
    
    
}