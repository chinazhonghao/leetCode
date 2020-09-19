class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] bs = new char[3][3];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                bs[i][j] = board[i].charAt(j);
            }
        }
        int countX=0, countO = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(bs[i][j] == 'X'){
                    countX++;
                }
                else if(bs[i][j] == 'O'){
                    countO++;
                }
            }
        }
        if(countX < countO || countX > countO+1){
            return false;
        }

        int rX = 0, rO = 0;
        for(int i=0; i<3; i++){
            if(board[i].equals("XXX")){
                rX++;
            }
            else if(board[i].equals("OOO")){
                rO++;
            }
        }
        if(rX > 1 || rO > 1){
            return false;
        }

        int cX=0, cO=0;
        for(int i=0; i<3; i++){
            if(bs[0][i] == 'X' && bs[1][i] == 'X' && bs[2][i] == 'X'){
                cX++;
            }
            else if(bs[0][i] == 'O' && bs[1][i] == 'O' && bs[2][i] == 'O'){
                cO++;
            }
        }
        if(cX>1 || cO>1){
            return false;
        }

        int X=0, O=0;
        if(bs[0][0] == 'X' && bs[1][1] == 'X' && bs[2][2]=='X'){
            X++;
        }
        else if(bs[0][0] == 'O' && bs[1][1] == 'O' && bs[2][2]=='O'){
            O++;
        }

        if(bs[0][2] == 'X' && bs[1][1] == 'X' && bs[2][0]=='X'){
            X++;
        }
        else if(bs[0][2] == 'O' && bs[1][1] == 'O' && bs[2][0]=='O'){
            O++;
        }

        int _X = X + rX + cX;
        int _O = O + rO + cO;
        if(_X > 2 || _O > 2) {
            return false;
        }
        else if(_X > 0 && _O >0){
            return false;
        }

        if(_X > 0 && (_O > 0 || countO == countX)){
            return false;
        }
        else if(_O>0 && countO < countX){
            return false;
        }
        return true;
    }
}