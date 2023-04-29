package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Space;

@Repository
public interface SpaceRepository  extends JpaRepository<Space, Long>{
	Space save(Space space);
	Optional<Space> findById(Long id);
}
