package com.example.demo.model;

import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.entities.Folder;

public class FolderDto {	
	 
	 private Long id;
	    private String name;
	    private Long parentId;
	    private Set<SpaceDto> spaces;
	    private Set<FileDto> files;

	    public FolderDto(Folder folder) {
	        this.id = folder.getId();
	        this.name = folder.getName();
	        this.parentId = folder.getParent() != null ? folder.getParent().getId() : null;
	        this.spaces = folder.getSpaces().stream()
	                .map(SpaceDto::new)
	                .collect(Collectors.toSet());
	        this.files = folder.getFiles().stream()
	                .map(FileDto::new)
	                .collect(Collectors.toSet());
	    }
    
	
   

}
