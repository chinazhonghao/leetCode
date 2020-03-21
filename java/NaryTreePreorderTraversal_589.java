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
    public List<Integer> preorder(Node root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> t = new ArrayList<>();
        Node current = root;
        while(current != null || !s.empty()){
            if(current!=null){
                TreeNode node = new TreeNode(current);
                s.push(node);
                t.add(current.val);
                if(current.children != null && !current.children.isEmpty()){
                    current = current.children.get(0);
                }
                else {
                    current = null;
                }
            }
            else {
                s.pop();
                if(!s.empty()){
                    TreeNode node = s.peek();
                    if(node.node.children.size() > node.index+1){
                        current = node.node.children.get(++node.index);
                    }
                }
            }
        }
        return t;
    }

    public static class TreeNode {
        public TreeNode(Node node) {
            this.node = node;
            this.index = 0;
        }
        public Node node;
        public int index;
    }
}