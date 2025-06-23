package DeletePackage;

public class Demo {
    public static void main(String[] args) {
        Recursion rec = new Recursion();
        rec.print(10);
        System.out.println();
        System.out.println(rec.factorial(5));
        System.out.println(rec.fibonacci(4));
        rec.printPattern(16);
        System.out.println(rec.atoi("00000"));
        System.out.println(rec.find_permutation("ABC"));

        System.out.println(rec.combinationSum(new int[]{2,3,5},8));
    }
}
