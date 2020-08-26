class Solution {
    
    final int MOD = 1_000_000_007;
    int dp[][] = new int[31][1001];
    
    public int numRollsToTarget(int d, int f, int target) {
        
        if(target < d || target > d*f) return 0;
        
        if(dp[d][target] != 0) return dp[d][target];
        
        if(d == 1) return 1;
        
        int sum = 0;
        
        for(int i=1; i<=f; i++)
            sum = (sum + numRollsToTarget(d-1, f, target - i))%MOD;
        
        dp[d][target] = sum;
        
        return sum;
    }
}
