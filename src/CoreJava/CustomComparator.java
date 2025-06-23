package CoreJava;

import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add(null);
        list.add("banana");

        /*
        // Sorting the list with a custom comparator
        Collections.sort(list, (o1, o2) -> {
            if (o1 == null) return -1; // Place nulls first
            if (o2 == null) return 1;  // Place nulls last
            return o1.compareTo(o2);   // Natural ordering for non-null elements
        });

         */
        // Using Comparator.nullsLast()
        Collections.sort(list, Comparator.nullsLast(Comparator.naturalOrder()));

        System.out.println(list); // Output: [null, apple, banana]


        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        //map.put("B",2);

        map.putIfAbsent("B",3);

        System.out.println(map);
    }
}
