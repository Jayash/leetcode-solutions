class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if(nums.length <= 1 || k==0) return -1;

        Arrays.sort(nums);
        
        int left =  0;
        int right = nums[nums.length-1] - nums[0];
        
        while(left < right) {
            int mid = left + (right - left)/2;
            if(getCount(mid, nums) < k) left = mid + 1;
            else right = mid;            
        }
        
        return left;
    }
    
    public int getCount(int mid, int[] nums) {
        
        int left = 0;
        int count = 0;
        int right = 1;
        
        while(right < nums.length) {
            while(nums[right] - nums[left] > mid) left++;
            
            count += right - left;
            right++;
        }
        
        return count;
    }
}



/*
 2
 5
 0 1 2 3 4 5 6
 1 1 3 4 6 7 8
         |   |
    


*/
