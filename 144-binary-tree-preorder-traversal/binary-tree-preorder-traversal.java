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
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();

        if(root == null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.val);

            if(root.right!=null){
                st.push(root.right);
            }

            if(root.left!=null){
                st.push(root.left);
            }
        }
        return ans;
    }
}