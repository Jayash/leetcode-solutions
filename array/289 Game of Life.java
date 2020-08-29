class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        for(int i=0; i< board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                

                int []count = count(board, i, j);
                
                int numOfLiveCells = count[0];
                int numberOfDeadCells = count[1];
                
                System.out.print(numOfLiveCells + "-" + numberOfDeadCells + " ");
                
                if(board[i][j] == 0) {
                    if(numOfLiveCells == 3) board[i][j] = 2;
                } else {
                    if(numOfLiveCells < 2 || numOfLiveCells > 3) board[i][j] = -2;
                }
                
            }
        }
        
        
        for(int i=0; i< board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                
                if(board[i][j] == -2)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
                
            }
        }
    }
    
    public int[] count(int[][] board, int i, int j) {
        
        int numOfLiveCells = 0;
        int numberOfDeadCells = 0;
        
        if(i > 0) {
            if(board[i-1][j] == 0 || board[i-1][j] == 2) numberOfDeadCells++;
            else numOfLiveCells++;
            
            if(j > 0) {
                if(board[i-1][j-1] == 0 || board[i-1][j-1] == 2) numberOfDeadCells++;
                else numOfLiveCells++;
            }
        }
            
        if(j < board[0].length-1) {
            if(board[i][j+1] == 0 || board[i][j+1] == 2) numberOfDeadCells++;
            else numOfLiveCells++;
            
            if(i > 0) {
                if(board[i-1][j+1] == 0 || board[i-1][j+1] == 2) numberOfDeadCells++;
                else numOfLiveCells++;
            }
        }

        if(i < board.length-1) {
            if(board[i+1][j] == 0 || board[i+1][j] == 2) numberOfDeadCells++;
            else numOfLiveCells++;
            
            if(j < board[0].length - 1) {
                if(board[i+1][j+1] == 0 || board[i+1][j+1] == 2) numberOfDeadCells++;
                else numOfLiveCells++;
            }
        }
        
        if(j > 0) {
            if(board[i][j-1] == 0 || board[i][j-1] == 2) numberOfDeadCells++;
            else numOfLiveCells++;
            
            if(i < board.length - 1) {
                if(board[i+1][j-1] == 0 || board[i+1][j-1] == 2) numberOfDeadCells++;
                else numOfLiveCells++;
            }
        }
        
        return new int[]{numOfLiveCells, numberOfDeadCells};
    }
}
