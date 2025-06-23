package Java8.LearnBasics.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForLoopVsStreams {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<String> stream =
                Stream.of("a", "b", "c").filter(s -> s.startsWith("a"));
        stream.forEach(System.out::println);

        //using stream
        long start = System.nanoTime();
        list.stream().forEach(System.out::println);
        long end = System.nanoTime();
        System.out.println("overall time " + (end-start) + "ns");

        //using for loop
        start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("overall for loop time " + (end-start) + "ns");


    }
}
