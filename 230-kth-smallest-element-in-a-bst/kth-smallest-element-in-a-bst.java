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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return 0;
        inorder(root,list);
        
        return list.get(k-1);   
    }

    public TreeNode inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return null;

        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
        return root;
    }
}