package Java8.LearnBasics.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.stream()
                .map(x->x.toLowerCase())
                .collect(Collectors.toList())
                .forEach(m->System.out.print(m + ","));
        System.out.println();

        //How to fin
        int[] arr = {1,2,3,1,2};

        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(m->m.intValue(), Collectors.counting()));
        map.entrySet().stream()
                .filter(m->m.getValue() > 1)
                .map(m->m.getKey())
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
