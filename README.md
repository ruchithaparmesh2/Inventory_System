# Advanced Inventory Management System

A robust and scalable **Inventory Management System** designed for warehouses, built using **Java Collections Framework**. This project efficiently manages inventory items and provides advanced features like category-wise sorting, restocking notifications, and complex queries.

---

## Features

1. **Inventory Tracking**:
   - Add, update, delete, and search items by their unique ID.
   - Items have attributes: ID, name, category, and quantity.

2. **Category-Wise Sorting**:
   - Items within a category are automatically sorted in descending order of quantity.
   - Supports efficient retrieval of items belonging to specific categories.

3. **Restocking Notification**:
   - Alerts the user when an item's quantity falls below a defined threshold.

4. **Bulk Operations**:
   - Merge two inventories seamlessly.
   - Prevents duplicate IDs and retains the item with the higher quantity.

5. **Complex Query Support**:
   - Retrieve the top `k` items with the highest quantity across all categories.

6. **Scalability**:
   - Designed to handle at least **100,000 items** efficiently.

---

## Technologies Used

- **Java**: Core logic and implementation.
- **Collections Framework**: HashMap, PriorityQueue, and other classes for efficient data storage and retrieval.

---

## How to Run the Project

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or above).
- IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/advanced-inventory-management-system.git
2.Open the project in your IDE.
  Navigate to the ##InventoryManagementSystemTest class.
  Run the ##test suite to see the system in action.
