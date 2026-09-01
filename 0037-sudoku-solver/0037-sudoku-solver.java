class Solution {
    static boolean findempty(char [][]board,int empty[]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    empty[0]=i;
                    empty[1]=j;
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isSafe(char board[][],char value,int r,int c){
        for(int i=0;i<9;i++){
            if(board[i][c]==value){
                return false;
            }
            if(board[r][i]==value){
                return false;
            }
        }
        int srow=r-(r%3);
        int scol=c-(c%3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int actualr=srow+i;
                int actualc=scol+j;
                if(board[actualr][actualc]==value){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solve(char[][] board){
        int empty[]=new int[2];
        if(!findempty(board,empty)){
            return true;
        }
        int rindex=empty[0];
        int cindex=empty[1];
        for(int i=1;i<=9;i++){
            char charvalue=(char)(i+'0');
            if(isSafe(board,charvalue,rindex,cindex)){
                board[rindex][cindex]=charvalue;
                if(solve(board)){
                    return true;
                }
                board[rindex][cindex]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
       boolean ans= solve(board);
    }
}