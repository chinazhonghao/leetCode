class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int row = coordinates.length;
        int a = coordinates[0][0];
        int b = coordinates[0][1];
        int m = coordinates[1][0];
        int n = coordinates[1][1];
        int diffx = m - a;
        int diffy = n - b;
        for(int i=2; i<row; i++){
        	m = coordinates[i][0];
        	n = coordinates[i][1];
        	int x = m - a;
        	int y = n - b;
        	if(diffy*x != diffx*y){
        		return false;
        	}
        }
        return true;
    }
}