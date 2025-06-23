package Threads;

public class ThreadException {
    public static void main(String ar[]){
        System.out.println(hello());
    }

    private static int hello(){
        try{
            throw new RuntimeException("dwed");
        }finally{
           // return 10; // Bad practice to use return statment, it can lead to suppression of exceptions
            System.out.println("Finally block executed");
        }
    }
}
