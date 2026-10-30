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
    static void solve(TreeNode root,List<String> ans,StringBuilder sb){
        if(root==null){
            return;
        }
        int len=sb.length();
        if(len>0){
            sb.append("->");
        }
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            ans.add(sb.toString());
        }
        else{
            solve(root.left,ans,sb);
            solve(root.right,ans,sb);
        }
        while(sb.length()>len){
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        StringBuilder sb=new StringBuilder();
        solve(root,ans,sb);
        return ans;
    }
}