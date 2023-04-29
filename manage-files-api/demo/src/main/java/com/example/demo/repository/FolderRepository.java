package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Folder;
import com.example.demo.entities.Space;

public interface FolderRepository  extends JpaRepository<Folder, Long>{
	Folder save(Folder folder);

}
