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
    static void solve(TreeNode root,ArrayList<Integer> list){
        if(root!=null){
            list.add(root.val);
            solve(root.left,list);
            solve(root.right,list);
        }
    }
    public void flatten(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return;
        }
        solve(root,list);
        TreeNode temp=root;
        for(int i=1;i<list.size();i++){
            TreeNode node=new TreeNode(list.get(i));
            temp.left=null;
            temp.right=node;
            temp=node;
        }
    }
}