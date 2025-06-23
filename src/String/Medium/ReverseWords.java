package String.Medium;

public class ReverseWords {
    public static void main(String[] args) {
        String text = "  hello world  ";
        System.out.println("Before reverse: " + text);
        System.out.println("After reverse: " + reverseWords(text));
    }

    private static String reverseWords(String text) {
        String[] arr = text.split(" ");
        StringBuilder str = new StringBuilder(arr.length);
        for (int i = arr.length-1; i >=0 ; i--) {
            // First entry
            if ((!arr[i].isEmpty()) && (i == arr.length-1 )){
                str.append(arr[i]);
            } else if ((!arr[i].isEmpty()) || ((!arr[i].isEmpty())  && (i == 0 ))){
                str.append(" ");
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}
