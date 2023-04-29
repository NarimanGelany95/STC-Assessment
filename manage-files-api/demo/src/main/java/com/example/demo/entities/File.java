package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class File{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;

    @Lob
    @Column(name = "binary")
    private byte[] binary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_group_id")
    private PermissionGroup permissionGroup;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;
    
 // constructors, getters, and setters
    
    
    public void setBinary( byte[] binary){
        this.binary = binary;
     }

	public String getName() {
		return this.name;
	}
	public byte[] getBinary() {
		return this.binary;
	}

	public PermissionGroup getPermissionGroup() {
		return permissionGroup;
	}
	
	public File(String name, Long folderId) {
        this.name = name;
        this.folder = new Folder(folderId);
    }
    
    
    

}
