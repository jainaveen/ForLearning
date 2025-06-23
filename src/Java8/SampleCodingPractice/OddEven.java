package Java8.SampleCodingPractice;

import java.util.*;
import java.util.stream.Collectors;
//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
public class OddEven {

    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> map = listOfIntegers.stream()
                .collect(Collectors.partitioningBy(i->i%2==0));

        map.entrySet().forEach(entry ->{
            Collections.sort(entry.getValue());
        });

        map.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() ? "Even Numbers" : "Odd Numbers");
            System.out.println("-------------------");
            entry.getValue().forEach(System.out::println);
        });
    }
}
