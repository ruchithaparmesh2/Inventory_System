import java.util.*;
import java.util.stream.Collectors;

class InventoryItem {
    private final String id;
    private final String name;
    private final String category;
    private int quantity;

    public InventoryItem(String id, String name, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Category: %s, Quantity: %d", id, name, category, quantity);
    }
}

class InventoryManagementSystem {
    private final Map<String, InventoryItem> inventoryMap = new HashMap<>();
    private final Map<String, PriorityQueue<InventoryItem>> categoryMap = new HashMap<>();
    private final int restockingThreshold;

    public InventoryManagementSystem(int restockingThreshold) {
        this.restockingThreshold = restockingThreshold;
    }

    public void addItem(String id, String name, String category, int quantity) {
        if (inventoryMap.containsKey(id)) {
            System.out.println("Item with ID " + id + " already exists.");
            return;
        }
        InventoryItem item = new InventoryItem(id, name, category, quantity);
        inventoryMap.put(id, item);
        categoryMap.computeIfAbsent(category, k -> new PriorityQueue<>((a, b) -> b.getQuantity() - a.getQuantity())).add(item);
        if (quantity < restockingThreshold) {
            System.out.println("Restocking Notification: Item " + name + " (ID: " + id + ") needs restocking.");
        }
    }

    public void updateItemQuantity(String id, int newQuantity) {
        InventoryItem item = inventoryMap.get(id);
        if (item == null) {
            System.out.println("Item with ID " + id + " not found.");
            return;
        }
        String category = item.getCategory();
        categoryMap.get(category).remove(item);
        item.setQuantity(newQuantity);
        categoryMap.get(category).add(item);
        if (newQuantity < restockingThreshold) {
            System.out.println("Restocking Notification: Item " + item.getName() + " (ID: " + id + ") needs restocking.");
        }
    }

    public void deleteItem(String id) {
        InventoryItem item = inventoryMap.remove(id);
        if (item != null) {
            categoryMap.get(item.getCategory()).remove(item);
        }
    }

    public List<InventoryItem> getItemsByCategory(String category) {
        return categoryMap.getOrDefault(category, new PriorityQueue<>())
                .stream()
                .sorted((a, b) -> b.getQuantity() - a.getQuantity())
                .collect(Collectors.toList());
    }

    public void mergeInventory(InventoryManagementSystem other) {
        other.inventoryMap.values().forEach(item -> {
            if (inventoryMap.containsKey(item.getId())) {
                InventoryItem existing = inventoryMap.get(item.getId());
                if (item.getQuantity() > existing.getQuantity()) {
                    updateItemQuantity(existing.getId(), item.getQuantity());
                }
            } else {
                addItem(item.getId(), item.getName(), item.getCategory(), item.getQuantity());
            }
        });
    }

    public List<InventoryItem> getTopKItems(int k) {
        return inventoryMap.values()
                .stream()
                .sorted((a, b) -> b.getQuantity() - a.getQuantity())
                .limit(k)
                .collect(Collectors.toList());
    }
}
