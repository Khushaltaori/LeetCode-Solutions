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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        

        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty()){
                    break;
                }

                root = st.pop();
                ans.add(root.val);
                root = root.right;
            }
            
        }
        return ans;
    }
}