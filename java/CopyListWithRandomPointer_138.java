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
        Map<Node, Node> m = new HashMap<>();
        Node root = null, current = null;
        current = head;
        while(current != null){
            m.put(current, new Node(current.val));
            current = current.next;
        }
        m.put(null, null);
        while(head != null){
            current = m.get(head);
            if(root == null){
                root = current;
            }
            current.next = m.get(head.next);
            current.random = m.get(head.random);
            head = head.next;
        }
        return root;
    }
}