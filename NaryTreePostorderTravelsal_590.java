/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> t = new ArrayList<>();
        Node current = root;
        Node last = null;
        while(current != null || !s.empty()){
            if(current != null){
                TreeNode node = new TreeNode(current);
                s.push(node);
                if(current.children != null && !current.children.isEmpty()){
                    current = current.children.get(0);
                }
                else {
                    current = null;
                }
            }
            else {
                TreeNode node = s.peek();
                current = node.node;
                if(current.children == null || current.children.isEmpty() || current.children.get(current.children.size()-1) == last || 
                    current.children.size() <= node.index+1){
                    t.add(current.val);
                    last = current;
                    current = null;
                    s.pop();
                }
                else {
                    current = current.children.get(++node.index);
                }
            }
        }
        return t;
    }

    public static class TreeNode {
        public Node node;
        public int index;

        public TreeNode(Node node){
            this.node = node;
            this.index = 0;
        }
    }
}