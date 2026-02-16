package SmartInventory.Smart_Inventory_system.controllers;

import SmartInventory.Smart_Inventory_system.entities.InventoryItem;
import SmartInventory.Smart_Inventory_system.repositories.InventoryItemRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * REST Controller for Inventory Management
 * 
 * Objectives for Chunk 1.1:
 * - Create new items
 * - View all items
 * - View a single item
 * - Update an item (specifically quantity)
 * 
 * "No services yet" - We are talking directly to the Repository for simplicity.
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryItemRepository repository;

    // Constructor Injection (Best Practice)
    public InventoryController(InventoryItemRepository repository) {
        this.repository = repository;
    }

    // 1. View all items
    // GET /inventory
    @GetMapping
    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    // 2. View a single item
    // GET /inventory/{id}
    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getItemById(@PathVariable Long id) {
        Optional<InventoryItem> item = repository.findById(id);

        // If present, return 200 OK with the item
        // If missing, return 404 Not Found
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Add a new item
    // POST /inventory
    // @Valid triggers the validation rules in InventoryItem entity
    @PostMapping
    public ResponseEntity<InventoryItem> createItem(@Valid @RequestBody InventoryItem item) {
        InventoryItem savedItem = repository.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // 4. Update an item (Quantity, Threshold, etc.)
    // PUT /inventory/{id}
    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> updateItem(@PathVariable Long id,
            @Valid @RequestBody InventoryItem itemDetails) {
        return repository.findById(id)
                .map(existingItem -> {
                    // Update fields
                    existingItem.setName(itemDetails.getName());
                    existingItem.setCategory(itemDetails.getCategory());
                    existingItem.setQuantity(itemDetails.getQuantity());
                    existingItem.setThreshold(itemDetails.getThreshold());

                    // Save updated item
                    InventoryItem updatedItem = repository.save(existingItem);
                    return ResponseEntity.ok(updatedItem);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Optional: DELETE /inventory/{id} for cleanup
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
