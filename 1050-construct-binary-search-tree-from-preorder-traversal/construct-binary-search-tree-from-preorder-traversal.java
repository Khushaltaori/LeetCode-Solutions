class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0};

        return build(preorder, Integer.MAX_VALUE, index);
    }

    private TreeNode build(int[] preorder, int bound, int[] index) {

        // No elements left OR current value cannot be placed here
        if (index[0] == preorder.length || preorder[index[0]] > bound) {
            return null;
        }

        // Create root using current preorder element
        TreeNode root = new TreeNode(preorder[index[0]++]);

        // Build left subtree
        // All values must be smaller than root.val
        root.left = build(preorder, root.val, index);

        // Build right subtree
        // Values can go up to the current bound
        root.right = build(preorder, bound, index);

        return root;
    }
}