package String.Easy;

public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        String rem = "";
        String fir = "";
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) {
                fir = word.substring(0,i+1);
                rem = word.substring(i+1);
                flag = true;
                break;
            }
        }
        if(!flag) {
            return word;
        }
        sb.append(fir).reverse();
        sb.append(rem);
        return sb.toString();

    }
}
