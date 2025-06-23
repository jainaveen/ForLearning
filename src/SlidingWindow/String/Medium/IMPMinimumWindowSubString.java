package SlidingWindow.String.Medium;

public class IMPMinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println(minWindowSubString("ADOBECODEBANC", "ABC"));

        System.out.println(minimumWindowSubString("ADOBECODEBANC", "ABC"));
    }

    public static int minWindowSubString(String s, String t) {
        int right = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE ;
        StringBuilder sb = new StringBuilder();
        while (right < s.length()) {
            sb.append(s.charAt(right++));
            while(sb.length() >= t.length()) {
                if(containAllCharacters(sb.toString() , t)) {
                    left++;
                    minLen = Math.min(minLen, right - left+1);
                    sb.deleteCharAt(0);
                    continue;
                } {
                    break;
                }
            }
        }
        return minLen;
    }
    public static String minimumWindowSubString(String s, String t) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        //Set up the table
        for(char cur : t.toCharArray()){
            map[cur]++;
        }

        int countAllCharInT = 0;
        int left = 0, n = arr.length, right = 0;
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";

        while(right < n){
            //Expand the window
            map[arr[right]]--;
            if(map[arr[right]] >=0 ){
                countAllCharInT++;
            }

            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }

                //Shrink the window
                map[arr[left]]++;
                if(map[arr[left]] > 0){
                    countAllCharInT--;
                }
                left++;
            }

            right++;
        }

        return minLenStr;
    }
    public static boolean containAllCharacters(String s, String t) {
        int[]  ch = new int[256];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i )]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(ch[t.charAt(i)] > 0) {
                ch[t.charAt(i)]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
