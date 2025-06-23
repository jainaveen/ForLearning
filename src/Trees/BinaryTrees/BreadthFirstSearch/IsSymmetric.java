package Trees.BinaryTrees.BreadthFirstSearch;

import Trees.BinaryTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    TreeNode root;

    public static void main(String[] args) {
        IsSymmetric bt = new IsSymmetric();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(2);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(4);
        bt.root.right.left = new TreeNode(4);
        bt.root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(bt.root));

    }

    public static boolean isSymmetric(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);

        while(!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if(leftNode == null && rightNode == null) {
                continue;
            }
            if(leftNode == null || rightNode == null) {
                return false;
            }

            if(leftNode.value != rightNode.value) {
                return false;
            }
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
}
