package Java8.LearnBasics.Streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        //ForEach
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 6, 7, 8, 8, 3);
        list.stream().forEach(System.out::print);
        System.out.println();
        //To Array
        Integer[] arr = list.stream()
                .toArray(Integer[]::new);
        System.out.print(arr);
        System.out.println();
        //Count
        System.out.print(list.stream().count());
        System.out.println();
        //anymatch
        System.out.print(list.stream().anyMatch(m -> m == 3));
        System.out.println();
        //Allmatch
        System.out.print(list.stream().allMatch(m -> m < 7));
        System.out.println();
        //none match
        System.out.print(list.stream().noneMatch(i -> i % 2 == 0)); //false
        System.out.println();

        //Optional
        Optional<Integer> first = list.stream().findAny();
        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("empty");
        }
        System.out.println();
        //Min
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());
        } else {
            System.out.println("empty");
        }
        System.out.println();
        //Max
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        if (max.isPresent()) {
            System.out.println(max.get());
        } else {
            System.out.println("empty");
        }
        System.out.println();
        //Collect - used to receive elements from a steam and store them in a collection.
        System.out.println(list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
        System.out.println();
        System.out.println(list.stream().filter(i -> i % 2 == 0).collect(Collectors.toSet()));
        System.out.println();
        System.out.println(list.stream().distinct().collect(Collectors.toMap(k -> k, v -> v * 2)));
        System.out.println();

        //Grouping By
        System.out.println(list.stream().collect(Collectors.groupingBy(k -> k)));
        //count the number of elements in each group
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting())));
        //summing groupwise based on provided Function
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.summingInt(k -> k))));
        //averaging groupwise based on provided Function
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.averagingInt(k -> k))));
        //partioning
        System.out.println(list.stream()
                .collect(Collectors.partitioningBy(k -> k % 2 == 0)));
        Map<Boolean,List<Integer>> mmm = list.stream()
                .collect(Collectors.partitioningBy(k -> k % 2 == 0));


    }
}
