class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m < 1){
        	return false;
        }
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(board[i][j] == word.charAt(0) && _dfs(board, flag, word, i, j, 1)){
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean _dfs(char[][] board, boolean[][] flag, String word, int i, int j, int index){
    	if(flag[i][j]){
    		return false;
    	}

    	if(index >= word.length()){
    		return true;
    	}

    	flag[i][j] = true;
    	if(i-1>=0 && board[i-1][j]==word.charAt(index) && _dfs(board, flag, word, i-1, j, index+1)){
    		return true;
    	}

    	if(i+1<board.length&&board[i+1][j]==word.charAt(index)&&_dfs(board, flag, word, i+1, j, index+1)){
    		return true;
    	}

    	if(j-1>=0 && board[i][j-1]==word.charAt(index)&&_dfs(board, flag, word, i, j-1, index+1)){
    		return true;
    	}

    	if(j+1<board[0].length&&board[i][j+1]==word.charAt(index)&&_dfs(board, flag, word, i, j+1, index+1)){
    		return true;
    	}
    	flag[i][j] = false;
    	return false;
    }
}