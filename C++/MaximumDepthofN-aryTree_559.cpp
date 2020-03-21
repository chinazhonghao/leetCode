/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    int maxDepth(Node* root) {
        queue<Node*> a, b;
        int depth = 0;
        Node* current = root;
        if(current== nullptr){
            return depth;
        }
        a.push(current);
        while(!a.empty() || !b.empty()){
            if(!a.empty()){
                while(!a.empty()){
                    current = a.front();
                    for(int i=0; i<current->children.size(); i++){
                        b.push(current->children[i]);
                    }
                    a.pop();
                }
            }
            else {
                while(!b.empty()){
                    current = b.front();
                    b.pop();
                    for(int i=0; i<current->children.size(); i++){
                        a.push(current->children[i]);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
};