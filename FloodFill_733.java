class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Coor> q = new LinkedList<>();
        List<Coor> l = new ArrayList<>();
        q.add(new Coor(sr, sc));
        int row = image.length;
        int col = image[0].length;
        int origin = image[sr][sc];
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
        	Coor coor = q.remove();
            l.add(coor);
        	if(coor.sr+1 < row && (image[coor.sr+1][coor.sc] == origin) && !_exist(l, coor.sr+1, coor.sc)){
        		image[coor.sr+1][coor.sc] = newColor;
        		q.add(new Coor(coor.sr+1, coor.sc));
        	}
        	if(coor.sr-1>=0 && (image[coor.sr-1][coor.sc] == origin) && !_exist(l, coor.sr-1, coor.sc)){
        		image[coor.sr-1][coor.sc] = newColor;
        		q.add(new Coor(coor.sr-1, coor.sc));
        	}
        	if(coor.sc+1<col && (image[coor.sr][coor.sc+1] == origin) && !_exist(l, coor.sr, coor.sc+1)){
        		image[coor.sr][coor.sc+1] = newColor;
        		q.add(new Coor(coor.sr, coor.sc+1));
        	}
        	if(coor.sc-1>=0 && (image[coor.sr][coor.sc-1] == origin) && !_exist(l, coor.sr, coor.sc-1)){
        		image[coor.sr][coor.sc-1] = newColor;
        		q.add(new Coor(coor.sr, coor.sc-1));
        	}
        }
        return image;
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