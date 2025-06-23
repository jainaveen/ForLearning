package Trees.BinaryTrees.DepthFirstSearch;

import Trees.BinaryTrees.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public TreeNode root;
    int diameter = 0;
    int count = 0;

    public void printNode(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(" " +node.value);
        printNode(node.left);
        printNode(node.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter -1;
    }
    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftheight = height(node.left);
        int rightheight = height(node.right);

        int maxDiameter = 1 + leftheight + rightheight;
        diameter = Math.max(maxDiameter, diameter);
        int height = 1 + Math.max(leftheight,rightheight);


        return height;
    }

    public TreeNode invertBinaryTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invertBinaryTree(node.left);
        TreeNode right = invertBinaryTree(node.right);

        node.left = right;
        node.right = left;
        return node;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftNode = maxDepth(root.left);
        int rightNode = maxDepth(root.right);

        int height = 1 + Math.max(leftNode , rightNode);
        return height;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

       return  createBalancedBST(nums, 0, nums.length-1);

    }

    public TreeNode createBalancedBST(int[] nums, int start, int end) {
        if(start>end) {
            return null;
        }

        TreeNode root = new TreeNode();
        int mid = (start+end)/2;

        root.value = nums[mid];
        root.left = createBalancedBST(nums, start, mid-1);
        root.right = createBalancedBST(nums, mid+1, end);

        return root;
    }

    public void flatten(TreeNode root) {
        TreeNode currNode = root;
        while(currNode != null) {
            if(currNode.left != null){
                TreeNode temp = currNode.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            }
            currNode = currNode.right;
        }

    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if(node == null) {
            return true;
        }

        if(low !=null && node.value <= low){
            return false;
        }
        if(high != null && node.value >= high) {
            return false;
        }
        boolean leftTree = helper(node.left, low, node.value);
        boolean rightTree = helper(node.right, node.value, high);

        return leftTree && rightTree;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode != null & rightNode != null) {
            return root;
        }

        return leftNode == null ? rightNode : leftNode;
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return (left + right ) + 1;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null) {
            return true;
        }
        boolean leftNode = false;
        boolean rightNode = false;
        if(p==null || q == null || p.value != q.value) {
            return false;
        }
        leftNode = isSameTree(p.left, q.left);
        rightNode = isSameTree(p.right, q.right);


        return leftNode && rightNode;
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        return helper2(root, k).value;
    }

    public TreeNode helper2(TreeNode node, int k) {
        if(node == null) {
            return null;
        }
        TreeNode left = helper2(node.left, k);
        if(left != null){
            return left;
        }
        count++;
        if(count == k) {
            return node;
        }
        return helper2(node.right, k);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(r == inorder[i]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(r);
        TreeNode leftNode = buildTree(Arrays.copyOfRange(preorder,1, index+1), Arrays.copyOfRange(inorder,0, index));
        TreeNode rightNode = buildTree(Arrays.copyOfRange(preorder,index+1, preorder.length), Arrays.copyOfRange(inorder,index+1, inorder.length));

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int r = postorder[postorder.length-1];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(r == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(r);
        TreeNode leftNode = buildTree2(Arrays.copyOfRange(inorder,0, index),Arrays.copyOfRange(postorder, 0, index));
        TreeNode rightNode = buildTree2(Arrays.copyOfRange(inorder,index+1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length-1));

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
