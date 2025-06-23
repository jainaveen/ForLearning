package Array.Easy;

public class SumOfDigits {
    public static void main(String[] args) {
        sumOfDigits();
        addDigits();
    }

    private static void sumOfDigits() {
        int num = 38;
        int total = 0;
        while(num >0) {
            total += num % 10;
            num = num /10;
        }
        System.out.println(total);
    }

    private static void addDigits() {
        int num = 38;
        int total = 0;
        while(num > 0) {
            total += num % 10;
            num = num / 10;
            if(num <=0 && total >= 10) {
                num = total;
                total = 0;
            }
        }
        System.out.println(total);
    }
}
