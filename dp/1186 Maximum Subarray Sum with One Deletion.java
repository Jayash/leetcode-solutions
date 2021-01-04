class Solution {
    public int maximumSum(int[] arr) {
        int maxSum = 0;
        int ans = Integer.MIN_VALUE;
        int MaxSumWithOneDel = 0;
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            
            max = Math.max(max, num);
            
            MaxSumWithOneDel = Math.max(maxSum, MaxSumWithOneDel + num);
            
            maxSum += num;
            
            if(maxSum < 0) maxSum = 0;
            
            ans = Math.max(ans, Math.max(maxSum, MaxSumWithOneDel));
            
        }
        
        if(ans <= 0) return max;
        
        return ans;
    }
}
