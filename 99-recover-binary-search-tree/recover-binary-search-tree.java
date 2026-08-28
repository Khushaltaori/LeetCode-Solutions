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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root,list);

        int i = 0;
        TreeNode first = null;
        TreeNode second = null;

        while(i< list.size()-1){
            if(list.get(i).val>list.get(i+1).val){
                if(first == null){
                    first = list.get(i);
                }

                second = list.get(i+1);
            }
            i++;
        }
        swap(first,second);
    }

    public void inorder(TreeNode root,ArrayList<TreeNode>list){
        if (root == null) return;

        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }

    public void swap(TreeNode first,TreeNode second){
       
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}