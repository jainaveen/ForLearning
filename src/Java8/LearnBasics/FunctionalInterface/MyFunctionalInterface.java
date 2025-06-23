package Java8.LearnBasics.FunctionalInterface;

//https://www.linkedin.com/pulse/java-8-new-features-example-abid-anjum/
@FunctionalInterface  // Annotation is optional
//The functional interface is used to support the
// functional programming approach, lambda expression, and method reference as well.
public interface MyFunctionalInterface {

    // Default Method - Optional can be 0 or more
    // it can be overridden . it does not qualify as Synchronized or Final
     default String HelloWorld() {
        return "Hello World";
    }

    // Static Method - Optional can be 0 or more
    // cannot be overridden
     static String CustomMessage(String msg) {
        return msg;
    }
    // Single Abstract Method
    void bar();
}

