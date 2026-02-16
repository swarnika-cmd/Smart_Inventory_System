package SmartInventory.Smart_Inventory_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * @Entity - This tells Spring: "Hey, this class represents a database table"
 * JPA (Java Persistence API) will automatically create a table called "inventory_item"
 */
@Entity
public class InventoryItem {

    /*
     * @Id - Marks this field as the PRIMARY KEY
     * @GeneratedValue - Database will auto-generate this value
     * IDENTITY strategy means: use database's auto-increment feature
     *
     * WHY: Every row needs a unique identifier. We let the database handle it.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @NotBlank - Validation: This field cannot be null, empty, or just whitespace
     * message = custom error message shown when validation fails
     *
     * WHY: Every item MUST have a name. "NotBlank" is stricter than "NotNull"
     * because it also rejects empty strings and spaces.
     */
    @NotBlank(message = "Item name is required")
    private String name;

    /*
     * @NotBlank - Category is mandatory too
     * Examples: "Electronics", "Groceries", "Clothing"
     *
     * WHY: Helps organize inventory into logical groups
     */
    @NotBlank(message = "Category is required")
    private String category;

    /*
     * @NotNull - This field must exist (but 0 is valid)
     * @Min(0) - Must be >= 0 (can't have negative quantity!)
     *
     * WHY: You can't have -5 items in stock. Zero is valid (out of stock).
     */
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    /*
     * @NotNull - Threshold must exist
     * @Min(0) - Must be >= 0
     *
     * Threshold = "Alert me when quantity falls below this number"
     * Example: If threshold = 10, you get warned when you have < 10 items
     *
     * WHY: This is the "early warning system" for restocking
     */
    @NotNull(message = "Threshold is required")
    @Min(value = 0, message = "Threshold cannot be negative")
    private Integer threshold;

    // ========================================
    // CONSTRUCTORS
    // ========================================

    /*
     * No-argument constructor
     * REQUIRED by JPA/Hibernate to create objects using reflection
     *
     * WHY: When Hibernate fetches data from database, it needs to create
     * an empty object first, then fill in the fields.
     */
    public InventoryItem() {
    }

    /*
     * All-arguments constructor (except id)
     * Useful for creating new items in your code
     *
     * Note: We don't include 'id' because database generates it
     */
    public InventoryItem(String name, String category, Integer quantity, Integer threshold) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    // ========================================
    // GETTERS AND SETTERS
    // ========================================

    /*
     * WHY do we need getters/setters?
     * 1. JPA needs them to read/write fields
     * 2. Spring uses them for JSON conversion
     * 3. Encapsulation - we control access to fields
     */

    public Long getId() {
        return id;
    }

    // Note: No setId() - we let the database manage this

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    // ========================================
    // UTILITY METHODS (Optional but useful)
    // ========================================

    /*
     * toString() - Makes debugging easier
     * When you print an InventoryItem, you see readable info instead of
     * "InventoryItem@3a4b2c1f"
     */
    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", threshold=" + threshold +
                '}';
    }
}
