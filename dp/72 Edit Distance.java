class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        
        
        int[][] dp = new int[word1.length()+1][word2.length()+ 1];
        
        for(int i=0; i<=word1.length(); i++) {
            dp[i][0] = i;
            for(int j=1; j<=word2.length(); j++) {
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                
                
                
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                   dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;

            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}
/*

    0 i n t e n t i o n
  0 0 1 2 3 4 5 6 7 8 9
  e 1 1 2 3 3 4 5 6 7 8
  x 2 2 2 3 4 4 5 6 7 8
  e 3 3 3 3 3 4 5 6 7 8
  c 4 4 4 4 4 4 5 6 7 8
  u 5 5 5 5 5 5 5 6 7 8
  t 6 6 6 5 6 6 5 6 7 8
  i 7 6 7 6 6 7 6 5 6 7
  o 8 7 7 7 7 7 7 6 5 6
  n 9 8 7 8 8 7 8 7 6 5

*/
