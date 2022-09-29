package medium.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Constraints:
 *
 *     1 <= inorder.length <= 3000
 *     postorder.length == inorder.length
 *     -3000 <= inorder[i], postorder[i] <= 3000
 *     inorder and postorder consist of unique values.
 *     Each value of postorder also appears in inorder.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 *     postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private TreeNode buildTree(int[] postorder, int poStartBound, int poEndBound, int[] inorder, int inStartBound, int inEndBound , Map<Integer, Integer> inMap) {
        if (poStartBound < poEndBound || inStartBound > inEndBound) return null;

        TreeNode node = new TreeNode(postorder[poStartBound]);
        int elementPositionInInorder = inMap.get(node.val);
        int numsRight = inEndBound - elementPositionInInorder;

        node.right = buildTree(postorder, poStartBound-1, poStartBound-numsRight, inorder, elementPositionInInorder+1, inEndBound, inMap);
        node.left = buildTree(postorder, poStartBound-numsRight-1, poEndBound, inorder, inStartBound, elementPositionInInorder-1, inMap);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int poSize = postorder.length;
        int inSize = inorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inSize; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, poSize-1, 0, inorder, 0, inSize-1, inMap);

        return root;
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