package Java8.LearnBasics.MethodReferences;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6));
        System.out.println(nestedList);
        List<Integer> flattenedList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList);

        IntBinaryOperator operator = Utils::multiply;
        int result = operator.applyAsInt(4, 5);
        System.out.println(result);

        Person person = new Person("John");
        Supplier<String> supplier = person::getName;
        String name = supplier.get();
        System.out.println(name);
    }

}
