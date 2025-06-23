package Java8.LearnBasics.Joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningString {
    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String joinedString = listOfStrings.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joinedString);

       String join =  listOfStrings.stream().collect(Collectors.joining(","));
        System.out.println(join);

        // Creating a character list
        List<Character> ch = Arrays.asList(
                'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G',
                'e', 'e', 'k', 's');

        // Converting character list into string
        // using joining() method of Collectors class
        String chString
                = ch.stream()
                .map(m->String.valueOf(m))
                .collect(Collectors.joining());

        // Printing the concatenated string
        System.out.println(chString);

        // Creating a character list
        String[] st = {"A","B","C"};

        String res
                = Arrays.stream(st)
                .collect(Collectors.joining());
        System.out.println(res);



        // Creating a custom character array
        char[] ch1 = { 'G', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'G', 'e', 'e', 'k', 's' };


        // Converting character array into string
        // using joining() method of Collectors class
        String chString1
                = Stream.of(ch1)
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Printing concatenated string
        System.out.println(chString1);


        // Create a string list
        List<String> str = Arrays.asList("Geeks", "for", "Geeks");

        // Convert the string list into String
        // using Collectors.joining() method
        String chString3
                = str.stream()
                .collect(Collectors.joining());

        // Print the concatenated String
        System.out.println(chString3);
    }
}





