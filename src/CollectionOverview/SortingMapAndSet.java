package CollectionOverview;

import java.util.*;

public class SortingMapAndSet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("adithiyan", 1);
        map.put("adhavan",2);

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, Map.Entry.comparingByKey());

        list.stream().forEach(System.out::println);

        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(2);

        List<Integer> list2 = new ArrayList<>(set);
        Collections.sort(list2);

        list2.stream().forEach(System.out::println);

    }



}
