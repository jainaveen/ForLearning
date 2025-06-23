package Java8.SampleCodingPractice;

import java.util.*;
import java.util.stream.Collectors;

public class FindAndRemoveDuplicates {

    public static void main(String[] args) {
        List<String> list =Arrays.asList("Java","Python","C#","Java","Python","Kotlin");
        list.stream().distinct().forEach(System.out::println);

        int[] arr = {1,2,3,1,2};
        // Approach 1
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(m->m.intValue(), Collectors.counting()));

        frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(m->m.getKey())
                .forEach(System.out::println);
        System.out.println("*****");
        //Approach 2
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr)
                .boxed()
                .filter(i->!set.add(i))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        String[] names = {"java", "ang", "java8", "kuber", "docker"};

        Arrays.stream(names)
                .filter(m->m.startsWith("j"))
                .map(m-> "i will learn " + m)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
