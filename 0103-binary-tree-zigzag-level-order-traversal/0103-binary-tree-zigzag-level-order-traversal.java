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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        int flag=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            ArrayList<Integer> sub=new ArrayList<>();
            for(int i=0;i<level;i++){
                root=queue.poll();
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
                sub.add(root.val);
            }
            if(flag==0){
                list.add(sub);
                flag=1;
            }
            else{
                Collections.reverse(sub);
                list.add(sub);
                flag=0;
            }
        }
        return list;
    }
}