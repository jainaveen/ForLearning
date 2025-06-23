package CollectionOverview;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImplementation  {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;


    public LRUCacheImplementation(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true); // Access-order LinkedHashMap
    }


    // Get method
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Cache miss
        }
        return cache.get(key); // Cache hit, access order is updated automatically
    }

    // Put method
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // Update value
            return;
        }
        if (cache.size() >= capacity) {
            // Remove the least recently used (LRU) entry
            int lruKey = cache.entrySet().iterator().next().getKey();
            cache.remove(lruKey);
        }
        cache.put(key, value);
    }

    // Display cache content
    public void display() {
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCacheImplementation lru = new LRUCacheImplementation(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        lru.put(4, 40); // Evicts key 1 ("Naveen")

        lru.get(3); // Access key 3 to make it recently used
        lru.put(4, 40);
        lru.display();
    }
}
