package Java8.Basic.Arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Democlass {

    public static void main(String[] args) {
        /*
        1. Sort a list of strings by length using a lambda expression.

2. Filter and collect all even numbers from a list using Stream.

3. Count the number of strings in a list that start with a specific letter.

4. Convert a list of strings to uppercase using map().

5. Remove duplicates from a list using streams.

6. Find the first non-repeated character in a string using Stream.

7. Sort a list of employees by salary and then by name (custom comparator with lambda).

8. Group a list of employees by department using Collectors.groupingBy().

9. Find the second-highest number in a list using streams.

10. Calculate the average salary of employees using mapToDouble() and average().
         */
        List<String> list = new ArrayList<>();
        list.add("Naveen");
        list.add("Adhavan");
        list.add("Adithiyan");
        list.add("Adithiyan");

        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list2.add(i);
        }
        System.out.println(list2.stream().filter(i->i%2 == 0).collect(Collectors.toList()));

        System.out.println(list.stream().filter(m->m.startsWith("A")).count());

        System.out.println(list.stream().map(m->m.toUpperCase()).collect(Collectors.toList()));

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        String son = "adhavan";
        Map<Character, Long> list3 = son.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c->c, HashMap::new, Collectors.counting()));
        Character res = list3.entrySet()
                        .stream()
                                .filter(m->m.getValue() == 1)
                                        .map(m->m.getKey()).findFirst().orElse(null);
        System.out.println(res);
    }
}
