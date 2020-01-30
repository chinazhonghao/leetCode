class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int row = points.length;
        int a = points[0][0];
        int b = points[0][1];
        int sum = 0;
        for(int i=1; i<row; i++){
        	int m = points[i][0];
        	int n = points[i][1];
        	int diffx = Math.abs(m - a);
        	int diffy = Math.abs(n - b);
        	if(diffx > diffy){
        		sum += diffx;
        	}
        	else {
        		sum += diffy;
        	}
        	a = m;
        	b = n;
        }
        return sum;
    }
}