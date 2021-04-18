package com.eds.cakefactory.service;

import com.eds.cakefactory.model.Items;
import com.eds.cakefactory.repository.ItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements IItemService {

    private ItemJpaRepository itemJpaRepository;

    @Autowired
    public ItemServiceImpl(ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public List<Items> getItems() {
        return itemJpaRepository.findAll();
    }
}
