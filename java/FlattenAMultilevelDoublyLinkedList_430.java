/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node root = new Node();
        root.val = head.val;
        Node current = root;
        Stack<Node> s = new Stack<>();
        if(head.child != null){
            s.push(head);
            head = head.child;
        }
        else {
            head = head.next;
        }
        while(head != null || !s.empty()){
            if(head != null){
                current.next = new Node();
                current.next.val = head.val;
                current.next.prev = current;
                current = current.next;
                if(head.child != null){
                    s.push(head);
                    head = head.child;
                }
                else {
                    head = head.next;
                }
            }
            else {
                head = s.pop().next;
            }
        }
        return root;
    }
}