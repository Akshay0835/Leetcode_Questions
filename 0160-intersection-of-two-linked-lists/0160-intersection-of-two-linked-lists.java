/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> list=new HashSet<>();
        ListNode tempA=headA;
        while(tempA!=null){
            list.add(tempA);
            tempA=tempA.next;
        }
        ListNode tempB=headB;
        ListNode ans=null;
        while(tempB!=null){
            if(list.contains(tempB)){
                ans=tempB;
                break;
            }
            tempB=tempB.next;
        }
        return ans;
    }
}