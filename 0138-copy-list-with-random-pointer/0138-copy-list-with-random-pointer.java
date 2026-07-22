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
    public Node deepCopy(Node head1){
        Node temp1 = head1;
        Node head2 = new Node(-1);
        Node temp2 = head2;
        while(temp1!=null){
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        return head2.next;
    }
   
    public Node copyRandomList(Node head1) {
        // Step1 : creating a deep copy without random pointers
        Node head2 =deepCopy(head1);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(null,null);
         Node temp1 = head1;
         Node temp2 = head2;
         while(temp1!=null){
            map.put(temp1,temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
         }
          temp1 = head1;
         while(temp1!=null){
            temp2 = map.get(temp1);
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
         }
         
          

        
        return head2;
    }
}