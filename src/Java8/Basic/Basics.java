package Java8.Basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basics {
    public static void main(String[] args) {
        List<String> names = List.of("Naveen","Amala","Adhavan","Adithiyan","Susila","Jayakumar","Amala");
        Stream<String> str = names.stream()
                        .filter(s->s.endsWith("a")).distinct().sorted();

        System.out.println(str.collect(Collectors.toList()));

        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


        Stream.of("a","b","c")
                .filter(f->f.startsWith("a"))
                .forEach(System.out::println);
    }
}
