package Java8.LearnBasics.ForEach;

import java.util.*;
import java.util.stream.Stream;

public class TestClass {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * 2)
                .forEach(System.out::println);

        // Iterate Through List Using 'forEach' Method
        iterateListUsingForEach();

        System.out.println();

        // Iterate Through Set Using 'forEach' Method
        iterateSetUsingForEach();

        System.out.println();

        // Iterate Through Map Using 'forEach' Method
        iterateMapUsingForEach();
    }

    private static void iterateListUsingForEach() {

        /*** List Instantiation :: Type #1 ***/
        List<String> cList = new ArrayList<>();
        cList.add("India");
        cList.add("USA");
        cList.add("Japan");
        cList.add("Canada");
        cList.add("Singapore");

        //List<String> cList2 = List.of("India","USA");
        //List<String> cList2 =Arrays.asList("India","USA");

        //lambda expression
        //cList.stream().forEach(s -> System.out.println(s));
        cList.stream()
                .map(m->m.equals("India"))
                .forEach(System.out::println);

        // Using method reference
        //cList.stream().forEach(System.out::println);
    }

    private static void iterateSetUsingForEach() {

        Set<String> persons = new HashSet<String>();
        persons.add("Java Geek");
        persons.add("Sam");
        persons.add("David");
        persons.add("April O' Neil");
        persons.add("Albus");

        //method reference
        persons.forEach(System.out::println);
    }

    private static void iterateMapUsingForEach() {

        Map<String, String> days = new HashMap<String, String>();
        days.put("1", "SUNDAY");
        days.put("2", "MONDAY");
        days.put("3", "TUESDAY");
        days.put("4", "WEDNESDAY");
        days.put("5", "THURSDAY");
        days.put("6", "FRIDAY");
        days.put("7", "SATURDAY");

        //Lambda expression
        days.forEach((key, value) -> System.out.println(key + "" + value));
        //Note that a Map (HashMap, TreeMap, etc.) is not a collection inheriting from Collection.
        // Stream is not supported for Map.
        Map<Integer, String> map = new HashMap();
        Stream<Map.Entry<Integer, String>> stream = map.entrySet().stream();
    }
}
