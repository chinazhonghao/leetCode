class Solution {
    public int minDays(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(!_search(grid)){
            return 0;
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                grid[i][j] = 0;
                if(!_search(grid)){
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
        return 2;
    }

    private boolean _search(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int sum = 0;
        int m=-1, n=-1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                sum += grid[i][j];
                if(grid[i][j] > 0){
                    m = i;
                    n = j;
                }
            }
        }
        if(sum == 1){
            return true;
        }
        else if(sum == 0){
            return false;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(m,n));
        int count = 0;
        boolean[][] flags = new boolean[row][col];
        flags[m][n] = true;
        while(q.size() > 0){
            Node current = q.poll();
            count++;
            m = current.i;
            n = current.j;
            if(m>0 && grid[m-1][n]>0 && !flags[m-1][n]){
                q.add(new Node(m-1, n));
                flags[m-1][n] = true;
            }
            if(m+1<row && grid[m+1][n]>0 && !flags[m+1][n]){
                q.add(new Node(m+1, n));
                flags[m+1][n] = true;
            }
            if(n>0 && grid[m][n-1] > 0 && !flags[m][n-1]){
                q.add(new Node(m, n-1));
                flags[m][n-1] = true;
            }
            if(n+1<col && grid[m][n+1] > 0 && !flags[m][n+1]){
                q.add(new Node(m, n+1));
                flags[m][n+1] = true;
            }
        }
        return count == sum;
    }
}

class Node {
    public Node(int i, int j){
        this.i = i;
        this.j = j;
    }
    public int i;
    public int j;
}