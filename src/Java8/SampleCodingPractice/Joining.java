package Java8.SampleCodingPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Facebook","Twitter","Insta","TikTok");
        String collect = stringList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }
}
