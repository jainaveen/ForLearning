package BinarySearch.Medium;
import java.util.*;
public class InsertDeleteGetRandom {

    private Map<Integer, Integer> valToIndex; // Stores value → index mapping
    private List<Integer> values; // Stores actual values
    private Random rand; // Random object for getRandom()

    public InsertDeleteGetRandom() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false; // Already present
        }
        // Insert at the end of the list
        valToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false; // Not present
        }
        int index = valToIndex.get(val);
        int lastElement = values.get(values.size() - 1);

        // Swap last element with the element to remove
        values.set(index, lastElement);
        valToIndex.put(lastElement, index);

        // Remove last element from list & map
        values.remove(values.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom idg = new InsertDeleteGetRandom();
        System.out.println("Insert " + idg.insert(1));
        System.out.println("Remove " + idg.remove(2));
        System.out.println("Insert " + idg.insert(2));
        System.out.println("Insert " + idg.insert(3));
        System.out.println("Insert " + idg.insert(4));
        System.out.println("Insert " + idg.insert(5));
        System.out.println("Get Random " + idg.getRandom());
        System.out.println("Remove " + idg.remove(3));

        System.out.println("Get Random " + idg.getRandom());
    }

}
