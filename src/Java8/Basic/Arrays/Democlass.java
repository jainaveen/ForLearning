package Java8.Basic.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Democlass {

    public static void main(String[] args) {
        int[] it = {1,2,4};
        List<Integer> integerList = Arrays.stream(it)
                .boxed()
                .collect(Collectors.toList());

        String[] arr = {"A","B","C"};
        List<String> stringLists = Arrays.asList(arr);
        System.out.println(stringLists);



        String name = "hello";
        // Non-null value
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.get());
        //// Nullable value
        Optional<String> opt2 = Optional.ofNullable(name);
        System.out.println(opt2.get());

        Optional<String> opt3 = Optional.empty();
        System.out.println(opt3.get());
    }
}
