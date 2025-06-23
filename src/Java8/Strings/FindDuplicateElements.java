package Java8.Strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateElements {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice", "David", "Bob");

        //without java 8
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            if(map.containsKey(names.get(i))) {
                map.put(names.get(i), map.get(names.get(i))+1);
            } else {
                map.put(names.get(i), 1);
            }

        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        System.out.println(list);


        //with java 8

        names.stream()
                .collect(Collectors.groupingBy(m->m, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue() >1)
                .map(m->m.getKey())
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
