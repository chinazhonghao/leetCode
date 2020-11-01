class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Node[] nodes = new Node[arr.length];
        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            boolean found = false;
            for(int m=0; m<pieces.length; m++){
                for(int n=0; n<pieces[m].length; n++){
                    if(pieces[m][n] == value){
                        int maxIndex = -1;
                        for(int j=0; j<i; j++){
                            if(nodes[j].index1 == m){
                                maxIndex = Math.max(maxIndex, nodes[j].index2);
                            }
                        }
                        if(maxIndex > n){
                            return false;
                        }
                        Node node = new Node(m, n);
                        nodes[i] = node;
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}

class Node {
    public Node(int index1, int index2){
        this.index1 = index1;
        this.index2 = index2;
    }
    int index1;
    int index2;
}