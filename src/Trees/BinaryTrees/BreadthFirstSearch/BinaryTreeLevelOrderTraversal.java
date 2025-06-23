package Trees.BinaryTrees.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    private TreeNode root;

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        System.out.println(levelOrder(bt.root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currNodeList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
                currNodeList.add(currNode.val);
            }
            result.add(currNodeList);
        }
        return result;
    }
}
