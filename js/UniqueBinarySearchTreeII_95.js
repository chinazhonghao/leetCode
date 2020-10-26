/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function(n) {
    if(n < 1){
        return [];
    }
    let pre = [new TreeNode(1)];
    let current = [new TreeNode(1)];

    function deepCopy(node){
        let result = Object.assign({}, node);
        if(!!node.left){
            result.left = deepCopy(node.left);
        }
        if(!!node.right){
            result.right = deepCopy(node.right);
        }
        return result;
    }

    function _add(node, item){
        let result = [];
        let n = deepCopy(node);
        let root = deepCopy(item);
        n.left = root;
        result.push(n);

        root = deepCopy(item);
        let rightChildCounts = 0;
        while(root.right != null){
            root = root.right;
            rightChildCounts++;
        }
        for(let i=0; i<=rightChildCounts; i++){
            let root = deepCopy(item);
            n = deepCopy(node);
            let now = root;
            for(let j=0; j<i; j++){
                root = root.right;
            }
            n.left = root.right;
            root.right = n;
            result.push(now);
        }
        return result;
    };

    for(let i=2; i<=n; i++){
        pre = current.slice();
        current.splice(0);
        let node = new TreeNode(i);
        for(let item of pre){
            current.push(..._add(node, item));
        }
    }
    return current;
};