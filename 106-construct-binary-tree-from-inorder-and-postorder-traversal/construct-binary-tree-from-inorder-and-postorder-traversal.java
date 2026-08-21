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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null || inorder.length!=postorder.length) return null;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildPost(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }

    private TreeNode buildPost(int[] inorder ,int is , int ie, int[]postorder, int ps, int pe , HashMap<Integer,Integer> map){
        if(is>ie || ps>pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot = map.get(postorder[pe]);
        int numsleft = inRoot - is;

        //for left
        root.left = buildPost(inorder,is,inRoot-1,postorder,ps,ps+numsleft-1,map);

        //right
        root.right = buildPost(inorder,inRoot+1,ie,postorder,ps+numsleft,pe-1,map);
        return root;
    }
}