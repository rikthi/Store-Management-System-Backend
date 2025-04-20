package dev.rikthipranadhik.storemanagementsystembackend.mapper.inventory.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.inventory.ItemDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Item;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.inventory.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper {
    @Override
    public Item fromDTO(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ItemDTO toDTO(Item item) {
        return null;
    }
}
