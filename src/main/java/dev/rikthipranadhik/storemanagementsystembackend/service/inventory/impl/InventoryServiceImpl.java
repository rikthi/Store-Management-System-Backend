package dev.rikthipranadhik.storemanagementsystembackend.service.inventory.impl;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Inventory;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Item;
import dev.rikthipranadhik.storemanagementsystembackend.entity.store.Store;
import dev.rikthipranadhik.storemanagementsystembackend.repository.inventory.InventoryRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.inventory.ItemRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.store.StoreRepository;
import dev.rikthipranadhik.storemanagementsystembackend.service.inventory.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    private ItemRepository itemRepository;
    private StoreRepository storeRepository;


    @Override
    public List<Inventory> listAllInventories(Long storeId) {
        return inventoryRepository.findByStoreId(storeId);
    }

    @Override
    public Inventory createInventory(Inventory inventory, Long storeId) {
        if (inventory.getId() != null){
            throw new IllegalArgumentException("Inventory ID must be null");
        }

        if  (inventory.getStore().getId() == null){
            throw new IllegalArgumentException("Store ID must not be null");
        }

        Store store = storeRepository.findById(storeId).orElse(null);
        if (store == null){
            throw new IllegalArgumentException("Store doesn't exist");
        }

        inventory.setStore(store);

        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        Inventory oldInventory = inventoryRepository.findById(inventory.getId()).orElse(null);

        if (oldInventory == null){
            throw new IllegalArgumentException("Inventory doesn't exist");
        }
        oldInventory.setCategory(inventory.getCategory());
        oldInventory.setMinimumStockLevel(inventory.getMinimumStockLevel());
        oldInventory.setMaximumStockLevel(inventory.getMaximumStockLevel());

        return inventoryRepository.save(oldInventory);
    }

    @Override
    public void deleteInventory(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }

    @Override
    public Long calculateCurrentStockLevel(Inventory inventory) {
        List<Item> items = itemRepository.findByInventoryId(inventory.getId());

        if (items == null){
            return 0L;
        }
        Long sum = 0L;
        for (Item item : items){
            sum += item.getQuantity();
        }

        inventory.setCurrentStockLevel(sum);
        return sum;
    }

    @Override
    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElse(null);
    }

    @Override
    public List<Item> listAllItemsInInventory(Inventory inventory) {
        return itemRepository.findByInventoryId(inventory.getId());
    }

    @Override
    public Item addItemToInventory(Inventory inventory, Item item) {
        Item oldItem = itemRepository.findById(item.getId()).orElse(null);
        if (oldItem == null){
            throw new IllegalArgumentException("Item doesn't exist");
        }
        oldItem.setInventory(inventory);
        return itemRepository.save(oldItem);
    }

    @Override
    public Item createItem(Item item, Long inventoryId) {
        if (item.getId() != null){
            throw new IllegalArgumentException("Item ID must be null");
        }

        Inventory inventory = inventoryRepository.findById(inventoryId).orElse(null);
        if (inventory == null){
            throw new IllegalArgumentException("Inventory doesn't exist");
        }

        item.setInventory(inventory);
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        Item oldItem = itemRepository.findById(item.getId()).orElse(null);
        if (oldItem == null){
            throw new IllegalArgumentException("Item doesn't exist");
        }
        oldItem.setName(item.getName());
        oldItem.setPrice(item.getPrice());
        oldItem.setQuantity(item.getQuantity());
        oldItem.setDiscountPercentage(item.getDiscountPercentage());
        oldItem.setInventory(item.getInventory());
        return itemRepository.save(oldItem);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
}
