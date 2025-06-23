package Trees.BinaryTrees.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrderTraversal {
    private TreeNode root;

    public static void main(String[] args) {
        ZigzagLevelOrderTraversal bt = new ZigzagLevelOrderTraversal();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        System.out.println(zigzagOrder(bt.root));
    }

    // For Normal Order,
        // remove from front and add the node at back
    // For reverse Order
        // remove from back and add the node in front
    private static List<List<Integer>> zigzagOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean reverse = false;
        while(!deque.isEmpty()) {
            int levelsize = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currNode;
                if(!reverse) {
                    currNode = deque.pollFirst();
                    if(currNode.left != null) {
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right != null) {
                        deque.addLast(currNode.right);
                    }
                } else {
                    currNode = deque.pollLast();
                    if(currNode.right != null) {
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left != null) {
                        deque.addFirst(currNode.left);
                    }
                }
                list.add(currNode.val);
            }
            reverse = !reverse;
            result.add(list);
        }
        return result;
    }
}
