package Array.Medium;

import java.util.Arrays;
import java.util.Stack;

public class IMPNextGreaterElement {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
        //Big O(n) approach
        System.out.println(Arrays.toString(optimizedApproach(nums)));
    }

    private static int[] optimizedApproach(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums.length];
        for (int i = nums.length-1; i >=0 ; i--) {
            // Pop elements from stack that are smaller than the current element
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // If stack is empty, no greater element exists
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push current element onto the stack
            stack.push(nums[i]);
        }
        return res;
    }

    // O(n2 ) approach
    public static int[] nextGreaterElement(int[] nums) {
        int left = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            int val = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] > val) {
                    res[left] = nums[j];
                    left++;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                res[left] = -1;
                left++;
            }
        }
        res[nums.length-1] = -1;
        return res;
    }


}
