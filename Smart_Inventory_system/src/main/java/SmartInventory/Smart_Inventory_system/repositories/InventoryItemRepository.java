package SmartInventory.Smart_Inventory_system.repositories;


import SmartInventory.Smart_Inventory_system.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @Repository - Tells Spring: "This is a data access component"
 * (Actually optional when extending JpaRepository, but good practice)
 *
 * JpaRepository<InventoryItem, Long>
 *                    ^            ^
 *                    |            |
 *              Entity Type    ID Type
 *
 * By extending JpaRepository, we automatically get methods like:
 * - save()           - saves or updates an item
 * - findById()       - finds item by ID
 * - findAll()        - gets all items
 * - deleteById()     - deletes by ID
 * - count()          - counts all items
 * ...and many more!
 *
 * WHY is this so powerful?
 * We write ZERO SQL code, Spring Data JPA generates it for us!
 */
@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    /*
     * This interface is intentionally empty!
     *
     * All the basic CRUD operations come from JpaRepository.
     *
     * Later, if we need custom queries (like "find all items below threshold"),
     * we can add them here as method declarations, and Spring will
     * automatically implement them based on the method name!
     *
     * Example (not adding now, just showing the power):
     * List<InventoryItem> findByQuantityLessThan(Integer threshold);
     *
     * Spring sees the method name and generates:
     * SELECT * FROM inventory_item WHERE quantity < ?
     */
}
