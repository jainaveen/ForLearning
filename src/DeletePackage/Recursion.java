package DeletePackage;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public void print(int n) {
        if(n==0) {
            return;
        }
        print(n-1);
        System.out.print(n + " ");
    }

    public int factorial(int n) {
        if(n == 2) {
            return 2;
        }
        return n * factorial(n-1);
    }

    // 0,1,1,2,3,5,8,13,21.......
    public int fibonacci(int index) {
        if(index < 2) {
            return index;
        }
        return fibonacci(index-1) + fibonacci(index-2);
    }

    public void printPattern(int n) {
        if(n<0){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printPattern(n-5);
        System.out.print(n + " ");
    }

    public int  atoi(String str) {
        int result;
        if(str.startsWith("-")) {
            result = implementAtoi(str.substring(1), 0);
        } else {
            result = implementAtoi(str,0);
        }
        if(str.startsWith("-") && result != -1) {
            return -1 * result;
        }
        return result >= 0 ? result : -1;
    }

    public int implementAtoi(String str, int ch) {
        if(str.length() == 0) {
            return ch;
        }
        char c = str.charAt(0);
        if(Character.isDigit(c)) {
            ch = Integer.parseInt(ch + "" + Integer.parseInt(c + ""));
        } else {
            return -1;
        }
        return implementAtoi(str.substring(1),ch);
    }

    public List<String> find_permutation(String S) {
        String pro = "";
        String unp = S;
        List<String> list = new ArrayList<>();
        return permutationHelper(pro,unp, list);
    }

    public List<String> permutationHelper(String pro, String unp, List<String> list) {
        if(unp.isEmpty()) {
            list.add(pro);
            return list;
        }

        char c = unp.charAt(0);
        for (int i = 0; i <= pro.length(); i++) {
            String first = pro.substring(0,i);
            String last = pro.substring(i, pro.length());
            permutationHelper(first + c + last, unp.substring(1),list);
        }
        return list;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        combinationSumHelper(new int[]{2,3,5},8, list, list2, 0);
        return list;
    }

    public void combinationSumHelper(int[] candidates, int target,
                                                    List<List<Integer>> list, List<Integer> list2, int start) {
        if(target == 0) {
            list.add(new ArrayList<>(list2));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            list2.add(candidates[i]);
            combinationSumHelper(candidates,target - candidates[i],list,list2, i);
            list2.remove(list2.size()-1);
        }
    }
}
