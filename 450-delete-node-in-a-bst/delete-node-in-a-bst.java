class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Case: root itself needs to be deleted
        if (root.val == key) {
            return helper(root);
        }

        TreeNode dummy = root;

        while (root != null) {

            if (root.val > key) {

                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }

                root = root.left;

            } else if (root.val < key) {

                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }

                root = root.right;
            }
        }

        return dummy;
    }

    public TreeNode helper(TreeNode root) {

        // No left child
        if (root.left == null) {
            return root.right;
        }

        // No right child
        else if (root.right == null) {
            return root.left;
        }

        // Both children exist
        else {
            TreeNode rightChild = root.right;

            TreeNode lastRight = findLastRight(root.left);

            lastRight.right = rightChild;

            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root) {

        if (root.right == null) {
            return root;
        }

        return findLastRight(root.right);
    }
}