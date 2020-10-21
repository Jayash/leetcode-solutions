class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int i =0;
        while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        if(i == nums.length - 1) return 1;
        boolean up = nums[i+1] > nums[i] ? true : false;
        int ans = 2; i++;
        while(i < nums.length - 1) {
            
            if(nums[i] == nums[i+1]) { 
                i++;
                continue;
            }
            
            if(up) {
                if(nums[i+1] < nums[i]) {
                    ans++;
                    up = false;
                }
            } else {
                if(nums[i+1] > nums[i]) {
                    ans++;
                    up = true;
                }
            }
            i++;
        }
        return ans;
    }
}
