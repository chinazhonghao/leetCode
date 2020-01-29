class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(!_isPossible(grid, row, col)){
        	return -1;
        }
        if(!_isFresh(grid, row, col)){
        	return 0;
        }
        Queue<Coor> q = new LinkedList<>();
        List<Coor> l = new ArrayList<>();
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		if(grid[i][j] == 2){
        			q.add(new Coor(i, j));
        		}
        	}
        }
        if(q.isEmpty()){
        	return -1;
        }
        int minutes = 0;
        while(!q.isEmpty()){
        	if(!_isFresh(grid, row, col)){
        		break;
        	}
        	minutes++;
        	List<Coor> coors = new ArrayList<>();
        	for(Coor coor: q){
        		l.add(coor);
	        	if(coor.sr+1 < row && (grid[coor.sr+1][coor.sc] == 1) && !_exist(l, coor.sr+1, coor.sc)){
	        		grid[coor.sr+1][coor.sc] = 2;
	        		coors.add(new Coor(coor.sr+1, coor.sc));
	        	}
	        	if(coor.sr-1>=0 && (grid[coor.sr-1][coor.sc] == 1) && !_exist(l, coor.sr-1, coor.sc)){
	        		grid[coor.sr-1][coor.sc] = 2;
	        		coors.add(new Coor(coor.sr-1, coor.sc));
	        	}
	        	if(coor.sc+1<col && (grid[coor.sr][coor.sc+1] == 1) && !_exist(l, coor.sr, coor.sc+1)){
	        		grid[coor.sr][coor.sc+1] = 2;
	        		coors.add(new Coor(coor.sr, coor.sc+1));
	        	}
	        	if(coor.sc-1>=0 && (grid[coor.sr][coor.sc-1] == 1) && !_exist(l, coor.sr, coor.sc-1)){
	        		grid[coor.sr][coor.sc-1] = 2;
	        		coors.add(new Coor(coor.sr, coor.sc-1));
	        	}
        	}
        	q.clear();
        	q.addAll(coors);
        }
        if(_isFresh(grid, row, col)){
        	return -1;
        }
        return minutes;
    }

    private boolean _isPossible(int[][] grid, int row, int col){
    	for(int i=0; i<row; i++){
    		for(int j=0; j<col; j++){
    			if(grid[i][j] == 1){
    				boolean possible = false;
    				if(i+1 < row && grid[i+1][j]!=0){
    					possible = true;
    				}
    				if(i-1>=0 && grid[i-1][j]!=0){
    					possible = true;
    				}
    				if(j+1<col && grid[i][j+1]!=0){
    					possible = true;
    				}
    				if(j-1>=0 && grid[i][j-1]!=0){
    					possible = true;
    				}
    				if(!possible){
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }

    private boolean _isFresh(int[][] grid, int row, int col){
    	for(int i=0; i<row; i++){
    		for(int j=0; j<col; j++){
    			if(grid[i][j] == 1){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    public static class Coor {
    	public Coor(int sr, int sc){
    		this.sr = sr;
    		this.sc = sc;
    	}

    	public int sr;
    	public int sc;
    }

    private boolean _exist(List<Coor> l, int sr, int sc){
        for(Coor tmp: l){
            if(tmp.sr == sr && tmp.sc == sc){
                return true;
            }
        }
        return false;
    }
}