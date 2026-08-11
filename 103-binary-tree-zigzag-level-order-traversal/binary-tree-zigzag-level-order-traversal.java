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
 import java.util.Collections;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            int level = 0;
            if (root == null) return ans;

            queue.offer(root);
            while(!queue.isEmpty()){
                int levelNum = queue.size();
                List<Integer> sublist = new ArrayList<Integer>();

                for(int i=0;i<levelNum;i++){
                    TreeNode node = queue.poll();
                    sublist.add(node.val);
                    if(node.left!=null) queue.offer(node.left);
                     if(node.right!=null) queue.offer(node.right);
                }
                level++;
                
                if(level % 2 == 0){
                    //reverse
                    Collections.reverse(sublist);
                    ans.add(sublist);

                }else{
                    ans.add(sublist);
                }
            }
            return ans;
    }
}