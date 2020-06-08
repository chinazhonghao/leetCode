class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String row = String.valueOf(board[i][j]) + "r" + String.valueOf(i);
                String col = String.valueOf(board[i][j]) +"c" + String.valueOf(j);
                String box = String.valueOf(board[i][j]) + "b"+String.valueOf(i/3) + String.valueOf(j/3);

                if(h.contains(row) || h.contains(col) || h.contains(box)){
                    return false;
                }

                h.add(row);
                h.add(col);
                h.add(box);
            }
        }
        return true;
    }
}