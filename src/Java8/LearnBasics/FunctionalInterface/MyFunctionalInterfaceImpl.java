package Java8.LearnBasics.FunctionalInterface;

import java.util.Arrays;
import java.util.List;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public String HelloWorld() {
        return "Default method overridden";
    }

    @Override
    public void bar() {
        System.out.println("Abstract method overridden");
    }

    public static void main(String[] args) {

        MyFunctionalInterfaceImpl impl = new MyFunctionalInterfaceImpl();

        System.out.println(impl.HelloWorld());
        impl.bar();
        System.out.println(MyFunctionalInterface.CustomMessage("Static method call"));


    }
}
