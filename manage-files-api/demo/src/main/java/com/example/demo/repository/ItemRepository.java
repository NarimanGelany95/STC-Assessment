package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Item;
import com.example.demo.model.enums.ItemType;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByParentId(Long parentId);
    
    List<Item> findByType(ItemType type); 

}
