package Java8.SampleCodingPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseOrder {

    public static void main(String[] args) {
        List<Double> doubleList = Arrays.asList(12.73, 23.56,17.13, 42.35,76.5);
        doubleList.stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
