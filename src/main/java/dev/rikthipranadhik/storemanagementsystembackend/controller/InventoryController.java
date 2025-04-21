package dev.rikthipranadhik.storemanagementsystembackend.controller;

import dev.rikthipranadhik.storemanagementsystembackend.dto.inventory.InventoryDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.inventory.ItemDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Inventory;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory.Item;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.inventory.InventoryMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.inventory.ItemMapper;
import dev.rikthipranadhik.storemanagementsystembackend.service.inventory.InventoryService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/{storeId}/inventory")
@AllArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;
    private final ItemMapper itemMapper;

    @GetMapping("/listAllInventories")
    public ResponseEntity<List<InventoryDTO>> listAllInventories(@PathVariable("storeId") Long storeId) {
        return ResponseEntity.ok(inventoryService.listAllInventories(storeId)
                .stream()
                .map(inventoryMapper::toDTO)
                .toList()
        );
    }

    @GetMapping("/{inventoryId}/listAllItems")
    public ResponseEntity<List<ItemDTO>> listAllItems(@PathVariable("inventoryId") Long inventoryId, @PathVariable String storeId) {
        Inventory inventory = inventoryService.getInventoryById(inventoryId);
        if(inventory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(inventoryService.listAllItemsInInventory(inventory)
                .stream()
                .map(itemMapper::toDTO)
                .toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<InventoryDTO> createInventory(@PathVariable("storeId") Long storeId, @RequestBody InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryService.createInventory(inventoryMapper.fromDTO(inventoryDTO), storeId);
        if (inventory == null) {

        }
        return ResponseEntity.ok(inventoryMapper.toDTO(inventory));
    }

    @PostMapping("/{inventoryId}/addItem")
    public ResponseEntity<ItemDTO> addItem(@PathVariable("storeId") Long s, @PathVariable("inventoryId") Long inventoryId, @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok( itemMapper.toDTO(inventoryService.createItem(
                itemMapper.fromDTO(itemDTO), inventoryId
        )));
    }


}
