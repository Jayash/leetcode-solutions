class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int jumps = 0;
        int step = nums[0];
        int i=1;
        int max = nums[0];
        while(i < nums.length) {
            
            if(step > 0) {
                step--;
                max--;
            } else {
                max--;
                step = max;
                jumps++;
            }
            
            max = Math.max(max, nums[i]);
            
            i++;
        }
        return jumps + 1;
    }
}
