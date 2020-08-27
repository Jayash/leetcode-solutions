class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        StringBuilder sb = new StringBuilder(s);
        
        String r = sb.reverse().toString();
        
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        for(int i=1; i<= s.length(); i++) {
            for(int j=1; j<=s.length(); j++) {
                if(s.charAt(i-1) == r.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]  +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }
        
        return dp[s.length()][s.length()];
    }
}

/*

    0 c b b d
  0 0 0 0 0 0
  d 0 0 0 0 1
  b 0 0 1 1 1
  b 0 0 
  c 0

*/
