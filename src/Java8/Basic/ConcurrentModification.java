package Java8.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*Q1.How will you simulate concurrent modification through stream API ?

Ans: In Java, the Stream API does not directly support concurrent modification of streams.
Java8.Basics.Streams in Java are designed to be operated in a non-concurrent manner.
However, you can simulate concurrent modification by using concurrent data structures
or by employing parallel streams.
*/

public class ConcurrentModification {

    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(n-> {
            System.out.println("val " + n);
            list.add(n*10);
        });
        System.out.println(list);
    }
}
