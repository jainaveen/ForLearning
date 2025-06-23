package Java8.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestString {
    public static void main(String[] args) {
        String [] arrayInput = {"vivek"  , "kadiyan" , "ram" , "chaudhary vivek kadiyan"};
        System.out.println("longest string " + Stream.of(arrayInput)
                .reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2).get());

        Map<Object, Long> map = Arrays.stream(arrayInput)
                .collect(Collectors.groupingBy(m->m, Collectors.counting()));
        String ob = (String) map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println(ob);


    }
}
