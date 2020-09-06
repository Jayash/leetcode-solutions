class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        if(s.length() < t.length()) return 0;
        
        int dp[][] = new int[t.length()+1][s.length() +1];
        
        for(int i=0; i <= t.length(); i++) {
            dp[i][0] = 0;
            for(int j=i; j <= s.length(); j++) {
                if(i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
                
            }
        }
        
        
        return dp[t.length()][s.length()];
    }
}

/*

    0 r a b b b i t
  0 1 1 1 1 1 1 1 1
  r 0 1 1 1 1 1 1 1
  a 0 0 1 1 1 1 1 1
  b 0 0 0 1 2 3 3 3
  b 0 0 0 0 1 3 3 3
  i 0 
  t 0
  
      0 b a b g b a g
    0 1 1 1 1 1 1 1 1
    b 0 1 1 2 2 3 3 3
    a 0 0 1 1 1 1 4 4
    g 0 0 0 0 1 1 1 5

*/
