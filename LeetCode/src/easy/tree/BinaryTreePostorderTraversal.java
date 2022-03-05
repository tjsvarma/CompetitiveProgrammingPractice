package easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Constraints:
 *
 *     The number of the nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
    private void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }

    /**
     * Recursive Method
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    /**
     * Iterative Method
     */
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode recentlyPopped = null;
        if (root == null) return list;
        TreeNode iterator = root;
        stack.push(root);
        while (!stack.empty()) {
            if (iterator.left != null) {
                iterator = iterator.left;
                stack.push(iterator);
            } else {
                TreeNode top = stack.peek();
                if (top.right != null && recentlyPopped != top.right) {
                    iterator = top.right;
                    stack.push(iterator);
                } else {
                    recentlyPopped = stack.pop();
                    list.add(recentlyPopped.val);
                }
            }
        }
        return list;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */