class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    
    public boolean backtrack(char[][] board, int i, int j) {
        if(i == 9) return true;
        
        int nextI = j == 8? i+1: i;
        int nextJ = j == 8? 0: j+1;
        
        if(board[i][j] == '.') {
            for(char c='1'; c <= '9'; c++) {
                if(isValid(board, i, j, c - '0')) {
                    board[i][j] = c;
                    if(backtrack(board, nextI, nextJ)) return true;
                    board[i][j] = '.';
                }
            }
        } else {
            return backtrack(board, nextI, nextJ);
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int i, int j, int val) {
        
        for(int row = 0; row<9; row++)
            if((int)(board[row][j] -'0') == val) return false;    
        
        for(int col = 0; col<9; col++)
            if((int)(board[i][col] -'0') == val) return false;  
        
        for(int row= i/3*3; row<= i/3*3+2; row++) {
            for(int col= j/3*3; col <= j/3*3+2; col++) {
                
                int boardVal = board[row][col] - '0';
                
                if(boardVal == val) return false;
            }
        }
        
        return true;
    }
    
}
