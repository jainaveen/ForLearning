package Java8.Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeat {

    public static void main(String[] args) {
        approach();
        approach2();


    }

    private static void approach2() {
        String text = "swiss";

        // different ways to get the character

        String firstNonRepeating = Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("no non repeated characters");

        // Find the second non-repeating character using Java 8
        Optional<Character> secondNonRepeatingChar = text.chars()
                .mapToObj(c -> (char) c) // Convert each int to char
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Group by character with counts
                .entrySet().stream() // Stream over the map entries
                .filter(entry -> entry.getValue() == 1) // Filter for non-repeating characters
                .skip(1) // Skip the first non-repeating character
                .map(Map.Entry::getKey) // Extract the character
                .findFirst(); // Get the second non-repeating character
        // Print the result
        secondNonRepeatingChar.ifPresentOrElse(
                c -> System.out.println("Second non-repeating character: " + c),
                () -> System.out.println("No second non-repeating character found")
        );
    }

    private static void approach() {

        String str = "malaiyalam";
        System.out.println("First non repeat character " + Stream.of(str.split(""))
                .collect(Collectors.groupingBy(ch->ch, Collectors.counting()))
                .entrySet().stream().filter(m->m.getValue()==1).findFirst().get().getKey());
    }
}
