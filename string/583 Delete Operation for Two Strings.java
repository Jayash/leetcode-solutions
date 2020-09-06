class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        
        int dp[][] = new int[word1.length()+1][word2.length() +1];
        
        for(int i=0; i<= word1.length(); i++) {
            dp[i][0] = i;
            for(int j=1; j<= word2.length(); j++) {
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
                
            }
        }
        
        
        return dp[word1.length()][word2.length()];
    }
}

/*

    0 e a t
  0 0 1 2 3
  s 1 2 3 4
  e 2 1 2 3
  a 3 2 1 2




*/
