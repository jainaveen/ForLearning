package InterviewPrograms.LazyInitialization;

//You have two classes A and B, and each class has a reference to the other.
//You want to implement a lazy initialization where instances of A and B are created
// only when required, but without resulting in infinite recursion
public class A {

    private B b;

    public B getB() {
        if(b == null) {
            b = new B(this);
        }
        return b;
    }
}
