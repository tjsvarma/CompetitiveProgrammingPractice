package easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    private void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        recursion(node.left, list);
        recursion(node.right, list);
    }

    /**
     * Recursive Method
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    /**
     * Iterative Method
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode popped = null;
        stack.push(root);
        while (!stack.empty()) {
            popped = stack.pop();
            if (popped != null) {
                list.add(popped.val);
                stack.push(popped.right);
                stack.push(popped.left);
            }
        }
        return list;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
