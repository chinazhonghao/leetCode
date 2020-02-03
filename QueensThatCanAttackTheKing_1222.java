class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int length = queens.length;
        int[][] board = new int[8][8];
        for(int i=0; i<length; i++){
        	board[queens[i][0]][queens[i][1]] = 1;
        }
        int m = king[0];
        int n = king[1];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<dirs.length; i++){
        	int basem = m+dirs[i][0];
        	int basen = n+dirs[i][1];
        	while(basem>=0 && basem<8 && basen>=0 && basen<8){
        		if(board[basem][basen] > 0){
        			result.add(Arrays.asList(basem, basen));
        			break;
        		}
        		basem += dirs[i][0];
        		basen += dirs[i][1];
        	}
        }
        return result;
    }
}