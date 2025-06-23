package Java8.SampleCodingPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Frequency {
    public static void main(String[] args) {

        frequencyCharacter();
        frequencyElementInArray();

    }

    static void frequencyCharacter(){
        String text = " Java Concept of the day ";
        System.out.println(text);
        System.out.println(text.trim());
        System.out.println(text.replaceAll("\\s",""));

        Map<String,Long> map = Arrays.stream(text.split(""))
                .map(m->m.trim())
                .collect(Collectors.groupingBy(m->m, Collectors.counting()));
        System.out.println(map);
    }

    static void frequencyElementInArray() {
      List<String> list =  Arrays.asList("Pen","Eraser","Ink","Pencil","Pen","Ink");
      Map<String, Long> map = list.stream().
              collect(Collectors.groupingBy(k->k, Collectors.counting()));
        System.out.println(map);
    }
}
