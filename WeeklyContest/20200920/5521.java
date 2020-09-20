class Solution {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int MAX = 1000000007;
        Node[] current = null;
        Node[] prev = null;
        for(int i=0; i<rows; i++){
            prev = current;
            current = new Node[cols];
            for(int j=0; j<cols; j++){
                long d = (long)grid[i][j];
                current[j] = new Node();
                if(i > 0){
                    Set<Long> data = prev[j].data;
                    for(long item: data){
                        current[j].data.add(item * d);
                    }
                }

                if(j > 0){
                    Set<Long> data = current[j-1].data;
                    for(long item: data){
                        current[j].data.add(item * d);
                    }
                }

                if(i == 0 && j==0){
                    current[j].data.add(d);
                }
            }
        }
        long max = -1;
        Node target = current[cols-1];
        for(long item: target.data){
           max = Math.max(item, max);
        }
        return (int)(max % MAX);
    }
}

class Node {
    public Node(){
        data = new HashSet<>();
    }
    public Set<Long> data;
}