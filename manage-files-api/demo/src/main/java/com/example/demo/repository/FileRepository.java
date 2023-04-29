package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.File;

public interface FileRepository extends JpaRepository<File, Long>{
	
	File save(File file);

    Optional<File> findById(Long id);

    List<File> findByFolderId(Long folderId);

    void delete(File file);
	

}
