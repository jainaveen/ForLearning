package Java8.Strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateCharacters {

    public static void main(String[] args) {

        String input="vivek kadiyan";

        System.out.println("Duplicate Characters " + Stream.of(input.split(""))
                .collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                .entrySet().stream().filter(m->m.getValue()>1)
                .toList());
        System.out.println("Unique characters " + Stream.of(input.replace("","").split(""))
                .collect(Collectors.groupingBy(ch->ch, Collectors.counting()))
                .entrySet().stream().filter(m->m.getValue() == 1)
                .toList());
        //duplciate element and occurrence
        Map<String, Long> map =  Stream.of(input.split("")).collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                .entrySet().stream().filter(m->m.getValue()>1)
                .collect(Collectors.groupingBy(m->m.getKey(), Collectors.counting()));
        System.out.println(map);

    }
}
