package Java8.LearnBasics.Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoClass {

    public static void main(String[] args) {
        //Filter
        List<Integer> list = List.of(2,5,4,4,3);
        list.stream().filter(i->i>3).forEach(System.out::print);
        System.out.println();
        //map
        /*The map() function is a method in the Stream class that represents a
         functional programming concept. In simple words, the map() is used to transform
          one object into other by applying a function.
         That's why the Stream.map(Function mapper) takes a function as an argument.
         */
        list.stream().map(i->i*3).forEach(System.out::print);
        System.out.println();
        //distinct
        list.stream().distinct().forEach(m-> System.out.print(m));
        System.out.println();
        //limit
        list.stream().limit(2).forEach(System.out::print);
        System.out.println();
        //skip the first n elements from the given Stream
        list.stream().skip(2).forEach(System.out::print);
        System.out.println();
        //sorted
        list.stream().sorted().forEach(System.out::print);
        System.out.println();

        // Very Important
        //Flatmap -flattening is referred to as merging multiple collections/arrays into one.
        //Imagine we have a bunch of boxes, and each box contains some items.
        // Now, we want to take out all those items from the boxes and put them in a single box.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

         // Step 1 -> convert to Stream<List<Integer>>
        // Step 2 - > Convert to Stream<Integer>
        // Step 3 - > Convert to list
        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(m->m.stream())
                .collect(Collectors.toList());
        System.out.println(listOfAllIntegers);

        System.out.println(listOfAllIntegers.stream()
                .mapToInt(m->m.intValue())
                .sum());

        //Flattening with IntStream, LongStream and DoubleStream
        List<List<Integer>> listList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6)
        );
        // Step 1 -> convert to Stream<List<Integer>>
        // Step 2 - > Convert to Stream<Integer>
        // Step 3 - > Convert to Intstream
        // Convert to total sum
        int total = listList.stream()
                .flatMap(m->m.stream())
                .mapToInt(m->m.intValue())
                .sum();
        System.out.println(total);

        //Merging String Arrays into single list using FlatMap
        String[][] dataArray = new String[][]{{"a", "b"},
                {"c", "d"}, {"e", "f"}, {"g", "h"}};

        // Convert String[][] to Stream<String[]>
        // Convert Stream<String[]> to Stream<String>
        // Convert to list
        List<String> stringList = Arrays.stream(dataArray)
                .flatMap(x-> Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(stringList);

        //Merging integer array into single list using flatMap
        int[][] arr = new int[][] {{1,4}, {2,3},{5,7}};

        // MOST IMPORTANT
        // Convert int[][] to Stream<int[]>
        // Convert Stream<int[]> to intStream
        // Convert intstream to Stream<Integer>
        // Convert to list
        List<Integer> res = Arrays.stream(arr)
                //// Using flatMapToInt to handle primitive int values efficiently
                .flatMapToInt(m-> Arrays.stream(m))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(res);
        /*
        When to Use flatMap vs flatMapToInt:
        Use flatMap: When dealing with non-primitive types (e.g., Stream<List<Integer>>, Stream<String[]>, etc.).
        Use flatMapToInt: When working with primitive types like int[], double[], or long[], to leverage the performance benefits of primitive streams.


        // Convert int[] to intStream using Stream
        // Convert intStream to Stream<Integer>
        //Convert to list

         */

        /*
        The boxed() method is needed when you want to convert a primitive stream (like IntStream, DoubleStream, or LongStream)
        into a stream of their corresponding wrapper classes (Stream<Integer>, Stream<Double>, or Stream<Long>).
         */

        int[] a = new int[] {12,13,15};
        List<Integer> r = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(r);

        //Convert list to Stream<Integer>
        //convert Stream<Integer> to  intstream
        //Convert intstream to array
        List<Integer> li = Arrays.asList(1,2,3,4,5);
        int[] rem = li.stream()
                .mapToInt(m->m.intValue())
                .toArray();
        System.out.println(Arrays.toString(rem));

        Integer[] i = li.stream()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(i));

        //VERY important
        int x = 10;

// This is allowed:
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.forEach(n -> System.out.println(n * x)); // x is effectively final

// This is not allowed:
        numbers.forEach(n -> {
            //x++;
          //  x = 30; // x is modified within the lambda, which is not allowed
            System.out.println(n * x);
        });

        List<String> str = Arrays.asList("abc","bb","cdrf");
        //System.out.println(str.stream().map(m->m.length()).collect(Collectors.toList()));
        System.out.println(Arrays.toString(str.stream().map(String::length).mapToInt(m->m.intValue()).toArray()));
    }
}
