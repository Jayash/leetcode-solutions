class Solution {
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        
        return minCost(0, n, cuts, 0, cuts.length-1, new int[cuts.length][cuts.length]);
    }
    
    public int minCost(int start, int end, int[] cuts, int cutStart, int cutEnd, int[][] dp) {
        
        if(cutStart > cutEnd) return 0;
        
        if(cutStart == cutEnd) return end - start;
        
        if(dp[cutStart][cutEnd] != 0) return dp[cutStart][cutEnd];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = cutStart; i <= cutEnd; i++) {
                
                int cut = cuts[i];
                
                int left = minCost(start, cut, cuts, cutStart, i-1, dp);
                
                int right = minCost(cut, end, cuts, i+1, cutEnd, dp);
                
                min = Math.min(min, left + right);
                
        }
        
        dp[cutStart][cutEnd] = min + end - start;
        
        return min + end - start;
    }
}
