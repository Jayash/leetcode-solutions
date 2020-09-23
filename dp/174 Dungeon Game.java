class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        
        Integer dp[][] = new Integer[dungeon.length][dungeon[0].length];
        
        calculateMinimumHP(dungeon, 0, 0, dp);

        return dp[0][0] == 0? 1 : dp[0][0];
    }
    
    public int calculateMinimumHP(int[][] dungeon, int i, int j, Integer[][] dp) {
        
        if(i == dp.length - 1 && j == dp[0].length -1) {
            dp[i][j] =  dungeon[i][j] <= 0? -dungeon[i][j] + 1 : 0;
            return dp[i][j];
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        if(i < dungeon.length -1)
            min = calculateMinimumHP(dungeon, i+1, j, dp);
        
        if(j < dungeon[0].length - 1)
            min = Math.min(min, calculateMinimumHP(dungeon, i, j+1, dp));
        
        if(dungeon[i][j] <= 0)
            dp[i][j] = min == 0 ? -dungeon[i][j] + 1: min + -dungeon[i][j];
        else
            dp[i][j] = dungeon[i][j] - min < 0? min - dungeon[i][j] : 0;
        
        return dp[i][j];
    }
}


/*
    0 1 2
  0 7 5 2
  1     5
  2     6



*/
