package CollectionOverview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
/*
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
*/
        List<Integer> list = List.of(1,2,3,4,5);
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += list.get(i) + " ";
        }
        System.out.println(output);

    }
}
