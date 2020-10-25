class Solution {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Queue<Node> q = new PriorityQueue<Node>(rows*cols, new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.effort - b.effort;
            }
        });
        int[][] efforts = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;
        Node current = new Node(0, 0, 0);
        q.add(current);
        while(!q.isEmpty()){
            current = q.poll();
            if(current.i==rows-1&&current.j==cols-1){
                return current.effort;
            }
            int i = current.i;
            int j = current.j;
            int effort = current.effort;
            int height = heights[i][j];
            if(i-1>=0){
                int h = heights[i-1][j];
                int d = Math.abs(height - h);
                int update = Math.max(d, effort);
                if(update < efforts[i-1][j]){
                    efforts[i-1][j] = update;
                    q.add(new Node(i-1, j, update));
                }
            }
            if(i+1 < rows){
                int h = heights[i+1][j];
                int d = Math.abs(height - h);
                int update = Math.max(d, effort);
                if(update < efforts[i+1][j]){
                    efforts[i+1][j] = update;
                    q.add(new Node(i+1, j, update));
                }
            }
            if(j-1>=0){
                int h = heights[i][j-1];
                int d = Math.abs(height - h);
                int update = Math.max(d, effort);
                if(update < efforts[i][j-1]){
                    efforts[i][j-1] = update;
                    q.add(new Node(i, j-1, update));
                }
            }
            if(j+1<cols){
                int h = heights[i][j+1];
                int d = Math.abs(height - h);
                int update = Math.max(d, effort);
                if(update < efforts[i][j+1]){
                    efforts[i][j+1] = update;
                    q.add(new Node(i, j+1, update));
                }
            }
        }
        return efforts[rows-1][cols-1];
    }

    private void _recursive(int[][] heights, int[][] efforts, int i, int j){
        int effort = efforts[i][j];
        int height = heights[i][j];
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] buffer = new int[4][2];
        int limit = 0;
        if(i-1>=0){
            int h = heights[i-1][j];
            int d = Math.abs(height - h);
            int update = Math.max(d, effort);
            if(update < efforts[i-1][j]){
                efforts[i-1][j] = update;
                buffer[limit][0] = i-1;
                buffer[limit][1] = j;
                limit++;
            }
        }
        if(i+1 < rows){
            int h = heights[i+1][j];
            int d = Math.abs(height - h);
            int update = Math.max(d, effort);
            if(update < efforts[i+1][j]){
                efforts[i+1][j] = update;
                buffer[limit][0] = i+1;
                buffer[limit][1] = j;
                limit++;
            }
        }
        if(j-1>=0){
            int h = heights[i][j-1];
            int d = Math.abs(height - h);
            int update = Math.max(d, effort);
            if(update < efforts[i][j-1]){
                efforts[i][j-1] = update;
                buffer[limit][0] = i;
                buffer[limit][1] = j-1;
                limit++;
            }
        }
        if(j+1<cols){
            int h = heights[i][j+1];
            int d = Math.abs(height - h);
            int update = Math.max(d, effort);
            if(update < efforts[i][j+1]){
                efforts[i][j+1] = update;
                buffer[limit][0] = i;
                buffer[limit][1] = j+1;
                limit++;
            }
        }
        if(i == rows-1 && j==cols-1){
            return;
        }
        for(int k=0; k<limit; k++){
            _recursive(heights, efforts, buffer[k][0], buffer[k][1]);
        }
    }
}

class Node {
    public Node(int i, int j, int effort){
        this.effort = effort;
        this.i = i;
        this.j = j;
    }
    int effort;
    int i;
    int j;
}