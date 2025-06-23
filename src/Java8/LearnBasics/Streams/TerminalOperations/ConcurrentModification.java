package Java8.LearnBasics.Streams.TerminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModification {
    //How will you simulate concurrent modification through stream API ?
    //Streams in Java are designed to be operated in a non-concurrent manner.
    // However, you can simulate concurrent modification by using concurrent data structures or by employing parallel streams.
    public static void main(String[] args) {
      //  List<Integer> list = new ArrayList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
        System.out.println("Input list " + list);
        list.parallelStream().forEach( num -> list.add(num*5));
        System.out.println(list);
    }
}
