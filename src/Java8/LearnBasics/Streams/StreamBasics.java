package Java8.LearnBasics.Streams;

import java.util.stream.Stream;


import java.util.Arrays;

public class StreamBasics {

    public static void main(String[] args) {
        int[] arr = {2,5,8,9};

        Stream<Integer> str = Arrays.stream(arr).boxed();

        str.forEach(System.out::println);


        
    }
}
