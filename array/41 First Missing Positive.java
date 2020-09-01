class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        
        
        for(int i=0; i< nums.length; i++)
          if(nums[i] <= 0)
              nums[i] = Integer.MAX_VALUE;

        for(int i=0; i< nums.length; i++)
          if(Math.abs(nums[i]) > 0 && Math.abs(nums[i]) <= nums.length)
             nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        
        for(int i=0; i< nums.length; i++)
          if(nums[i] >= 0)
              return i+1;
        
        return nums.length + 1;
    }
}
