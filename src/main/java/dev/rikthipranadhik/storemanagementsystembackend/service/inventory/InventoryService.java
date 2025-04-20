package dev.rikthipranadhik.storemanagementsystembackend.service.inventory;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> listAllInventories(Long storeId);
    Inventory createInventory(Inventory inventory,  Long storeId);
    Inventory updateInventory(Inventory inventory);
    void deleteInventory(Inventory inventory);
    Long calculateCurrentStockLevel(Inventory inventory);
    Inventory getInventoryById(Long inventoryId);

}
