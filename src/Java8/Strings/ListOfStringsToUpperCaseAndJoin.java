package Java8.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOfStringsToUpperCaseAndJoin {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "cherry");
        System.out.println(list.stream().map(m -> m.toUpperCase())
                        .collect(Collectors.joining(",")));


        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
        System.out.println(numbers.stream()
                .filter(m->m % 2 !=0)
                .mapToInt(Integer::intValue)
                .sum());

        List<String> words = Arrays.asList("apple", "bat", "car", "apricot", "banana", "cat");

        System.out.println(words.stream().collect(Collectors.groupingBy(m->m.length(),Collectors.toList())));

        List<Integer> number = Arrays.asList(10, 20, 30, 40, 50, 60);

        System.out.println(number.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get());

        List<String> word = Arrays.asList("Java", "Streams", "are", "cool");

        System.out.println(word.stream().collect(Collectors.joining(",")));

        List<Integer> nums = Arrays.asList(45, 82, 99, 120, 60);
        System.out.println(nums.stream()
                .anyMatch(m->m > 100));

        List<Integer> nums2 = Arrays.asList(10, 15, 20, 25, 30, 35);
        System.out.println(nums2.stream().filter(n->n%2 ==0)
                .mapToInt(Integer::intValue)
                .average().getAsDouble());

        List<Integer> nums3 = Arrays.asList(2, 3, 3, 4, 5, 5, 6);
        System.out.println(nums3.stream()
                .distinct()
                .map(m->m * m)
                .collect(Collectors.toList()));

        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println(words2.stream()
                .max(Comparator.comparing(m->m.length()))
                .get());

        List<Integer> nums4 = Arrays.asList(10, 15, 20, 25, 30, 35);

        System.out.println(nums4.stream()
                .collect(Collectors.partitioningBy(m->m%2 ==0,Collectors.toList())));


        List<String> words3 = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(words3.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList()));

        List<String> words4 = Arrays.asList("apple", "banana", "cherry", "banana", "date", "apple");

        System.out.println(words4.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList()));

        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(IntStream.range(0,numbers5.size()-1)
                .allMatch(m->numbers5.get(m) <= numbers5.get(m+1)));

        List<String> words5 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println(words5.stream()
                .collect(Collectors.groupingBy(m->m.toLowerCase(), Collectors.counting())));

        String input = "swiss";

        System.out.println(Stream.of(input.split(""))
                .collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                .entrySet()
                .stream().filter(m->m.getValue() == 1)
                .findFirst()
                .get().getKey());

    }
}
