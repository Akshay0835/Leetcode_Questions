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
    static void solve(TreeNode root,ArrayList<String> list,StringBuilder sb){
        if(root==null){
            return;
        }
        int len=sb.length();
        if(len>0){
            sb.append("->");
        }
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            list.add(sb.toString());
        }
        else{
            solve(root.left,list,sb);
            solve(root.right,list,sb);
        }
        while(sb.length()>len){
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<String> list=new ArrayList<>();
        if(root==null){
            return 0;
        }
        StringBuilder sb=new StringBuilder();
        solve(root,list,sb);
        int sum=0;
        for(String s:list){
            String arr[]=s.split("->");
            String num="";
            for(String i:arr){
                num+=i;
            }
            int curr=Integer.parseInt(num);
            sum+=curr;
        }
        return sum;
    }
}