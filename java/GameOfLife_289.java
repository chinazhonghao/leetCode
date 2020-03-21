class Solution {
    public void gameOfLife(int[][] board) {
        int[][] direct = {{1,1}, {1,0}, {1,-1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		int ne = 0;
        		for(int k=0; k<direct.length; k++){
        			int[] d = direct[k];
        			int m = i+d[0];
        			int n = j+d[1];
        			if(m>=0 && m<row && n>=0 && n<col){
        				if(board[m][n]==1 || board[m][n]==-1){
        					ne++;
        				}
        			}
        		}
        		if(ne < 2){
        			if(board[i][j] == 1){
        				board[i][j] = -1;
        			}
        		}
        		else if(ne==3){
        			if(board[i][j] != 1){
        				board[i][j] = 2;
        			}
        		}
        		else if(ne > 3){
        			if(board[i][j] == 1){
        				board[i][j] = -1;
        			}
        		}
        	}
        }
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		if(board[i][j] == -1){
        			board[i][j] = 0;
        		}
        		else if(board[i][j] == 2){
        			board[i][j] = 1;
        		}
        	}
        }
    }
}