package Java8.Strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NthHighestSalary {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("anil",1000);
        map.put("ankit",1200);
        map.put("bhavna",1300);
        map.put("james",1400);
        map.put("micael",1500);
        map.put("tom",1600);
        map.put("daniel",1700);

        System.out.println("Find the 2nd Largest Salary " + map.entrySet().stream().sorted(Comparator.comparing(m->-m.getValue()))
                .toList().get(1));

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);

        Map<Integer,List<String>> interim = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(m->m.getValue(),
                        Collectors.mapping(m->m.getKey(),Collectors.toList())));
        Map.Entry<Integer,List<String>> finalResult = interim.entrySet()
                .stream()
                .sorted(Comparator.comparing(m->m.getKey()))
                .collect(Collectors.toList())
                .get(1);
        System.out.println("Second largest salary " + finalResult);

        int array[] = {1,3,2,4,5,6,6,9,9,10,11};

       Integer in = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder())
                       .collect(Collectors.toList()).stream().skip(1).findFirst().get();
        System.out.println(in);

       IntStream it = Arrays.stream(array);
       List<Integer> l = Arrays.asList(1,2,3);
     Stream<Integer> s =  l.stream();

    }
}
