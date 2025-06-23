package Java8.LearnBasics.FunctionalInterface;

public class TestClass {

    public static void main(String[] args) {

        // Traditional approach
        MyFunctionalInterface fi = new MyFunctionalInterface() {
            @Override
            public void bar() {
                System.out.println("Traditional Approach implementation");
            }
        };

        fi.bar();

        // Implementing functional interface using lambda
        MyFunctionalInterface lam = ()-> System.out.println("Printing");
        lam.bar();

        //Little complicated
        //Method reference is a concept in which we can refer
        // a method to an abstract method of an interface
        TestClass test = new TestClass();
        // Referring to a non-functional method
        MyFunctionalInterface nf = test::printMethod;
        // calling abstract method
        nf.bar();
    }

    // Implementation of print() abstract method
    public void printMethod() {
        System.out.println("Non functional method Printing...");
    }
}
