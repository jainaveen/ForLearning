package Java8.LearnBasics.FunctionalInterface;

public class TestClass {

    public static void main(String[] args) {
        A a1 = (a, b) -> System.out.println("Addition " + (a+b));
        a1.add(5,10);
    }
}
