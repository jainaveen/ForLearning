package Trees.BinaryTrees.BreadthFirstSearch;

import Trees.BinaryTrees.Node;
import Trees.BinaryTrees.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalTest {

    public Node root;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> tempList = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = queue.poll();
                if(currentTreeNode.left != null) {
                    queue.add(currentTreeNode.left);
                }
                if(currentTreeNode.right != null) {
                    queue.add(currentTreeNode.right);
                }
                tempList.add(currentTreeNode.value);
            }
            resList.add(tempList);
        }
        return resList;
    }

    public List<List<Integer>> levelOrderRec(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderHelper(root, 0, ans);
        return ans;
    }

    private void levelOrderHelper(TreeNode treeNode, int level, List<List<Integer>> ans) {
        if (treeNode == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(treeNode.value);
        levelOrderHelper(treeNode.left, level + 1, ans);
        levelOrderHelper(treeNode.right, level + 1, ans);
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> tempList = new ArrayList<>();
        if(root == null) {
            return tempList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();

            double averageValue = 0;
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = queue.poll();
                if (currentTreeNode.left != null) {
                    queue.add(currentTreeNode.left);
                }
                if (currentTreeNode.right != null) {
                    queue.add(currentTreeNode.right);
                }
                averageValue += currentTreeNode.value;
            }
            averageValue = averageValue / level;
            tempList.add(averageValue);
        }
        return tempList;
    }

    public TreeNode levelOrderSuccessor(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode currTreeNode = queue.poll();
            if (currTreeNode.left != null) {
                queue.add(currTreeNode.left);
            }
            if (currTreeNode.right != null) {
                queue.add(currTreeNode.right);
            }
            if (currTreeNode.value == key) {
                break;
            }
        }
        return queue.peek();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean reverse = false;
        while(!deque.isEmpty()) {
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if(!reverse) {
                    TreeNode currTreeNode = deque.poll();
                    list.add(currTreeNode.value);
                    if(currTreeNode.left != null) {
                        deque.add(currTreeNode.left);
                    }
                    if(currTreeNode.right != null) {
                        deque.add(currTreeNode.right);
                    }
                } else {
                    TreeNode currTreeNode = deque.pollLast();
                    list.add(currTreeNode.value);
                    if(currTreeNode.right != null) {
                        deque.addFirst(currTreeNode.right);
                    }
                    if(currTreeNode.left != null) {
                        deque.addFirst(currTreeNode.left);
                    }

                }
            }
            reverse = !reverse;
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> tempList = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = queue.poll();
                if(currentTreeNode.left != null) {
                    queue.add(currentTreeNode.left);
                }
                if(currentTreeNode.right != null) {
                    queue.add(currentTreeNode.right);
                }
                tempList.add(currentTreeNode.value);
            }
            resList.add(0,tempList);
        }
        return resList;
    }

    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Node leftMost = root;

        while(leftMost.left != null) {
            Node current = leftMost;
            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> tempList = new ArrayList<>();
        if(root == null) {
            return tempList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = queue.poll();

                if(i == level-1){
                    tempList.add(currentTreeNode.value);
                }
                if(currentTreeNode.left != null) {
                    queue.add(currentTreeNode.left);
                }
                if(currentTreeNode.right != null) {
                    queue.add(currentTreeNode.right);
                }

            }

        }
        return tempList;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0)
        && !isSiblings(root, xx, yy));

    }
    private TreeNode findNode(TreeNode node, int val) {
        if(node == null) {
            return null;
        }
        if(node.value == val) {
            return node;
        }
        TreeNode n = findNode(node.left,val);
        if(n != null) {
            return n;
        }
        return findNode(node.right, val);
    }

    private int level(TreeNode node, TreeNode xy, int level) {
        if(node == null) {
            return 0;
        }
        if(node == xy) {
            return level;
        }
        int n = level(node.left,xy, level+1);
        if(n >0) {
            return n;
        }
        return level(node.right,xy, level+1);
    }

    private boolean isSiblings(TreeNode node, TreeNode x, TreeNode y) {
        if(node == null) {
            return false;
        }

        return ((node.left == x && node.right == y) ||
                (node.right == x && node.left == y) ||
                (isSiblings(node.left, x, y)) || (isSiblings(node.right, x, y)));
    }

    public boolean isSymmetric(TreeNode node){
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

    public boolean isSymmetricRecursion(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return true;
        }
        if(A == null || B == null) {
            return false;
        }
        return A.value == B.value && isMirror(A.left,B.right)
                && isMirror(A.right, B.left);
    }
}
