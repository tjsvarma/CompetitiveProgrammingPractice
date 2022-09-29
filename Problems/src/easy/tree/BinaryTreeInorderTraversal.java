package easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    private void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
    }

    /**
     * Recursive Method
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    /**
     * Iterative Method
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iterator = new TreeNode();
        if (root == null) return list;
        stack.push(root);
        iterator = root;
        while (!stack.empty()) {
            if (iterator.left != null) {
                iterator = iterator.left;
                stack.push(iterator);
            } else {
                TreeNode popped = stack.pop();
                list.add(popped.val);
                if (popped.right != null) {
                    iterator = popped.right;
                    stack.push(iterator);
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