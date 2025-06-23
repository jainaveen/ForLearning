package Array.Medium;

import java.util.Arrays;

public class NumbersSmallerthanCurrentNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] {8,1,2,2,3})));

        String text = "ect_comp_schema#compInfo#COMP_INFO_ID";
        System.out.println(text.substring(0,text.indexOf("#")));

        System.out.println(checkIfPangram());
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] temp = new int[101];

        for(int i=0; i < n; i++){
            temp[nums[i]]++;
        }
        //cumulative sum - take prev value + curr value
        for(int i=1; i < 101; i++){
            temp[i] = temp[i] + temp[i-1];
        }

        for(int i=0; i<n; i++){
            if(nums[i] == 0) ans[i] = 0;
            else
                ans[i] = temp[nums[i]-1];
        }
        return ans;

    }

    public static boolean checkIfPangram() {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        int[] count = new int[26];
        for(int i = 0; i<sentence.length(); i++)
            count[sentence.charAt(i) - 'a']++;

        for(int i : count){
            if(i < 1) {
                return false;
            }
        }

        return true;
    }
}
