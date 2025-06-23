package InterviewPrograms.LazyInitialization;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = a.getB();

        // Access properties of A and B
        System.out.println(a.getB()); // Output: A instance
        System.out.println(b.getA()); // Output: B instance

        String text ="abc";
        if(!(text == null || text.isEmpty())) {
            System.out.println("Hi naveen");
        }

        long totalRating = 0;
        double i = 1;

        totalRating = (long) i;
        System.out.println(totalRating);

    }
}
