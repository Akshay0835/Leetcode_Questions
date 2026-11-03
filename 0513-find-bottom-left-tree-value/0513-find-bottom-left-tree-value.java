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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if(root==null){
            return 0;
        }
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            ArrayList<Integer> sub=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node=q.remove();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                sub.add(node.val);
            }
            list.add(sub);
        }
        return list.get(list.size()-1).get(0);
    }
}