package com.example.demo.model;

import com.example.demo.entities.File;
import com.example.demo.entities.Space;

public class FileDto {
	
	     private String name;
	    
	    private byte[] binary;
	    
	    private PermissionGroupDto permissionGroup;
	    
	    
	    public FileDto() {}
	    
	    public FileDto(File file) {
	       
	        this.name = file.getName();
	        this.binary= file.getBinary();
	        this.permissionGroup = new PermissionGroupDto(file.getPermissionGroup());
	    }
	    
		public String getName() {
	        return name;
	    }
	    
	    public PermissionGroupDto getPermissionGroup() {
	        return permissionGroup;
	    }
	    
	    public byte[]  getBinary() {
	        return binary;
	    }
	    
	    
	   
	   

}
