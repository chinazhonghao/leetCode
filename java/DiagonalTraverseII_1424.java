class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int row = nums.size();
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node> (){
            @Override
            public int compare(Node a, Node b){
                if(a.pos > b.pos){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });
        for(int i=0; i<nums.size(); i++){
            List<Integer> l = nums.get(i);
            for(int j=0; j<l.size(); j++){
                long base = ((long)(i+j) * (long)(i+j+1)) >> 1;
                q.add(new Node(base+j, l.get(j)));
            }
        }
        int[] result = new int[q.size()];
        int index = 0;
        Node node = null;
        while((node = q.poll()) != null){
            result[index++] = node.value;
        }
        return result;
    }
}

class Node {
    public Node(long pos, int value){
        this.pos = pos;
        this.value = value;
    }
    public long pos;
    public int value;
}