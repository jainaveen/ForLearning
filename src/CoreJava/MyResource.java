package CoreJava;

import java.io.IOException;

public class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("resource closed");
    }

    public static void main(String[] args)  {
        try(MyResource myResource = new MyResource()) {
            System.out.println("using resource");
        } catch (Exception e){

        }
    }
}
