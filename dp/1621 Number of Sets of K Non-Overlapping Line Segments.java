class Solution {
    
    public int numberOfSets(int n, int k) {
        if(n == k+1) return 1;
        int mod = 1_000_000_007;
        long dp[][] = new long[n+1][k+1];
        long prefix[][] = new long[n+1][k+1];
        
        
        for(int i=1; i <= n; i++) {
            
            for(int j=1; j <= k; j++) {
                if(i == 1) dp[i][j] = 0;
                else {
                    if(j == 1) {
                        dp[i][j] = (i * (i-1))/2 % mod;
                        prefix[i][j]= prefix[i-1][j] + dp[i][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + prefix[i-1][j-1]%mod;
                        prefix[i][j] = dp[i][j] + prefix[i-1][j]%mod;
                    }
                }
            }
            
        }

        return (int)(dp[n][k] % 1_000_000_007);
    }
}

/*
    1 2 3 4 5
  1 0 0 0 0 0
  2 1 0 0 0 0
  3 3 1 0 0 0
  4 6 5 1 0 0
  5 10
    
*/
