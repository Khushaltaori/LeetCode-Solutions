import java.util.*;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index for O(1) lookup
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(
            preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1,
            inMap
        );
    }

    public TreeNode buildTree(
        int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd,
        Map<Integer, Integer> inMap
    ) {

        // Base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // First element in preorder range is the root
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root position in inorder
        int inRoot = inMap.get(root.val);

        // Number of nodes in left subtree
        int numsLeft = inRoot - inStart;

        // Build left subtree
        root.left = buildTree(
            preorder,
            preStart + 1,
            preStart + numsLeft,
            inorder,
            inStart,
            inRoot - 1,
            inMap
        );

        // Build right subtree
        root.right = buildTree(
            preorder,
            preStart + numsLeft + 1,
            preEnd,
            inorder,
            inRoot + 1,
            inEnd,
            inMap
        );

        return root;
    }
}