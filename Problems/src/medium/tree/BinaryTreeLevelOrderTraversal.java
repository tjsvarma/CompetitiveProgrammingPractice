package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Iterative Method
     */
    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return list;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(subList);
        }
        return list;
    }

    /**
     * Recursive Method
     */
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(root,0,ans);
        return ans;
    }
    public void recursion(TreeNode root, int level, List<List<Integer>> ans){
        //integer for level is passed so that we know the level of the current node
        if(root!=null){
            //if the current level does not exist in the list, add a list to the ans
            if(level == ans.size()){
                ans.add(new ArrayList<Integer>());
            }
            //add the root's value at index level in the list
            ans.get(level).add(root.val);

            //recurse for left and right node, increment level by 1
            recursion(root.left, level+1, ans);
            recursion(root.right,level+1, ans);
        }
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