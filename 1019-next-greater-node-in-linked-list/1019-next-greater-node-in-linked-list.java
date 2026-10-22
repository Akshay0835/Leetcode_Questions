/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> st=new ArrayDeque<>();
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        int ans[]=new int[n];
        temp=head;
        int i=0;
        while(temp!=null){
            while(!st.isEmpty()&&temp.val>ans[st.peek()]){
                ans[st.pop()]=temp.val;
            }
            ans[i]=temp.val;
            st.push(i);
            i++;
            temp=temp.next;
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = 0;
        }
        return ans;
    }
}