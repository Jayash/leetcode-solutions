class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double ans[] = new double[nums.length - k + 1];
        if(nums.length == 0) return ans;
        
        TreeSet<Integer> small = new TreeSet<>((a, b) -> nums[a] == nums[b] ? 
                                               a - b : Integer.compare(nums[a],nums[b]));
        TreeSet<Integer> large = new TreeSet<>((a, b) -> nums[a] == nums[b] ? 
                                               a - b : Integer.compare(nums[a],nums[b]));
        
        for(int i=0; i<k; i++) {
            if(small.size() > large.size()) {
                small.add(i);
                large.add(small.pollFirst());
            } else {
                large.add(i);
                small.add(large.pollLast());
            }
        }
        
        int index = 1;
        if(small.size() == large.size()) ans[0] = ((long)nums[small.first()]+nums[large.last()])/2.0;
        else if(small.size() > large.size()) ans[0] = nums[small.first()];
        else ans[0] = nums[large.last()];
        
        for(int i=k; i < nums.length; i++) {
            if(small.contains(i-k)) small.remove(i-k);
            else large.remove(i-k);

            
            if(small.size() > large.size()) {
                small.add(i);
                large.add(small.pollFirst());
            } else {
                large.add(i);
                small.add(large.pollLast());
            }
            
            if(small.size() == large.size()) 
                ans[index] = ((long)nums[small.first()]+nums[large.last()])/2.0;
            else if(small.size() > large.size()) ans[index] = nums[small.first()];
            else ans[index] = nums[large.last()];
            index++;
        }
        
        return ans;
    }

}
