/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node temp=head;
        while(temp!=null){
            Node newnode=new Node(temp.val);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=newnode.next;
        }
        temp=head;
        while(temp!=null){
            Node oldnode=temp;
            Node newnode=temp.next;
            if(oldnode.random!=null){
                newnode.random=oldnode.random.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        Node anshead=head.next;
        while(temp!=null){
            Node oldnode=temp;
            Node newnode=temp.next;
            oldnode.next=newnode.next;
            if(newnode.next!=null){
                newnode.next=newnode.next.next;
            }
            temp=oldnode.next;
        }
        return anshead;
    }
}