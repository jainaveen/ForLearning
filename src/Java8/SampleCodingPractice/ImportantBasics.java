package Java8.SampleCodingPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ImportantBasics {
    public static void main(String[] args) {

        //Find Min & Max
        finMinMax();
        merge();
        anagram();
        sumOf();
        secondLargestNumber();
        sortBasedOnLength();
        commonElementsBetweenArray();
        reverseEachWord();
        reverseIntegerArray();
        mostRepeatedElement();
        palindrome();
        stringStartingWithNumber();
        extractDuplicates();
        duplicateCharacters();
        lastElement();
    }

    static void finMinMax() {
        List<Integer> integerList = Arrays.asList(23, 45, 5, 6, 78, 122, 4, 78);
        Integer minValue = integerList.stream().
                min(Comparator.naturalOrder()).get();
        Integer maxValue = integerList.stream().
                max(Comparator.naturalOrder()).get();
        System.out.println("min:- " + minValue + " max:- " + maxValue);

        //Find Max 3 numbers
        System.out.println("---First 3 min --");
        integerList.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("--First 3 max---");
        integerList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        System.out.println("--");
        //Sum and Average
        int[] arr = {1, 23, 34, 7, 89};
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).average().getAsDouble());
    }

    static void merge() {

        //Merge two unsorted array into single array
        int[] a = {2, 43, 14, 87, 5};
        int[] b = {5, 67, 87, 65};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .toArray();
        System.out.println(Arrays.toString(c));

        //without duplicates
        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .distinct().toArray();
        System.out.println(Arrays.toString(d));
    }

    static void anagram() {
        String s1 = "art";
        String s2 = "rat";

        s1 = Arrays.stream(s1.split("")).map(m -> m.toLowerCase())
                .sorted().collect(Collectors.joining());
        s2 = Arrays.stream(s2.split("")).map(m -> m.toLowerCase())
                .sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an Anagram");
        }
    }

    static void sumOf() {
        Integer i = 1234;
        int sumOfDigits = Stream.of(String.valueOf(i).split(""))
                .collect(Collectors.summingInt(m->Integer.parseInt(m)));
        System.out.println(sumOfDigits);
    }

    static void secondLargestNumber() {
        List<Integer> list = Arrays.asList(12, 23, 34, 45, 63, 25);
        int second = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(second);
    }

    static void sortBasedOnLength() {
        List<String> list = Arrays.asList("Naveen", "Amala", "Adhavan", "Adithiyan");
                list.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }

    static void commonElementsBetweenArray() {
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(f->list1.contains(list2)).forEach(System.out::println);
    }

    static void reverseEachWord() {
        String text = "hello how are you";

        String result = Arrays.stream(text.split(" "))
                .map(m -> new StringBuilder(m).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    static void reverseIntegerArray() {
        int[] array = {1, 4, 2, 6, 67, 5};

        int[] reversedArray = IntStream.rangeClosed(1, array.length)
                .map(i -> array[array.length - i])
                .toArray();

        System.out.println(Arrays.toString(reversedArray));
        System.out.println("--------");
        //print 10 even numbers
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
        //print 10 odd numbers
       // IntStream.rangeClosed(1,10)
    }

    static void mostRepeatedElement() {
        List<String> list = Arrays.asList("Pen", "Eraser", "Pen", "Paper","ink","Paper");
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(m -> m, Collectors.counting()));
        System.out.println("most repeated element " + map.entrySet().stream()
                .max(Comparator.comparing(m->m.getValue().compareTo(m.getValue()))).get().getKey());
        System.out.println("most repeated element " + map.entrySet().stream()
                .filter(m->m.getValue() > 1).collect(Collectors.toList()));
    }

    static void palindrome() {
        String val = "malayalam";
        String out = Arrays.stream(val.split(""))
                .map(m -> new StringBuilder(m).reverse())
                .collect(Collectors.joining());
        if (val.equals(out)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    static void stringStartingWithNumber() {
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStrings.stream()
                .filter(m -> Character.isDigit(m.charAt(0)))
                .forEach(System.out::println);

    }

    static void extractDuplicates() {
        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> elements = new HashSet<>();
        listOfIntegers.stream()
                .filter(i->!elements.add(i))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    static void duplicateCharacters() {
        String input = "adhavan";
        Set<Character> set = new HashSet<>();
        Arrays.stream(input.split(""))
                .filter(m->!set.add(m.charAt(0)))
                .forEach(System.out::println);

        System.out.println("Find first duplicate character " + Arrays.stream(input.split(""))
                .filter(m->!set.add(m.charAt(0)))
                .findFirst().get());

        // Find first non-repeated character
        Set<Character> set2 = new HashSet<>();

        Map<String,Long> map =Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(k->k,Collectors.counting()));
        Map.Entry<String,Long> res = map.entrySet().stream().filter(e->e.getValue() == 1).findFirst().get();
        System.out.println("Find first non-repeated character " + res.getKey());
    }

    static void lastElement() {
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five");

        System.out.println(listOfStrings.stream().skip(listOfStrings.size()-1).findAny().get());
    }
}



