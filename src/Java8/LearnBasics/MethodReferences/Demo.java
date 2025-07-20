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

        Person person = new Person("John");
        Supplier<String> supplier = person::getName;
        String name = supplier.get();
        System.out.println(name);
    }

}
