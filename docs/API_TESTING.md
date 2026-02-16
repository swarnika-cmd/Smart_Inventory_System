# 🧪 API Testing Guide - Smart Retail Inventory Management System (SRIMS)

This document serves as the **single source of truth** for testing all API endpoints in the system. As we add new features and endpoints, this file will be updated to include their testing instructions.

---

## 📍 Base URL
All endpoints are relative to the following base URL:
`http://localhost:8080`

---

## 📦 Phase 1: Core Inventory Backend (Chunk 1.1)

**Goal:** Verify basic CRUD operations, input validation, and persistence for Inventory Items.
**Source Code Location:** `src/main/java/SmartInventory/Smart_Inventory_system/controllers/InventoryController.java`

### 1. Create a New Inventory Item
**Endpoint:** `POST /inventory`
**Description:** Adds a new item to the inventory.
**Expected Result:** `201 Created` with the created item (including generated ID).

**Request Body (JSON):**
```json
{
  "name": "Milk (1L)",
  "category": "Dairy",
  "quantity": 50,
  "threshold": 10
}
```

**Testing Validation (Negative Cases):**
*   **Case 1: Empty Name** -> Send `"name": ""` -> Expect `400 Bad Request`
*   **Case 2: Negative Quantity** -> Send `"quantity": -5` -> Expect `400 Bad Request`
*   **Case 3: Missing Category** -> Remove `"category"` field -> Expect `400 Bad Request`

---

### 2. View All Inventory Items
**Endpoint:** `GET /inventory`
**Description:** Retrieves a list of all items currently in the database.
**Expected Result:** `200 OK` with a JSON array of items.

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "Milk (1L)",
    "category": "Dairy",
    "quantity": 50,
    "threshold": 10
  }
]
```

---

### 3. View a Single Item
**Endpoint:** `GET /inventory/{id}`
**Description:** Retrieves details of a specific item by its unique ID.
**Expected Result:** `200 OK` if found, `404 Not Found` if the ID does not exist.

**Example Request:** `GET /inventory/1`

---

### 4. Update an Item (Quantity/Threshold)
**Endpoint:** `PUT /inventory/{id}`
**Description:** Updates the details of an existing item. Useful for restocking or changing thresholds.
**Expected Result:** `200 OK` with the updated item.

**Request Body (JSON):**
```json
{
  "name": "Milk (1L)",
  "category": "Dairy",
  "quantity": 100,  // Updated quantity
  "threshold": 15   // Updated threshold
}
```

**Testing Validation:**
*   **Case 1: Update Non-Existent ID** -> Try updating ID `999` -> Expect `404 Not Found`
*   **Case 2: Invalid Update** -> Try setting quantity to `-10` -> Expect `400 Bad Request`

---

### 5. Delete an Item (Optional)
**Endpoint:** `DELETE /inventory/{id}`
**Description:** Removes an item from the inventory.
**Expected Result:** `204 No Content` on success, `404 Not Found` if ID doesn't exist.

**Example Request:** `DELETE /inventory/1`

---

## 🛠️ How to Test
You can use any of the following tools:
1.  **Postman:** Import the examples above as a collection.
2.  **cURL:** Run commands like `curl -X GET http://localhost:8080/inventory` in your terminal.
3.  **Browser:** For `GET` requests, simply visit the URL (e.g., `http://localhost:8080/inventory`) in your browser.

---

*This document will grow as we add services, authentication, and ML integration.*
