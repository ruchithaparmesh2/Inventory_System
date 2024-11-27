public class InventoryManagementSystemTest {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem(10);

        // Adding items
        inventory.addItem("1", "Laptop", "Electronics", 5);
        inventory.addItem("2", "Chair", "Furniture", 20);
        inventory.addItem("3", "Apple", "Groceries", 50);

        // Updating item quantity
        inventory.updateItemQuantity("1", 15);

        // Deleting an item
        inventory.deleteItem("2");

        // Retrieving items by category
        System.out.println("Items in Groceries: " + inventory.getItemsByCategory("Groceries"));

        // Merging inventories
        InventoryManagementSystem otherInventory = new InventoryManagementSystem(10);
        otherInventory.addItem("3", "Apple", "Groceries", 60);
        otherInventory.addItem("4", "Table", "Furniture", 10);
        inventory.mergeInventory(otherInventory);

        // Retrieving top K items
        System.out.println("Top 2 items: " + inventory.getTopKItems(2));
    }
}
