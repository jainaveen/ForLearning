package Java8.LearnBasics.Lambda;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        LambdaInterface li = ()-> System.out.println("I am Running");
        li.run();

        LambdaInterface2 li2 = (speed)->System.out.println("Running at a speed " + speed);
        li2.run2(100);

        // lambda expression: without return
        LambdaInterface3 li3 = (speed, distance)->("Running at a speed " + speed +
                " and covered a distance " + distance);
       String str =  li3.run3(100,15);
        System.out.println(str);

        // lambda expression: WITH return
        LambdaInterface3 li4 = (int speed, int distance)-> {
            return ("Running at a speed " + speed +
                    " and covered a distance " + distance);
        };
        String str2 =  li4.run3(100,15);
        System.out.println(str2);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        // Old approach using foreach
        System.out.println("Traversing using foreach");
        for(Integer element: list) {
            System.out.println(element);
        }
        // lambda expression
        System.out.println("Traversing using lambda expression");
        list.forEach(m-> System.out.println(m));
    }
}
