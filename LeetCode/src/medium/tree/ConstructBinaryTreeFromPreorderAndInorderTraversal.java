package medium.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Constraints:
 *
 *     1 <= preorder.length <= 3000
 *     inorder.length == preorder.length
 *     -3000 <= preorder[i], inorder[i] <= 3000
 *     preorder and inorder consist of unique values.
 *     Each value of inorder also appears in preorder.
 *     preorder is guaranteed to be the preorder traversal of the tree.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private TreeNode buildTree(int[] preorder, int preStartBound, int preEndBound, int[] inorder, int inStartBound, int inEndBound , Map<Integer, Integer> inMap) {
        if (preStartBound > preEndBound || inStartBound > inEndBound) return null;

        TreeNode node = new TreeNode(preorder[preStartBound]);
        int elementPositionInInorder = inMap.get(node.val);
        int numsLeft = elementPositionInInorder - inStartBound;

        node.left = buildTree(preorder, preStartBound+1, preStartBound+numsLeft, inorder, inStartBound, elementPositionInInorder-1, inMap);
        node.right = buildTree(preorder, preStartBound+numsLeft+1, preEndBound, inorder, elementPositionInInorder+1, inEndBound, inMap);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preSize = preorder.length;
        int inSize = inorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inSize; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preSize-1, inorder, 0, inSize-1, inMap);

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
