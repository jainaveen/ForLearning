package Java8.LearnBasics.MethodReferences;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import Java8.LearnBasics.FunctionalInterface.A;


public class Demo {
    public static void main(String[] args) {

        A a1 = (a,b) -> System.out.println("Addition " + (a+b));
        a1.add(10,20);

        A a2 = Utils::multiply;
        a2.add(8,9);

        List<Integer> numbers = Arrays.asList(15, 33, 59, 24, 40, 2, 19, 25,60);

        //*** Using Anonymous Inner class ***//
        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer i1,Integer i2) {
                return i1.compareTo(i2);
            }
        });
        System.out.println("************* Using Anonymous Inner class ***************");
        numbers.forEach(System.out::println);

        //*** Using Lambda Expression ***//
        System.out.println("************* Using Lambda Expression *******************");
        Collections.sort(numbers,(i1,i2) ->i1.compareTo(i2));
        numbers.forEach(System.out::println);

        //*** Using Method Reference ***//
        System.out.println("************* Using Method reference ********************");
        Collections.sort(numbers,Integer::compareTo);
        numbers.forEach(System.out::println);

        Person person = new Person("John");
        Supplier<String> supplier = person::getName;
        String name = supplier.get();
        System.out.println(name);
    }

}
