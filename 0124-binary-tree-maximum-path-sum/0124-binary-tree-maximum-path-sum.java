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
    static int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
    }
    static int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(0,solve(root.left));
        int rightsum=Math.max(0,solve(root.right));
        max=Math.max(max,leftsum+rightsum+root.val);
        return root.val+Math.max(leftsum,rightsum);
    }
}