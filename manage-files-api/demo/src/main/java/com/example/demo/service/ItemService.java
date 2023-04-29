package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Item;
import com.example.demo.model.enums.ItemType;
import com.example.demo.repository.ItemRepository;

public class ItemService {
	@Autowired
    private ItemRepository itemRepository;
    
    public List<Item> findByParentId(Long parentId) {
        return itemRepository.findByParentId(parentId);
    }
    
    public List<Item> findByType(ItemType type) {
        return itemRepository.findByType(type);
    }

}
